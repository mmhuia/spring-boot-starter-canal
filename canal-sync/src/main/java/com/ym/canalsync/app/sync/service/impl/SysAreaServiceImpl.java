package com.ym.canalsync.app.sync.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.mdb.DataSource;
import com.ym.canalsync.app.config.mdb.DataSourceEnum;
import com.ym.canalsync.app.route.Column;
import com.ym.canalsync.app.sync.entity.SysArea;
import com.ym.canalsync.app.sync.mapper.SysAreaMapper;
import com.ym.canalsync.app.sync.service.ISysAreaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 区域表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-20
 */
@Service
@DataSource(DataSourceEnum.BOSS_PRODUCT_DB)
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea> implements ISysAreaService {


    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void sync(List<Column> data, String id) {
        SysArea sysArea = new SysArea();
        sysArea.setParentId(data.get(1).getValue());
        sysArea.setName(data.get(2).getValue());
        sysArea.setType(data.get(3).getValue());
        sysArea.setParentIds(data.get(4).getValue());
        sysArea.setCode(data.get(5).getValue());
        sysArea.setSort(Integer.valueOf(data.get(6).getValue()));
        sysArea.setCreateBy(data.get(7).getValue());
        sysArea.setCreateDate(new Date());
        sysArea.setUpdateBy(data.get(1).getValue());
        sysArea.setUpdateDate(new Date());
        sysArea.setRemarks(data.get(10).getValue());
        sysArea.setDelFlag(data.get(11).getValue());
        this.save(sysArea);

        //throw new RuntimeException("模拟异常");
    }
}
