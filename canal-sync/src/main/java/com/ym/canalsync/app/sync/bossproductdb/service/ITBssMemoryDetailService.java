package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssMemoryDetail;

/**
 * <p>
 * 内存列表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
public interface ITBssMemoryDetailService extends IService<TBssMemoryDetail> {

    void onInsertOrUpdate(Columns columns, String id);

    String getServerManagerIp(String serverId);

    String getServerId(Integer useState, String id);
}
