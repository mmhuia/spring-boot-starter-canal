package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.SysArea;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesFloor;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesHouse;
import com.ym.canalsync.app.sync.pmsboss.mapper.SysAreaMapper;
import com.ym.canalsync.app.sync.pmsboss.service.ISysAreaService;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 区域表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea> implements ISysAreaService {

    @Autowired
    private ZqHostspacesFloorServiceImpl zqHostspacesFloorService;

    @Autowired
    private ZqHostspacesHouseServiceImpl zqHostspacesHouseService;

    @Override
    public String getAreaId(String areaName) {
        if(StringHelper.isNullOrEmptyString(areaName)){
            return "";
        }

        String[] split = areaName.split("/");
        String area = split[split.length-1];


        LambdaQueryWrapper<SysArea> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysArea::getName, area);
        lambdaQueryWrapper.ne(SysArea::getParentId, 0);
        List<SysArea> list = list(lambdaQueryWrapper);
        if(list == null || list.size() == 0){
            return "";
        }
        return list.get(0).getId();
    }

    @Override
    public String getAreaIdByFloorId(String floorId) {
        ZqHostspacesFloor floor = zqHostspacesFloorService.getById(floorId);
        if(floor == null){
            return "";
        }


        ZqHostspacesHouse house = zqHostspacesHouseService.getById(floor.getHouse());
        if(house == null){
            return "";
        }



        return getAreaId(house.getArea());
    }
}
