package com.ym.canalsync.app.sync.bossproductdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssHouse;

/**
 * <p>
 * 国家/城市/机房/ 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
public interface ITBssHouseService extends IService<TBssHouse> {

    void onInsertOrUpdate(Columns columns, String id);

    void updateOldHousePart(Columns columns, String id);

    /**
     * @param house 香港机房/1F/大带宽区域
     * @return
     */
    String getHouseId(String house);
}
