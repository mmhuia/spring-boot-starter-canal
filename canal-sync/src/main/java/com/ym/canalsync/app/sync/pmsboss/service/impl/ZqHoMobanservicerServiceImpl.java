package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoMobanservicer;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHoMobanservicerMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoMobanservicerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器模板 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHoMobanservicerServiceImpl extends ServiceImpl<ZqHoMobanservicerMapper, ZqHoMobanservicer> implements IZqHoMobanservicerService {

}
