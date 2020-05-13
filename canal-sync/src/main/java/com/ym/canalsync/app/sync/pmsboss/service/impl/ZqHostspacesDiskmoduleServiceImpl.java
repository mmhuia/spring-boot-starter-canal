package com.ym.canalsync.app.sync.pmsboss.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesDiskmodule;
import com.ym.canalsync.app.sync.pmsboss.mapper.ZqHostspacesDiskmoduleMapper;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesDiskmoduleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 硬盘模板 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-11
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class ZqHostspacesDiskmoduleServiceImpl extends ServiceImpl<ZqHostspacesDiskmoduleMapper, ZqHostspacesDiskmodule> implements IZqHostspacesDiskmoduleService {

    @Override
    public List<ZqHostspacesDiskmodule> getBy(String typeName) {
        return list(new LambdaQueryWrapper<ZqHostspacesDiskmodule>().eq(ZqHostspacesDiskmodule::getTypeName, typeName));
    }
}
