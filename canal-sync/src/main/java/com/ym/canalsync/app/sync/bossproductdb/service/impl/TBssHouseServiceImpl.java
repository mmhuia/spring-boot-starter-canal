package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssHouse;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssHouseMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssHouseService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesFloor;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesHouse;
import com.ym.canalsync.app.sync.pmsboss.service.ISysAreaService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesFloorService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesHouseService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 国家/城市/机房/ 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssHouseServiceImpl extends ServiceImpl<TBssHouseMapper, TBssHouse> implements ITBssHouseService {

    @Autowired
    private IZqHostspacesHouseService iZqHostspacesHouseService;

    @Autowired
    private IZqHostspacesFloorService iZqHostspacesFloorService;

    @Autowired
    private ISysAreaService iSysAreaService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssHouse tBssHouse = new TBssHouse();
        tBssHouse.setId(columns.getValue("id"));
        tBssHouse.setCode(columns.getValue("code"));
        tBssHouse.setName(columns.getValue("name"));
        tBssHouse.setAlias(columns.getValue("alias"));
        tBssHouse.setIsdel(P.pInt(columns.getValue("del_flag")));
        tBssHouse.setCreateTime(columns.getValue("create_date"));
        tBssHouse.setCreateUser(columns.getValue("update_by"));
        tBssHouse.setUpdateTime(columns.getValue("update_date"));
        tBssHouse.setUpdateUser(columns.getValue("update_by"));
        tBssHouse.setNum(columns.getValue("number"));
        tBssHouse.setAddr(columns.getValue("description"));
        tBssHouse.setRemark(columns.getValue("remarks"));


        ZqHostspacesHouse zqHostspacesHouse = iZqHostspacesHouseService.getById(columns.getValue("house"));
        if (zqHostspacesHouse != null) {
            tBssHouse.setDistrictId(iSysAreaService.getAreaId(zqHostspacesHouse.getArea()));
            tBssHouse.setSort(P.pInt(zqHostspacesHouse.getSort()));
            tBssHouse.setOldHouseCode(zqHostspacesHouse.getCode());
            tBssHouse.setOldHouseName(zqHostspacesHouse.getName());
            tBssHouse.setAttribute(P.pInt(zqHostspacesHouse.getAttribution()));
        }

        saveOrUpdate(tBssHouse);
    }

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void updateOldHousePart(Columns columns, String id) {
        String oldHouseId = columns.getValue("id");

        LambdaQueryWrapper<ZqHostspacesFloor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ZqHostspacesFloor::getHouse, oldHouseId);
        List<ZqHostspacesFloor> list = iZqHostspacesFloorService.list(lambdaQueryWrapper);

        if (list == null || list.size() == 0) {
            return;
        }


        TBssHouse tBssHouse = new TBssHouse();
        for (ZqHostspacesFloor floor : list) {
            tBssHouse.setId(floor.getId());
            tBssHouse.setDistrictId(iSysAreaService.getAreaId(columns.getValue("area")));
            tBssHouse.setSort(P.pInt(columns.getValue("sort")));
            tBssHouse.setOldHouseCode(columns.getValue("code"));
            tBssHouse.setOldHouseName(columns.getValue("name"));
            tBssHouse.setAttribute(P.pInt(columns.getValue("attribution")));
            updateById(tBssHouse);
        }
    }

    @Override
    public String getHouseId(String house) {
        if (StringHelper.isNullOrEmptyString(house)) {
            return "";
        }

        String[] split = house.split("/");
        if (split.length < 2) {
            return "";
        }

        String oldHouseName = split[0];
        String houseName = split[1];

        LambdaQueryWrapper<TBssHouse> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(TBssHouse::getOldHouseName, oldHouseName);
        lambdaQueryWrapper.eq(TBssHouse::getName, houseName);

        List<TBssHouse> list = list(lambdaQueryWrapper);

        if (list != null && !list.isEmpty()) {
            return list.get(0).getId();
        } else {
            return "";
        }


    }
}
