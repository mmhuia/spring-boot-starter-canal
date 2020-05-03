package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.bossproductdb.entity.VBssAreainfo;
import com.ym.canalsync.app.sync.bossproductdb.mapper.VBssAreainfoMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.IVBssAreainfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class VBssAreainfoServiceImpl extends ServiceImpl<VBssAreainfoMapper, VBssAreainfo> implements IVBssAreainfoService {

}
