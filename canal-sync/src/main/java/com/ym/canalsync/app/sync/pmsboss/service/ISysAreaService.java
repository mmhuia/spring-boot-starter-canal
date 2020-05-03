package com.ym.canalsync.app.sync.pmsboss.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.pmsboss.entity.SysArea;

/**
 * <p>
 * 区域表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
public interface ISysAreaService extends IService<SysArea> {

    String getAreaId(String area);

    String getAreaIdByFloorId(String floor);
}
