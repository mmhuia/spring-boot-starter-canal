package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssUlocation;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssUlocationMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssUlocationService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * U位 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssUlocationServiceImpl extends ServiceImpl<TBssUlocationMapper, TBssUlocation> implements ITBssUlocationService {

    private static final String OCCUPY = "占用";

    private static final String USABLE = "可用";

    private static final String BOOKED = "已预约";

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssUlocation tBssUlocation = new TBssUlocation();
        tBssUlocation.setId(columns.getValue("id"));
        tBssUlocation.setIsdel(P.pInt(columns.getValue("del_flag")));
        tBssUlocation.setCabinetId(columns.getValue("cabinetid"));
        tBssUlocation.setUw(P.pInt(columns.getValue("uw")));
        tBssUlocation.setDeviceName(columns.getValue("name"));
        tBssUlocation.setDeviceId(columns.getValue("equipmentid"));
        tBssUlocation.setManagerIp(columns.getValue("manage"));
        tBssUlocation.setRemark(columns.getValue("remarks"));
        tBssUlocation.setStatus(getStatus(columns.getValue("state")));
        tBssUlocation.setType(P.pInt(columns.getValue("type")));
        tBssUlocation.setCreateTime(columns.getValue("create_date"));
        tBssUlocation.setCreateUser(columns.getValue("create_by"));
        tBssUlocation.setUpdateTime(columns.getValue("update_date"));
        tBssUlocation.setUpdateUser(columns.getValue("update_by"));
        tBssUlocation.setSubscribeCustomer(columns.getValue("customerid"));
        saveOrUpdate(tBssUlocation);
    }

    @Override
    public Integer getStartUs(String id) {

        LambdaQueryWrapper<TBssUlocation> params = new LambdaQueryWrapper();
        params.eq(TBssUlocation::getIsdel, 0);
        params.eq(TBssUlocation::getDeviceId, id);

        List<TBssUlocation> list = list(params);

        if (list.isEmpty()) {
            return null;
        }

        //yuanman
        list = list.stream().sorted(Comparator.comparing(TBssUlocation::getUw)).collect(Collectors.toList());

        return list.get(0).getUw();
    }

    private Integer getStatus(String state) {
        if (state == null) {
            return 0;
        }

        switch (state) {
            case USABLE:
                return 1;
            case BOOKED:
                return 3;
            default:
                return 0;
        }
    }
}
