package com.ym.canalsync.app.sync.pmsboss.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.pmsboss.entity.CanalZqHoPortView;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
public interface ICanalZqHoPortViewService extends IService<CanalZqHoPortView> {

    CanalZqHoPortView get(String id);
}
