package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServersvolumes;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHoServersvolumesMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoServersvolumesService;
import com.ym.canalsync.app.utils.P;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 存内存或硬盘的容量卡槽 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHoServersvolumesServiceImpl extends ServiceImpl<ZqHoServersvolumesMapper, ZqHoServersvolumes> implements IZqHoServersvolumesService {

    @Override
    @DS(DSEnum.BOSS_PMS)
    public Integer getVoVolumeBy(String voServicesid, int voTyep) {
        if(StringHelper.isNullOrEmptyString(voServicesid)){
            return null;
        }
        LambdaQueryWrapper<ZqHoServersvolumes> param = new LambdaQueryWrapper();
        param.eq(ZqHoServersvolumes::getVoServicesid, voServicesid);
        param.eq(ZqHoServersvolumes::getVoTyep, voTyep);
        param.eq(ZqHoServersvolumes::getDelFlag, 0);

        List<ZqHoServersvolumes> list = list(param);

        if(list.isEmpty()){
            return null;
        }

        int a = 0;
        for(ZqHoServersvolumes z : list){
            a += P.pInt(z.getVoVolume());
        }

        return a;
    }
}
