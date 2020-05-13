package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssCpuModel;

/**
 * <p>
 * CPU型号 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
public interface ITBssCpuModelService extends IService<TBssCpuModel> {

    void onInsertOrUpdate(Columns columns, String id);

    void updateCputypeAttr(Columns columns, String id);
}
