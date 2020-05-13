package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoNetworkcard;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHoNetworkcardMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoNetworkcardService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模板网卡 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHoNetworkcardServiceImpl extends ServiceImpl<ZqHoNetworkcardMapper, ZqHoNetworkcard> implements IZqHoNetworkcardService {

}
