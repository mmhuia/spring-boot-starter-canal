package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.CanalZqHoPortView;
import com.ym.canalsync.app.sync.pmsboss.mapper.CanalZqHoPortViewMapper;
import com.ym.canalsync.app.sync.pmsboss.service.ICanalZqHoPortViewService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class CanalZqHoPortViewServiceImpl extends ServiceImpl<CanalZqHoPortViewMapper, CanalZqHoPortView> implements ICanalZqHoPortViewService {

    @Override
    public CanalZqHoPortView get(String id) {
        LambdaQueryWrapper<CanalZqHoPortView> wrapper = new LambdaQueryWrapper();
        wrapper.eq(CanalZqHoPortView::getId, id);
        List<CanalZqHoPortView> list = list(wrapper);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
