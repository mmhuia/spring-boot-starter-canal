package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssMemoryDetail;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssMemoryDetailMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssHouseService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssMemoryDetailService;
import com.ym.canalsync.app.sync.bossproductdb.service.SequenceService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServersvolumes;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServicer;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesMemorymodule;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoServersvolumesService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoServicerService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesMemorymoduleService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 内存列表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssMemoryDetailServiceImpl extends ServiceImpl<TBssMemoryDetailMapper, TBssMemoryDetail> implements ITBssMemoryDetailService {

    @Autowired
    private IZqHostspacesMemorymoduleService iZqHostspacesMemorymoduleService;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private ITBssHouseService itBssHouseService;

    @Autowired
    private IZqHoServersvolumesService iZqHoServersvolumesService;

    @Autowired
    private IZqHoServicerService iZqHoServicerService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssMemoryDetail tBssMemoryDetail = new TBssMemoryDetail();
        tBssMemoryDetail.setId(id);
        tBssMemoryDetail.setCreateUser(columns.getValue("create_by"));
        tBssMemoryDetail.setCreateTime(columns.getValue("create_date"));
        tBssMemoryDetail.setUpdateUser(columns.getValue("update_by"));
        tBssMemoryDetail.setUpdateTime(columns.getValue("update_date"));
        tBssMemoryDetail.setRemark(columns.getValue("remarks"));
        tBssMemoryDetail.setIsdel(P.pInt(columns.getValue("del_flag")));


        tBssMemoryDetail.setMemModelId(columns.getValue("type_name"));
        tBssMemoryDetail.setPurchasingTime(new Date());
        tBssMemoryDetail.setStorageTime(columns.getValue("create_date"));
        tBssMemoryDetail.setResourceAttribution(1);
        tBssMemoryDetail.setSaleStatus(P.pInt(columns.getValue("use_state")));
        tBssMemoryDetail.setReleaseStatus(P.pInt(columns.getValue("publish_state")));
        tBssMemoryDetail.setSource(1);


        tBssMemoryDetail.setMemCode(getMemCode());
        tBssMemoryDetail.setHouseId(itBssHouseService.getHouseId(columns.getValue("house")));
        tBssMemoryDetail.setServerId(getServerId(P.pInt(columns.getValue("use_state")), id));
        tBssMemoryDetail.setServerManagerIp(getServerManagerIp(tBssMemoryDetail.getServerId()));

        ZqHostspacesMemorymodule zqHostspacesMemorymodule = iZqHostspacesMemorymoduleService.getById(columns.getValue("type_name"));
        if (zqHostspacesMemorymodule != null) {
            tBssMemoryDetail.setShowType(P.pInt(zqHostspacesMemorymodule.getShowMode()));
        }

        tBssMemoryDetail.setCustomerId(null);
        tBssMemoryDetail.setCustomerName(null);


        saveOrUpdate(tBssMemoryDetail);
    }

    @Override
    public String getServerManagerIp(String serverId) {
        if (StringHelper.isNullOrEmptyString(serverId)) {
            return null;
        }

        ZqHoServicer servicer = iZqHoServicerService.getById(serverId);


        return servicer == null ? null : servicer.getSeIp();
    }

    @Override
    public String getServerId(Integer useState, String id) {
        if (useState == null || (useState != 1 && useState != 2)) {
            return null;
        }
        ZqHoServersvolumes zqHoServersvolumes = iZqHoServersvolumesService.getBy(id);

        return zqHoServersvolumes == null ? null : zqHoServersvolumes.getVoServicesid();
    }

    private String getMemCode() {
        return "MEM" + sequenceService.get("mem_sequence");
    }
}
