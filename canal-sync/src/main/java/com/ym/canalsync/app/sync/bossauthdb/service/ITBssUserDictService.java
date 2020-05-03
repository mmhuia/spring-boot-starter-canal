package com.ym.canalsync.app.sync.bossauthdb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.bossauthdb.entity.TBssUserDict;

/**
 * <p>
 * 用户字典表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
public interface ITBssUserDictService extends IService<TBssUserDict> {

    Integer getValueById(String id);

    TBssUserDict getByKeyNamesAndKeyType(String keyNames, String keyType);
}
