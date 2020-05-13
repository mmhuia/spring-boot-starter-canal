package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssServerNetwork;

/**
 * <p>
 * 服务器网卡 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
public interface ITBssServerNetworkService extends IService<TBssServerNetwork> {

    void removeBy(String serverId);

    void onInsertOrUpdate(Columns columns, String id);

    void updateServerNetworkAttr(Columns columns, String id);
}
