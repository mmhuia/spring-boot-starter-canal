package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssCpuDetail;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssHouse;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssCpuDetailMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssCpuDetailService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssHouseService;
import com.ym.canalsync.app.sync.bossproductdb.service.SequenceService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesCpumodule;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesCputype;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesCpumoduleService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesCputypeService;
import com.ym.canalsync.app.utils.P;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * CPU列表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-06
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssCpuDetailServiceImpl extends ServiceImpl<TBssCpuDetailMapper, TBssCpuDetail> implements ITBssCpuDetailService {

    @Autowired
    private IZqHostspacesCpumoduleService iZqHostspacesCpumoduleService;

    @Autowired
    private IZqHostspacesCputypeService iZqHostspacesCputypeService;

    @Autowired
    private ITBssHouseService itBssHouseService;

    @Autowired
    private SequenceService sequenceService;

    @Override
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssCpuDetail tBssCpuDetail = new TBssCpuDetail();

        tBssCpuDetail.setId(columns.getValue("id"));
        tBssCpuDetail.setCreateUser(columns.getValue("create_by"));
        tBssCpuDetail.setCreateTime(columns.getValue("create_date"));
        tBssCpuDetail.setUpdateUser(columns.getValue("update_by"));
        tBssCpuDetail.setUpdateTime(columns.getValue("update_date"));
        tBssCpuDetail.setRemark(columns.getValue("remarks"));
        tBssCpuDetail.setIsdel(P.pInt(columns.getValue("del_flag")));

        tBssCpuDetail.setCpuModelId(columns.getValue("type_name"));
        tBssCpuDetail.setStorageTime(columns.getValue("create_date"));
        tBssCpuDetail.setStatus(P.pInt(columns.getValue("use_state")));
        tBssCpuDetail.setPurchasingTime(new Date());
        tBssCpuDetail.setSource(0);
        tBssCpuDetail.setServerId(null);
        tBssCpuDetail.setServerManagerIp(null);

        tBssCpuDetail.setHouseId(getHouseId(columns.getValue("type_name")));
        if (getById(id) == null) {
            tBssCpuDetail.setCpuCode(getCpuCode());
        }

        saveOrUpdate(tBssCpuDetail);
    }

    private String getHouseId(String typeName) {
        if (StringHelper.isNullOrEmptyString(typeName)) {
            return "";
        }

        ZqHostspacesCpumodule zqHostspacesCpumodule = iZqHostspacesCpumoduleService.getById(typeName);
        if (zqHostspacesCpumodule == null || StringHelper.isNullOrEmptyString(zqHostspacesCpumodule.getTypeName())) {
            return "";
        }

        ZqHostspacesCputype zqHostspacesCputype = iZqHostspacesCputypeService.getById(zqHostspacesCpumodule.getTypeName());
        if (zqHostspacesCputype == null || StringHelper.isNullOrEmptyString(zqHostspacesCputype.getHouse())) {
            return "";
        }

        String house = zqHostspacesCputype.getHouse();

        int start = house.indexOf("/");
        int end = house.lastIndexOf("/");

        if (start == -1 && end == -1) {
            return "";
        }

        String houseName;
        if (start == end) {
            houseName = house.substring(start + 1);
        } else {
            houseName = house.substring(start + 1, end);
        }

        if (StringHelper.isNullOrEmptyString(houseName)) {
            return "";
        }

        List<TBssHouse> list = itBssHouseService.list(new LambdaQueryWrapper<TBssHouse>().eq(TBssHouse::getName, houseName));


        return list == null || list.isEmpty() ? "" : list.get(0).getId();
    }

    private String getCpuCode() {
        return "CPU" + sequenceService.get("cpu_sequence");
    }
}
