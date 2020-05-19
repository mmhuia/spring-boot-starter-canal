package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssNodeServerDetail;

/**
 * <p>
 * 外机明细表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
public interface ITBssNodeServerDetailService extends IService<TBssNodeServerDetail> {

    void onInsertOrUpdate(Columns columns, String id);
}
