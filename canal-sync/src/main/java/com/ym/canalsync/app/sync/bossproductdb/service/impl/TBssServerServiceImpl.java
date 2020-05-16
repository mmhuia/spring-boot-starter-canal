package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossauthdb.entity.TBssUserDict;
import com.ym.canalsync.app.sync.bossauthdb.service.ITBssUserDictService;
import com.ym.canalsync.app.sync.bossproductdb.entity.*;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssServerMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.*;
import com.ym.canalsync.app.sync.pmsboss.entity.*;
import com.ym.canalsync.app.sync.pmsboss.service.*;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务器信息主表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssServerServiceImpl extends ServiceImpl<TBssServerMapper, TBssServer> implements ITBssServerService {

    @Autowired
    private IZqHoMobanservicerService iZqHoMobanservicerService;

    @Autowired
    private ITBssCpuModelService itBssCpuModelService;

    @Autowired
    private ITBssServerCpuService itBssServerCpuService;

    @Autowired
    private ITBssUserDictService itBssUserDictService;

    @Autowired
    private IZqHostspacesCputypeService iZqHostspacesCputypeService;

    @Autowired
    private IZqHostspacesCpumoduleService iZqHostspacesCpumoduleService;

    @Autowired
    private IZqHoServersvolumesService iZqHoServersvolumesService;

    @Autowired
    private ITBssUlocationService itBssUlocationService;

    @Autowired
    private ITBssCabinetService itBssCabinetService;

    @Autowired
    private IZqHoNeseService iZqHoNeseService;

    @Autowired
    private ITBssDiskDetailService itBssDiskDetailService;

    @Autowired
    private ITBssServerDiskService itBssServerDiskService;

    @Autowired
    private ITBssDiskModelService itBssDiskModelService;

    @Autowired
    private ITBssMemoryDetailService itBssMemoryDetailService;

    @Autowired
    private ITBssMemoryModelService itBssMemoryModelService;

    @Autowired
    private ITBssServerMemoryService itBssServerMemoryService;

    @Autowired
    private IZqHoNetworkcardService iZqHoNetworkcardService;

    @Autowired
    private ITBssServerNetworkService itBssServerNetworkService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssServer t = new TBssServer();
        t.setId(id);
        t.setCreateTime(columns.getValue("create_date"));
        t.setCreateUser(columns.getValue("create_by"));
        t.setUpdateTime(columns.getValue("update_date"));
        t.setUpdateUser(columns.getValue("update_by"));
        t.setIsdel(P.pInt(columns.getValue("del_flag")));
        t.setRemark(columns.getValue("remarks"));
        t.setServerIp(columns.getValue("se_ip"));
        t.setStatus(columns.getValue("se_salesstatus"));
        t.setCabinetId(columns.getValue("se_cabinetid"));
        t.setPurchasingTime(columns.getValue("e_purchasingtime"));
        t.setStorageTime(columns.getValue("se_storagetime"));

        t.setBusinessType(null);
        t.setIsRaid(null);
        t.setRaidModelId(null);
        t.setRaidName(null);
        t.setServerDiskHot(null);
        t.setDiskInterfaceType(null);
        t.setServerOneMemory(null);
        t.setServerMemoryType(null);
        t.setServerMemorySpec(null);
        t.setServerDiskSpec(null);
        t.setIsUseRaid(null);

        t.setServerCurrentDisk(getServerCurrentDisk(columns.getValue("id")));
        t.setServerCurrentMemory(getServerCurrentMemory(columns.getValue("id")));
        t.setNetworkNumber(getNetworkNumber(columns.getValue("id")));
        t.setStartUs(getStartUs(columns.getValue("id")));
        t.setLocationId(getLocationId(columns.getValue("se_cabinetid")));

        ZqHoMobanservicer moban = iZqHoMobanservicerService.getById(columns.getValue("se_mobanid"));
        if (moban != null) {
            t.setServerType(moban.getSeUnittype());
            t.setServerDiskSlot(moban.getSeCalicheslotnum());
            t.setServerMemorySlot(moban.getSeEmsnum());
            t.setServerMaxMemory(moban.getSeMemorycapacity());
            t.setServerUs(moban.getSeOccupiednum());
            t.setServerUseType(moban.getSeUsetype());
            t.setShowMode(moban.getSeDisplaytype());
            t.setReleaseStatus(moban.getServiceInsd());

            t.setServerCpuSlot(getServerCpuSlot(moban.getSeCpuid()));
            setSeTempletname(t, moban);

            //save t_bss_server_cpu
            saveTBssServerCpu(t, moban, columns);
        }

        //save t_bss_server_disk
        saveTBssServerDisk(id);
        //save t_bss_server_memory
        saveTBssServerMemory(id);
        //save t_bss_server_network
        saveTBssServerNetwork(id);

        saveOrUpdate(t);
    }

    private void saveTBssServerNetwork(String serverId) {
        LambdaQueryWrapper<TBssServerNetwork> n = new LambdaQueryWrapper();
        n.eq(TBssServerNetwork::getServerId, serverId);
        int count = itBssServerNetworkService.count(n);
        if (count != 0) {
            return;
        }


        LambdaQueryWrapper<ZqHoNese> l = new LambdaQueryWrapper();
        l.eq(ZqHoNese::getSeId, serverId);
        l.eq(ZqHoNese::getDelFlag, 0);
        List<ZqHoNese> list = iZqHoNeseService.list(l);
        if (list == null || list.isEmpty()) {
            return;
        }

        List<TBssServerNetwork> collect = new ArrayList<>();
        for (ZqHoNese nese : list) {
            ZqHoNetworkcard zqHoNetworkcard = iZqHoNetworkcardService.getById(nese.getNeId());
            if (zqHoNetworkcard == null) {
                continue;
            }
            TBssServerNetwork t = new TBssServerNetwork();
            t.setServerId(serverId);
            if (StringHelper.isNullOrEmptyString(nese.getSwitchboardId()) || StringHelper.isNullOrEmptyString(nese.getPortId())) {
                t.setStatus(0);
            } else {
                t.setStatus(1);
            }
            t.setNetwork(zqHoNetworkcard.getNeName());
            t.setNetworkDeviceId(nese.getSwitchboardId());
            t.setNetworkDevicePort(nese.getPortId());
            t.setSpeed(P.pInt(zqHoNetworkcard.getNeType()));
            t.setIsIpmi(P.pInt(zqHoNetworkcard.getIsMangeCard()));
            t.setInterfaceType(P.pInt(zqHoNetworkcard.getNeExport()));
            t.setIsInit(1);
            t.setAddTime(null);
            collect.add(t);
        }

        if (collect.isEmpty()) {
            return;
        }

        itBssServerNetworkService.saveBatch(collect, collect.size());
    }

    private void saveTBssServerMemory(String id) {
        int count = itBssServerMemoryService.count(new LambdaQueryWrapper<TBssServerMemory>().eq(TBssServerMemory::getServerId, id));
        if (count != 0) {
            return;
        }

        List<ZqHoServersvolumes> list = iZqHoServersvolumesService.getBy(id, 1);
        if (list == null || list.isEmpty()) {
            return;
        }

        itBssServerMemoryService.save(list);
    }

    private void saveTBssServerDisk(String id) {
        int count = itBssServerDiskService.count(new LambdaQueryWrapper<TBssServerDisk>().eq(TBssServerDisk::getServerId, id));
        if (count != 0) {
            return;
        }

        List<ZqHoServersvolumes> list = iZqHoServersvolumesService.getBy(id, 2);
        if (list == null || list.isEmpty()) {
            return;
        }


        itBssServerDiskService.save(list);
    }

    private void saveTBssServerCpu(TBssServer t, ZqHoMobanservicer moban, Columns columns) {
        String seCpuid = moban.getSeCpuid();
        if (!StringHelper.isNullOrEmptyString(seCpuid)) {
            TBssCpuModel tBssCpuModel = itBssCpuModelService.getById(seCpuid);
            if (tBssCpuModel != null) {
                t.setServerSpec(tBssCpuModel.getCpuName());

                LambdaQueryWrapper<TBssServerCpu> params = new LambdaQueryWrapper();
                params.eq(TBssServerCpu::getServerId, columns.getValue("id"));
                List<TBssServerCpu> list = itBssServerCpuService.list(params);
                if (list.isEmpty()) {
                    TBssServerCpu tBssServerCpu = new TBssServerCpu();
                    tBssServerCpu.setServerId(columns.getValue("id"));
                    tBssServerCpu.setCpuName(tBssCpuModel.getCpuName());
                    tBssServerCpu.setCpuModelId(tBssCpuModel.getId());
                    tBssServerCpu.setCpuSlot(0);
                    tBssServerCpu.setIsInit(0);
                    tBssServerCpu.setAddTime(new Date());
                    itBssServerCpuService.save(tBssServerCpu);
                }
            }
        }

    }

    private void setSeTempletname(TBssServer t, ZqHoMobanservicer moban) {
        String seTempletname = moban.getSeTempletname();
        if (!StringHelper.isNullOrEmptyString(seTempletname)) {
            String[] s = seTempletname.split("_");
            if (s.length == 1) {
                t.setServerBrand(getServerBrand(s[0]));
            } else {
                if (s.length >= 2) {
                    t.setServerBrand(getServerBrand(s[1]));
                }
                if (s.length >= 3) {
                    String s1 = s[2];
                    t.setServerModel(getServerModel(s1));
                }
            }
        }

    }

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void delete(String id) {
        removeById(id);

        //delete t_bss_server_cpu
        itBssServerCpuService.removeBy(id);

        //delete t_bss_server_disk
        itBssServerDiskService.removeBy(id);

        //delete t_bss_server_memory
        itBssServerMemoryService.removeBy(id);

        //delete t_bss_server_network
        itBssServerNetworkService.removeBy(id);

    }

    private Integer getNetworkNumber(String id) {
        LambdaQueryWrapper<ZqHoNese> params = new LambdaQueryWrapper();
        params.eq(ZqHoNese::getSeId, id);
        params.eq(ZqHoNese::getDelFlag, 0);
        return iZqHoNeseService.count(params);
    }

    private String getLocationId(String seCabinetid) {
        if (StringHelper.isNullOrEmptyString(seCabinetid)) {
            return null;
        }
        TBssCabinet tBssCabinet = itBssCabinetService.getById(seCabinetid);
        return tBssCabinet.getLocationId();
    }

    private Integer getStartUs(String id) {
        return itBssUlocationService.getStartUs(id);
    }

    private Integer getServerCurrentMemory(String id) {
        return iZqHoServersvolumesService.getVoVolumeBy(id, 1);
    }

    private Integer getServerCurrentDisk(String id) {
        return iZqHoServersvolumesService.getVoVolumeBy(id, 2);
    }

    private Integer getServerCpuSlot(String seCpuid) {
        ZqHostspacesCputype zqHostspacesCputype = iZqHostspacesCputypeService.getById(seCpuid);
        if (zqHostspacesCputype != null && !StringHelper.isNullOrEmptyString(zqHostspacesCputype.getName())) {
            String name = zqHostspacesCputype.getName();
            return getSlotNum(name);
        }

        ZqHostspacesCpumodule zqHostspacesCpumodule = iZqHostspacesCpumoduleService.getById(seCpuid);
        if (zqHostspacesCpumodule != null && !StringHelper.isNullOrEmptyString(zqHostspacesCpumodule.getName())) {
            String name = zqHostspacesCpumodule.getName();
            return getSlotNum(name);
        }
        return 0;
    }

    private Integer getSlotNum(String name) {
        if (name.indexOf("*") == -1) {
            return 1;
        }

        String substring = name.substring(0, name.indexOf("*"));

        if (StringHelper.isNullOrEmptyString(substring)) {
            return P.pInt(substring);
        }
        return 0;
    }

    private Integer getServerModel(String s) {
        TBssUserDict tBssUserDict = itBssUserDictService.getByKeyNamesAndKeyType(s, "3");
        return tBssUserDict == null ? null : tBssUserDict.getKeyValues();
    }

    private Integer getServerBrand(String s) {
        TBssUserDict tBssUserDict = itBssUserDictService.getByKeyNamesAndKeyType(s, "4");
        return tBssUserDict == null ? null : tBssUserDict.getKeyValues();
    }
}
