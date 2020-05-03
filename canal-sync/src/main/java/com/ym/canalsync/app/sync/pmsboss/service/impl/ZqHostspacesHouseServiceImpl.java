package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesHouse;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesHouseMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesHouseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机房管理 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesHouseServiceImpl extends ServiceImpl<ZqHostspacesHouseMapper, ZqHostspacesHouse> implements IZqHostspacesHouseService {

}
