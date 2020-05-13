package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssDiskDetail;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssDiskModel;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssServerDisk;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssServerDiskMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssDiskDetailService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssDiskModelService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssServerDiskService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServersvolumes;
import com.ym.canalsync.app.utils.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务器磁盘 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssServerDiskServiceImpl extends ServiceImpl<TBssServerDiskMapper, TBssServerDisk> implements ITBssServerDiskService {

    @Autowired
    private ITBssDiskDetailService itBssDiskDetailService;

    @Autowired
    private ITBssDiskModelService itBssDiskModelService;

    @Override
    public void removeBy(String serverId) {
        remove(new LambdaQueryWrapper<TBssServerDisk>().eq(TBssServerDisk::getServerId, serverId));
    }

    @Override
    public void save(List<ZqHoServersvolumes> list) {
        list.forEach(this::save);
    }

    @Override
    public void save(ZqHoServersvolumes e) {
        TBssDiskModel tBssDiskModel;
        int isInit;
        Date addTime;
        if ("1".equals(e.getRemarks())) {
            TBssDiskDetail tBssDiskDetail = itBssDiskDetailService.getById(e.getVoVolumeid());
            tBssDiskModel = itBssDiskModelService.getById(tBssDiskDetail.getDiskModelId());
            isInit = 0;
            addTime = new Date();
        } else {
            tBssDiskModel = itBssDiskModelService.getById(e.getVoVolumeid());
            isInit = 1;
            addTime = null;
        }

        if (tBssDiskModel != null) {
            TBssServerDisk tBssServerDisk = new TBssServerDisk();
            tBssServerDisk.setId(e.getId());
            tBssServerDisk.setServerId(e.getVoServicesid());
            tBssServerDisk.setDiskName(tBssDiskModel.getDiskName());
            tBssServerDisk.setDiskModelId(tBssDiskModel.getId());
            tBssServerDisk.setDiskSize(P.pInt(e.getVoVolume()));
            tBssServerDisk.setDiskSlot(P.pInt(e.getVoCardslot()));
            tBssServerDisk.setIsInit(isInit);
            tBssServerDisk.setAddTime(addTime);
            saveOrUpdate(tBssServerDisk);
        }
    }
}
