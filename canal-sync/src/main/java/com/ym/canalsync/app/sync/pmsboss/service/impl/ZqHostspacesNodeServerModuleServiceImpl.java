package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesNodeServerModule;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesNodeServerModuleMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesNodeServerModuleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器外机(节点服务器) 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesNodeServerModuleServiceImpl extends ServiceImpl<ZqHostspacesNodeServerModuleMapper, ZqHostspacesNodeServerModule> implements IZqHostspacesNodeServerModuleService {

}
