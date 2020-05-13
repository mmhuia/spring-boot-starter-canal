package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssServerMemory;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServersvolumes;

import java.util.List;

/**
 * <p>
 * 服务器内存 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
public interface ITBssServerMemoryService extends IService<TBssServerMemory> {

    void removeBy(String serverId);

    void save(List<ZqHoServersvolumes> list);

    void save(ZqHoServersvolumes e);
}
