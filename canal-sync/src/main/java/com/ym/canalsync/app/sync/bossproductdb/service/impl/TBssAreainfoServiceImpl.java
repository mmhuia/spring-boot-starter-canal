package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssAreainfo;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssAreainfoMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssAreainfoService;
import com.ym.canalsync.app.utils.P;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地区信息表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-24
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssAreainfoServiceImpl extends ServiceImpl<TBssAreainfoMapper, TBssAreainfo> implements ITBssAreainfoService {

    @Override
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssAreainfo t = new TBssAreainfo();
        t.setId(columns.getValue("id"));
        t.setParId(columns.getValue("parent_id"));
        t.setCode(columns.getValue("code"));
        t.setName(columns.getValue("name"));
        t.setSort(P.pInt(columns.getValue("sort")));
        t.setRemark(columns.getValue("remarks"));
        t.setIsdel(P.pInt(columns.getValue("del_flag")));
        t.setCreateTime(columns.getValue("create_date"));
        t.setCreateUser(columns.getValue("create_by"));
        t.setUpdateTime(columns.getValue("update_date"));
        t.setUpdateUser(columns.getValue("update_by"));
        super.saveOrUpdate(t);
    }
}
