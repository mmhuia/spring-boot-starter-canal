package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssDiskDetail;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssDiskDetailMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssDiskDetailService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssHouseService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssMemoryDetailService;
import com.ym.canalsync.app.sync.bossproductdb.service.SequenceService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesDiskmodule;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesDiskmoduleService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 磁盘列表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssDiskDetailServiceImpl extends ServiceImpl<TBssDiskDetailMapper, TBssDiskDetail> implements ITBssDiskDetailService {

    @Autowired
    private IZqHostspacesDiskmoduleService iZqHostspacesDiskmoduleService;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private ITBssHouseService itBssHouseService;

    @Autowired
    private ITBssMemoryDetailService itBssMemoryDetailService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssDiskDetail t = new TBssDiskDetail();
        t.setId(id);
        t.setCreateUser(columns.getValue("create_by"));
        t.setCreateTime(columns.getValue("create_date"));
        t.setUpdateUser(columns.getValue("update_by"));
        t.setUpdateTime(columns.getValue("update_date"));
        t.setRemark(columns.getValue("remarks"));
        t.setIsdel(P.pInt(columns.getValue("del_flag")));
        t.setDiskModelId(columns.getValue("disk_module"));
        t.setPurchasingTime(new Date());
        t.setStorageTime(columns.getValue("create_date"));
        t.setSaleStatus(P.pInt(columns.getValue("use_state")));
        t.setReleaseStatus(P.pInt(columns.getValue("publish_state")));
        t.setResourceAttribution(1);
        t.setSource(1);

        t.setDiskCode(getDiskCode());
        t.setHouseId(getHouseId(columns.getValue("house")));
        t.setServerId(getServerId(P.pInt(columns.getValue("use_state")), id));
        t.setServerManagerIp(getServerManagerIp(t.getServerId()));

        t.setCustomerId(null);
        t.setCustomerName(null);

        ZqHostspacesDiskmodule diskModule = iZqHostspacesDiskmoduleService.getById(columns.getValue("disk_module"));
        if (diskModule != null) {
            t.setShowType(P.pInt(diskModule.getShowMode()));
        }

        saveOrUpdate(t);
    }

    private String getServerManagerIp(String serverId) {
        return itBssMemoryDetailService.getServerManagerIp(serverId);
    }

    private String getServerId(Integer useState, String id) {
        return itBssMemoryDetailService.getServerId(useState, id);
    }

    private String getHouseId(String house) {
        if (StringHelper.isNullOrEmptyString(house)) {
            return "";
        }
        return itBssHouseService.getHouseId(house);
    }

    private String getDiskCode() {
        return "DISK" + sequenceService.get("disk_sequence");
    }
}
