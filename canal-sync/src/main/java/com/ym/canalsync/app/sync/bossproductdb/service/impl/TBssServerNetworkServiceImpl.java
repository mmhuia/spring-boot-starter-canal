package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssServerNetwork;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssServerNetworkMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssServerNetworkService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoNese;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoNetworkcard;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoNeseService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoNetworkcardService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务器网卡 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssServerNetworkServiceImpl extends ServiceImpl<TBssServerNetworkMapper, TBssServerNetwork> implements ITBssServerNetworkService {

    @Autowired
    private IZqHoNetworkcardService iZqHoNetworkcardService;

    @Autowired
    private IZqHoNeseService iZqHoNeseService;

    @Override
    public void removeBy(String serverId) {
        remove(new LambdaQueryWrapper<TBssServerNetwork>().eq(TBssServerNetwork::getServerId, serverId));
    }

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssServerNetwork t = new TBssServerNetwork();
        t.setId(id);
        t.setServerId(columns.getValue("se_id"));
        t.setNetworkDeviceId(columns.getValue("switchboard_id"));
        t.setNetworkDevicePort(columns.getValue("port_id"));
        t.setStatus(getStatus(columns));
        ZqHoNetworkcard zqHoNetworkcard = getZqHoNetworkcard(columns.getValue("ne_id"));
        if (zqHoNetworkcard != null) {
            t.setNetwork(zqHoNetworkcard.getNeName());
            t.setSpeed(P.pInt(zqHoNetworkcard.getNeType()));
            t.setIsIpmi(P.pInt(zqHoNetworkcard.getIsMangeCard()));
            t.setInterfaceType(P.pInt(zqHoNetworkcard.getNeExport()));
        }

        t.setIsInit(1);


        t.setAddTime(null);

        saveOrUpdate(t);
    }

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void updateServerNetworkAttr(Columns columns, String id) {
        List<ZqHoNese> zqHoNeses = iZqHoNeseService.getBy(id);

        if (zqHoNeses == null || zqHoNeses.isEmpty()) {
            return;
        }

        List<String> ids = zqHoNeses.stream().map(ZqHoNese::getId).collect(Collectors.toList());

        if (ids.isEmpty()) {
            return;
        }

        List<TBssServerNetwork> tBssServerNetworks = listByIds(ids);

        if (tBssServerNetworks == null || tBssServerNetworks.isEmpty()) {
            return;
        }

        tBssServerNetworks.forEach(t -> {
            t.setNetwork(columns.getValue("ne_name"));
            t.setSpeed(P.pInt(columns.getValue("ne_type")));
            t.setIsIpmi(P.pInt(columns.getValue("isMangeCard")));
            t.setInterfaceType(P.pInt(columns.getValue("ne_export")));
        });

        updateBatchById(tBssServerNetworks);
    }

    private ZqHoNetworkcard getZqHoNetworkcard(String neId) {
        if (StringHelper.isNullOrEmptyString(neId)) {
            return null;
        }
        return iZqHoNetworkcardService.getById(neId);
    }

    private Integer getStatus(Columns columns) {
        String switchboarId = columns.getValue("switchboard_id");
        String portId = columns.getValue("port_id");

        if (!StringHelper.isNullOrEmptyString(switchboarId) && !StringHelper.isNullOrEmptyString(portId)) {
            return 1;
        } else {
            return 0;
        }
    }
}
