package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesNodeItem;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesNodeItemMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesNodeItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 外机(节点服务器) 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesNodeItemServiceImpl extends ServiceImpl<ZqHostspacesNodeItemMapper, ZqHostspacesNodeItem> implements IZqHostspacesNodeItemService {

}
