package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesNodeServer;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesNodeServerMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesNodeServerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 外机 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesNodeServerServiceImpl extends ServiceImpl<ZqHostspacesNodeServerMapper, ZqHostspacesNodeServer> implements IZqHostspacesNodeServerService {

}
