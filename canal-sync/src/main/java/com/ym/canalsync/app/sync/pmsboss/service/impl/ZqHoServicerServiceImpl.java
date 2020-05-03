package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServicer;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHoServicerMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoServicerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单个服务类型 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHoServicerServiceImpl extends ServiceImpl<ZqHoServicerMapper, ZqHoServicer> implements IZqHoServicerService {

}
