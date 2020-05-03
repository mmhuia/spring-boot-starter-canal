package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssServerCpu;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssServerCpuMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssServerCpuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务器CPU 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssServerCpuServiceImpl extends ServiceImpl<TBssServerCpuMapper, TBssServerCpu> implements ITBssServerCpuService {

}
