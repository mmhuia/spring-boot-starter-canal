package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssCabinet;

/**
 * <p>
 * 机柜 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
public interface ITBssCabinetService extends IService<TBssCabinet> {

    void onInsertOrUpdate(Columns columns, String id);
}
