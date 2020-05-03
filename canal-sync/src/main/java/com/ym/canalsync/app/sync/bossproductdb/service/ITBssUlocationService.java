package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssUlocation;

/**
 * <p>
 * U位 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
public interface ITBssUlocationService extends IService<TBssUlocation> {

    void onInsertOrUpdate(Columns columns, String id);

    Integer getStartUs(String id);
}
