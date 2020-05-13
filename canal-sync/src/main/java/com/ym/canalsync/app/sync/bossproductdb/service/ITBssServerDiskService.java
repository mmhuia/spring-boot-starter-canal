package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssServerDisk;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServersvolumes;

import java.util.List;

/**
 * <p>
 * 服务器磁盘 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
public interface ITBssServerDiskService extends IService<TBssServerDisk> {

    void removeBy(String serverId);

    void save(List<ZqHoServersvolumes> list);

    void save(ZqHoServersvolumes e);
}
