package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssDiskModel;

/**
 * <p>
 * 磁盘型号 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
public interface ITBssDiskModelService extends IService<TBssDiskModel> {

    void onInsertOrUpdate(Columns columns, String id);

    void updateDiskTypeAttr(Columns columns, String id);
}
