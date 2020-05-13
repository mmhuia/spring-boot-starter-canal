package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoNese;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHoNeseMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoNeseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 网卡和服务器的中间表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHoNeseServiceImpl extends ServiceImpl<ZqHoNeseMapper, ZqHoNese> implements IZqHoNeseService {

    @Override
    public List<ZqHoNese> getBy(String networkcardId) {
        return list(new LambdaQueryWrapper<ZqHoNese>().eq(ZqHoNese::getNeId, networkcardId));
    }
}
