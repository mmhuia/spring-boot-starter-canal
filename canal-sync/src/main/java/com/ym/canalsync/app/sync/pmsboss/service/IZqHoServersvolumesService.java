package com.ym.canalsync.app.sync.pmsboss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServersvolumes;

/**
 * <p>
 * 存内存或硬盘的容量卡槽 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
public interface IZqHoServersvolumesService extends IService<ZqHoServersvolumes> {

    Integer getVoVolumeBy(String voServicesid, int voTyep);
}
