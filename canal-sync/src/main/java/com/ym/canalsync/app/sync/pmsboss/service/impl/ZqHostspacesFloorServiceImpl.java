package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesFloor;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesFloorMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesFloorService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 楼层 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesFloorServiceImpl extends ServiceImpl<ZqHostspacesFloorMapper, ZqHostspacesFloor> implements IZqHostspacesFloorService {

    @Override
    public String getHouseIdByFloorId(String floorId) {
        ZqHostspacesFloor floor = getById(floorId);
        if(floor == null){
            return "";
        }
        return floor.getHouse();
    }
}
