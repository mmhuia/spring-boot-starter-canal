package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossauthdb.service.ITBssUserDictService;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssCabinet;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssNetworkDevices;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssNetworkDevicesMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssCabinetService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssNetworkDevicesService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网络设备表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Service
@DS((DSEnum.BOSS_PRODUCT_DB))
public class TBssNetworkDevicesServiceImpl extends ServiceImpl<TBssNetworkDevicesMapper, TBssNetworkDevices> implements ITBssNetworkDevicesService {

    @Autowired
    private ITBssUserDictService itBssUserDictService;

    @Autowired
    private ITBssCabinetService itBssCabinetService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssNetworkDevices tBssNetworkDevices = new TBssNetworkDevices();
        tBssNetworkDevices.setId(columns.getValue("id"));
        tBssNetworkDevices.setCreateUser(columns.getValue("create_by"));
        tBssNetworkDevices.setCreateTime(columns.getValue("create_date"));
        tBssNetworkDevices.setUpdateUser(columns.getValue("update_by"));
        tBssNetworkDevices.setUpdateTime(columns.getValue("update_date"));
        tBssNetworkDevices.setRemark(columns.getValue("remarks"));
        tBssNetworkDevices.setIsdel(P.pInt(columns.getValue("del_flag")));
        tBssNetworkDevices.setLocationId(getLocationId(columns.getValue("bo_cabinetid")));
        tBssNetworkDevices.setCabinetId(columns.getValue("bo_cabinetid"));
        tBssNetworkDevices.setDeviceName(columns.getValue("bo_camname"));
        tBssNetworkDevices.setDeviceType(P.pInt(columns.getValue("bo_camtype")));
        tBssNetworkDevices.setPurchasingtime(columns.getValue("bo_purchasingtime"));
        tBssNetworkDevices.setStoragetime(columns.getValue("bo_storagetime"));
        tBssNetworkDevices.setNum(columns.getValue("bo_num"));
        tBssNetworkDevices.setUw(P.pInt(columns.getValue("bo_ubat")));
        tBssNetworkDevices.setStartubat(P.pInt(columns.getValue("bo_startubat")));
        tBssNetworkDevices.setIp(columns.getValue("bo_ip"));
        tBssNetworkDevices.setModelnumber(itBssUserDictService.getValueById(columns.getValue("bo_modelnumber")));
        tBssNetworkDevices.setStatus(P.pInt(columns.getValue("bo_storage")));
        tBssNetworkDevices.setDeviceSn(null);
        tBssNetworkDevices.setBrand(null);
        tBssNetworkDevices.setTemplateId(null);
        saveOrUpdate(tBssNetworkDevices);
    }

    private String getLocationId(Object cabinetid) {
        if(cabinetid == null){
            return null;
        }

        TBssCabinet tBssCabinet = itBssCabinetService.getById(P.pString(cabinetid));

        return tBssCabinet == null ? "" : tBssCabinet.getLocationId();
    }
}
