package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssServer;

/**
 * <p>
 * 服务器信息主表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
public interface ITBssServerService extends IService<TBssServer> {

    void onInsertOrUpdate(Columns columns, String id);

    void delete(String id);
}
