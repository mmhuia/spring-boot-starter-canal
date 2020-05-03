package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssCpuModel;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssCpuModelMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssCpuModelService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * CPU型号 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssCpuModelServiceImpl extends ServiceImpl<TBssCpuModelMapper, TBssCpuModel> implements ITBssCpuModelService {

}
