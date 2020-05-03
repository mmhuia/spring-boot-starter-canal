package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssNetworkDevicePort;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssNetworkDevicePortMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssNetworkDevicePortService;
import com.ym.canalsync.app.sync.pmsboss.entity.CanalZqHoPortView;
import com.ym.canalsync.app.sync.pmsboss.service.ICanalZqHoPortViewService;
import com.ym.canalsync.app.utils.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网络设备端口 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssNetworkDevicePortServiceImpl extends ServiceImpl<TBssNetworkDevicePortMapper, TBssNetworkDevicePort> implements ITBssNetworkDevicePortService {

    @Autowired
    private ICanalZqHoPortViewService iCanalZqHoPortViewService;

    @Override
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssNetworkDevicePort t = new TBssNetworkDevicePort();
        t.setId(columns.getValue("id"));
        t.setCreateUser(columns.getValue("create_by"));
        t.setCreateTime(columns.getValue("create_date"));
        t.setUpdateUser(columns.getValue("update_by"));
        t.setUpdateTime(columns.getValue("update_date"));
        t.setRemark(columns.getValue("remarks1"));
        t.setIsdel(P.pInt(columns.getValue("del_flag")));
        t.setPort(columns.getValue("po_port"));
        t.setType(P.pInt(columns.getValue("po_type")));
        t.setSult(P.pInt(columns.getValue("po_sult")));
        t.setSpeed(P.pInt(columns.getValue("po_speed")));
        t.setCareer(P.pInt(columns.getValue("po_career")));
        t.setStatus(P.pInt(columns.getValue("po_usue")));
        t.setUrl(columns.getValue("url"));

        CanalZqHoPortView c = iCanalZqHoPortViewService.get(columns.getValue("id"));
        if(c != null){
            t.setDeviceName(c.getDeviceName());
            t.setDeviceId(c.getDeviceId());
            t.setDeviceNetworkId(c.getDeviceNetworkId());
            t.setNetworkDeviceId(c.getNetworkDeviceId());
        }

        saveOrUpdate(t);
    }
}
