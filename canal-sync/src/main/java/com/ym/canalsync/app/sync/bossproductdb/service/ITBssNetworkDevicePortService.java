package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssNetworkDevicePort;

/**
 * <p>
 * 网络设备端口 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
public interface ITBssNetworkDevicePortService extends IService<TBssNetworkDevicePort> {

    void onInsertOrUpdate(Columns columns, String id);
}
