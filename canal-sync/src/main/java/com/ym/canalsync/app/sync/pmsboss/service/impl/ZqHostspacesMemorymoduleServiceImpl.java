package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesMemorymodule;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesMemorymoduleMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesMemorymoduleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内存模板 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-08
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesMemorymoduleServiceImpl extends ServiceImpl<ZqHostspacesMemorymoduleMapper, ZqHostspacesMemorymodule> implements IZqHostspacesMemorymoduleService {

}
