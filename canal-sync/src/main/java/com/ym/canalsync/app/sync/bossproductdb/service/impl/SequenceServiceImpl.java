package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.sync.bossproductdb.mapper.SequenceMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author YuanMan
 * @date 2020-05-08 16:41
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceMapper sequenceMapper;


    @Override
    public String get(String seqName) {
        return sequenceMapper.get(seqName);
    }
}
