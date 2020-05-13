package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssDiskDetail;

/**
 * <p>
 * 磁盘列表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
public interface ITBssDiskDetailService extends IService<TBssDiskDetail> {

    void onInsertOrUpdate(Columns columns, String id);
}
