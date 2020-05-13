package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssCpuDetail;

/**
 * <p>
 * CPU列表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-06
 */
public interface ITBssCpuDetailService extends IService<TBssCpuDetail> {

    void onInsertOrUpdate(Columns columns, String id);
}
