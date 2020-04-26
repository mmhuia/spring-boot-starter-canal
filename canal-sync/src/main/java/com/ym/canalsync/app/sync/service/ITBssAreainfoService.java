package com.ym.canalsync.app.sync.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Column;
import com.ym.canalsync.app.sync.entity.TBssAreainfo;

import java.util.List;

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
     *
     * @param data
     * @param id
     */
    void onInsertOrUpdate(List<Column> data, String id);

    /**
     *
     * @param id
     */
    void onDelete(String id);
}
