package com.ym.canalsync.app.sync.bossauthdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.bossauthdb.entity.TBssDict;
import com.ym.canalsync.app.sync.bossauthdb.mapper.TBssDictMapper;
import com.ym.canalsync.app.sync.bossauthdb.service.ITBssDictService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统字典表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Service
@DS(DSEnum.BOSS_AUTH_DB)
public class TBssDictServiceImpl extends ServiceImpl<TBssDictMapper, TBssDict> implements ITBssDictService {

}
