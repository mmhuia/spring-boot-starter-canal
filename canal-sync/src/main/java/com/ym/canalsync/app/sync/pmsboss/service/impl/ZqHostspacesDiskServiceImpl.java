package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesDisk;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesDiskMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesDiskService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 硬盘入库后 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-11
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesDiskServiceImpl extends ServiceImpl<ZqHostspacesDiskMapper, ZqHostspacesDisk> implements IZqHostspacesDiskService {

}
