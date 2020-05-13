package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssServerDiskService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssServerMemoryService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServersvolumes;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHoServersvolumesMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoServersvolumesService;
import com.ym.canalsync.app.utils.P;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ITBssServerDiskService itBssServerDiskService;

    @Autowired
    private ITBssServerMemoryService itBssServerMemoryService;

    @Override
    public Integer getVoVolumeBy(String voServicesid, int voTyep) {
        if (StringHelper.isNullOrEmptyString(voServicesid)) {
            return null;
        }
        LambdaQueryWrapper<ZqHoServersvolumes> param = new LambdaQueryWrapper();
        param.eq(ZqHoServersvolumes::getVoServicesid, voServicesid);
        param.eq(ZqHoServersvolumes::getVoTyep, voTyep);
        param.eq(ZqHoServersvolumes::getDelFlag, 0);

        List<ZqHoServersvolumes> list = list(param);

        if (list.isEmpty()) {
            return null;
        }

        int a = 0;
        for (ZqHoServersvolumes z : list) {
            a += P.pInt(z.getVoVolume());
        }

        return a;
    }

    @Override
    public List<ZqHoServersvolumes> getBy(String voServicesid, int voTyep) {
        if (StringHelper.isNullOrEmptyString(voServicesid)) {
            return null;
        }
        LambdaQueryWrapper<ZqHoServersvolumes> param = new LambdaQueryWrapper();
        param.eq(ZqHoServersvolumes::getVoServicesid, voServicesid);
        param.eq(ZqHoServersvolumes::getVoTyep, voTyep);
        param.eq(ZqHoServersvolumes::getDelFlag, 0);

        return list(param);
    }

    @Override
    public ZqHoServersvolumes getBy(String voVolumeid) {
        if (StringHelper.isNullOrEmptyString(voVolumeid)) {
            return null;
        }
        LambdaQueryWrapper<ZqHoServersvolumes> param = new LambdaQueryWrapper();
        param.eq(ZqHoServersvolumes::getVoVolumeid, voVolumeid);
        param.eq(ZqHoServersvolumes::getDelFlag, 0);
        List<ZqHoServersvolumes> list = list(param);

        return list == null || list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void onInsertOrUpdate(Columns columns, String id) {
        ZqHoServersvolumes e = getById(id);
        if (e == null) {
            return;
        }

        String voTyep = e.getVoTyep();
        if ("1".equals(voTyep)) {
            itBssServerMemoryService.save(e);
        } else if ("2".equals(voTyep)) {
            itBssServerDiskService.save(e);
        }
    }

    @Override
    public void delete(Columns columns, String id) {
        itBssServerMemoryService.removeById(id);
        itBssServerDiskService.removeById(id);
    }
}
