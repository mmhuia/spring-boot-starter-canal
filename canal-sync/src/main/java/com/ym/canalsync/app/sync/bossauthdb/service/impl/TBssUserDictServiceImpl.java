package com.ym.canalsync.app.sync.bossauthdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.bossauthdb.entity.TBssUserDict;
import com.ym.canalsync.app.sync.bossauthdb.mapper.TBssUserDictMapper;
import com.ym.canalsync.app.sync.bossauthdb.service.ITBssUserDictService;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户字典表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Service
@DS(DSEnum.BOSS_AUTH_DB)
public class TBssUserDictServiceImpl extends ServiceImpl<TBssUserDictMapper, TBssUserDict> implements ITBssUserDictService {

    @Override
    public Integer getValueById(String id) {
        if (StringHelper.isNullOrEmptyString(id)) {
            return -1;
        }

        TBssUserDict tBssUserDict = getById(id);

        return tBssUserDict == null ? -1 : tBssUserDict.getKeyValues();
    }

    @Override
    public TBssUserDict getByKeyNamesAndKeyType(String keyNames, String keyType) {
        LambdaQueryWrapper<TBssUserDict> param = new LambdaQueryWrapper<>();
        param.eq(TBssUserDict::getKeyNames, keyNames);
        param.eq(TBssUserDict::getKeyType, keyType);
        List<TBssUserDict> list = list(param);
        return list.isEmpty() ? null : list.get(0);
    }
}
