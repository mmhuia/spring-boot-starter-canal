package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesDisktype;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesDisktypeMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesDisktypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 硬盘类型 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-11
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesDisktypeServiceImpl extends ServiceImpl<ZqHostspacesDisktypeMapper, ZqHostspacesDisktype> implements IZqHostspacesDisktypeService {

}
