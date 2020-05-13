package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesMemory;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesMemoryMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesMemoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 入库后的内存 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-08
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesMemoryServiceImpl extends ServiceImpl<ZqHostspacesMemoryMapper, ZqHostspacesMemory> implements IZqHostspacesMemoryService {

}
