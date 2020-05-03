package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssAreainfo;

/**
 * <p>
 * 地区信息表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-24
 */
public interface ITBssAreainfoService extends IService<TBssAreainfo> {

    /**
     * @param columns
     * @param id
     */
    void onInsertOrUpdate(Columns columns, String id);
}
