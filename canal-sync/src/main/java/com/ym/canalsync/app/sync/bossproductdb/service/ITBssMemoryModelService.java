package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssMemoryModel;

/**
 * <p>
 * 内存型号 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
public interface ITBssMemoryModelService extends IService<TBssMemoryModel> {

    void onInsertOrUpdate(Columns columns, String id);

    void updateMemoryTypeAttr(Columns columns, String id);
}
