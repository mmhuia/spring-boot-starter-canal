package com.ym.canalsync.app.sync.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.mdb.DataSource;
import com.ym.canalsync.app.config.mdb.DataSourceEnum;
import com.ym.canalsync.app.route.Column;
import com.ym.canalsync.app.sync.entity.TBssAreainfo;
import com.ym.canalsync.app.sync.mapper.TBssAreainfoMapper;
import com.ym.canalsync.app.sync.service.ITBssAreainfoService;
import com.ym.canalsync.app.utils.Parser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 地区信息表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-24
 */
@Service
public class TBssAreainfoServiceImpl extends ServiceImpl<TBssAreainfoMapper, TBssAreainfo> implements ITBssAreainfoService {

    @Override
    @DataSource(DataSourceEnum.BOSS_PRODUCT_DB)
    public void onInsertOrUpdate(List<Column> data, String id) {
        TBssAreainfo t = new TBssAreainfo();
        t.setId(data.get(0).getValue());
        t.setParId(data.get(1).getValue());
        t.setCode(data.get(5).getValue());
        t.setName(data.get(2).getValue());
        t.setSort(Parser.parseInt(data.get(6).getValue()));
        t.setRemark(data.get(11).getValue());
        t.setIsdel(Parser.parseInt(data.get(12).getValue()));
        t.setCreateTime(data.get(8).getValue());
        t.setCreateUser(data.get(7).getValue());
        t.setUpdateTime(data.get(10).getValue());
        t.setUpdateUser(data.get(9).getValue());
        super.saveOrUpdate(t);
    }

    @Override
    @DataSource(DataSourceEnum.BOSS_PRODUCT_DB)
    public void onDelete(String id) {
        super.removeById(id);

    }
}
