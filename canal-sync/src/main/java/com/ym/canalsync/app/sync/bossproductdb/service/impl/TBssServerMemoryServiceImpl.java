package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssMemoryDetail;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssMemoryModel;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssServerMemory;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssServerMemoryMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssMemoryDetailService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssMemoryModelService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssServerMemoryService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServersvolumes;
import com.ym.canalsync.app.utils.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务器内存 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssServerMemoryServiceImpl extends ServiceImpl<TBssServerMemoryMapper, TBssServerMemory> implements ITBssServerMemoryService {

    @Autowired
    private ITBssMemoryDetailService itBssMemoryDetailService;

    @Autowired
    private ITBssMemoryModelService itBssMemoryModelService;

    @Override
    public void removeBy(String serverId) {
        remove(new LambdaQueryWrapper<TBssServerMemory>().eq(TBssServerMemory::getServerId, serverId));
    }

    @Override
    public void save(List<ZqHoServersvolumes> list) {
        list.forEach(this::save);
    }

    @Override
    public void save(ZqHoServersvolumes e) {
        TBssMemoryModel tBssMemoryModel;
        int isInit;
        Date addTime;
        if ("1".equals(e.getRemarks())) {
            TBssMemoryDetail tBssMemoryDetail = itBssMemoryDetailService.getById(e.getVoVolumeid());
            tBssMemoryModel = itBssMemoryModelService.getById(tBssMemoryDetail.getMemModelId());
            isInit = 0;
            addTime = new Date();
        } else {
            tBssMemoryModel = itBssMemoryModelService.getById(e.getVoVolumeid());
            isInit = 1;
            addTime = null;
        }

        if (tBssMemoryModel != null) {
            TBssServerMemory t = new TBssServerMemory();
            t.setId(e.getId());
            t.setServerId(e.getVoServicesid());
            t.setMemoryName(tBssMemoryModel.getMemName());
            t.setMemoryModelId(tBssMemoryModel.getId());
            t.setMemorySize(P.pInt(e.getVoVolume()));
            t.setMemorySlot(P.pInt(e.getVoCardslot()));
            t.setIsInit(isInit);
            t.setAddTime(addTime);
            saveOrUpdate(t);
        }
    }
}
