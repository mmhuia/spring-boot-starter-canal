package com.ym.canalsync.app.sync.bossproductdb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssRegion;

/**
 * <p>
 * 国家/城市/机房/区域表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
public interface ITBssRegionService extends IService<TBssRegion> {

    void onInsertOrUpdate(Columns columns, String id);
}
