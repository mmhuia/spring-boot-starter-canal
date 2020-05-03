package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesCputype;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesCputypeMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesCputypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * CPU类型 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesCputypeServiceImpl extends ServiceImpl<ZqHostspacesCputypeMapper, ZqHostspacesCputype> implements IZqHostspacesCputypeService {

}
