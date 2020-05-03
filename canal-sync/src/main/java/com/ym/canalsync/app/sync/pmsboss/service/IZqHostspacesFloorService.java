package com.ym.canalsync.app.sync.pmsboss.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesFloor;

/**
 * <p>
 * 楼层 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
public interface IZqHostspacesFloorService extends IService<ZqHostspacesFloor> {

    String getHouseIdByFloorId(String floorId);
}
