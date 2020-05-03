package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssRegion;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssRegionMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssRegionService;
import com.ym.canalsync.app.sync.pmsboss.service.ISysAreaService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesFloorService;
import com.ym.canalsync.app.utils.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 国家/城市/机房/区域表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssRegionServiceImpl extends ServiceImpl<TBssRegionMapper, TBssRegion> implements ITBssRegionService {

    @Autowired
    private ISysAreaService iSysAreaService;

    @Autowired
    private IZqHostspacesFloorService iZqHostspacesFloorService;

    @Override
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssRegion tBssRegion = new TBssRegion();
        tBssRegion.setId(columns.getValue("id"));
        tBssRegion.setDistrictId(iSysAreaService.getAreaIdByFloorId(columns.getValue("floor")));
        tBssRegion.setHouseId(iZqHostspacesFloorService.getHouseIdByFloorId(columns.getValue("floor")));
        tBssRegion.setCode(columns.getValue("code"));
        tBssRegion.setName(columns.getValue("name"));
        tBssRegion.setRemark(columns.getValue("remarks"));
        tBssRegion.setIsdel(P.pInt(columns.getValue("del_flag")));
        tBssRegion.setCreateTime(columns.getValue("create_date"));
        tBssRegion.setCreateUser(columns.getValue("create_by"));
        tBssRegion.setUpdateTime(columns.getValue("update_date"));
        tBssRegion.setUpdateUser(columns.getValue("update_by"));
        tBssRegion.setSort(0);
        tBssRegion.setPower(columns.getValue("power"));
        tBssRegion.setVoltage(columns.getValue("voltage"));
        tBssRegion.setAmp(columns.getValue("amp"));
        tBssRegion.setRow(P.pInt(columns.getValue("region_row")));
        tBssRegion.setCol(P.pInt(columns.getValue("region_column")));
        tBssRegion.setFzr(columns.getValue("head"));
        tBssRegion.setDescription(columns.getValue("description"));
        tBssRegion.setCabinetUCount(P.pInt(columns.getValue("ubit")));
        tBssRegion.setSpec(columns.getValue("specifications"));
        tBssRegion.setBearing(columns.getValue("bearing"));

        saveOrUpdate(tBssRegion);
    }
}
