package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssNodeServerMaster;

/**
 * <p>
 * 外机主表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
public interface ITBssNodeServerMasterService extends IService<TBssNodeServerMaster> {

    void onInsertOrUpdate(Columns columns, String id);

    void updateNodeServerModuleAttr(Columns columns, String id);
}
