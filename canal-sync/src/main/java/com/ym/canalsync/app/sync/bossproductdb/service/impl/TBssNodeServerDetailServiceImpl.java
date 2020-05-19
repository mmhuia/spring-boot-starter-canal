package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssNodeServerDetail;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssNodeServerDetailMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssNodeServerDetailService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoServicerService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 外机明细表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssNodeServerDetailServiceImpl extends ServiceImpl<TBssNodeServerDetailMapper, TBssNodeServerDetail> implements ITBssNodeServerDetailService {

    @Autowired
    private IZqHoServicerService iZqHoServicerService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssNodeServerDetail t = new TBssNodeServerDetail();
        t.setId(columns.getValue("id"));
        t.setIsdel(P.pInt(columns.getValue("del_flag")));
        t.setCreateTime(columns.getValue("create_date"));
        t.setCreateUser(columns.getValue("create_by"));
        t.setUpdateTime(columns.getValue("update_date"));
        t.setUpdateUser(columns.getValue("update_by"));
        t.setRemark(columns.getValue("remarks"));


        t.setNodeMasterId(columns.getValue("node_server_id"));
        t.setNode(columns.getValue("node"));
        t.setServerIp(columns.getValue("server_ip"));
        t.setServerName(columns.getValue("server_name"));
        t.setServerId(columns.getValue("server_id"));
        t.setIsOccupy(columns.getValue("is_occupy"));
        t.setSort(columns.getValue("sort"));
        t.setStatus(getStatus(columns.getValue("server_id")));


        saveOrUpdate(t);
    }

    private Integer getStatus(String serverId) {
        return iZqHoServicerService.getSeSalesstatus(serverId);
    }
}
