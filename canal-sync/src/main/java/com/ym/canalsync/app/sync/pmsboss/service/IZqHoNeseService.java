package com.ym.canalsync.app.sync.pmsboss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoNese;

import java.util.List;

/**
 * <p>
 * 网卡和服务器的中间表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
public interface IZqHoNeseService extends IService<ZqHoNese> {

    List<ZqHoNese> getBy(String networkcardId);
}
