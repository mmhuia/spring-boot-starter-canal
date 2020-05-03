package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssCabinet;
import com.ym.canalsync.app.sync.bossproductdb.entity.VBssAreainfo;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssCabinetMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssCabinetService;
import com.ym.canalsync.app.sync.bossproductdb.service.IVBssAreainfoService;
import com.ym.canalsync.app.utils.P;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 机柜 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssCabinetServiceImpl extends ServiceImpl<TBssCabinetMapper, TBssCabinet> implements ITBssCabinetService {

    @Autowired
    private IVBssAreainfoService ivBssAreainfoService;

    @Override
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssCabinet tBssCabinet = new TBssCabinet();
        tBssCabinet.setId(columns.getValue("id"));
        tBssCabinet.setRow(P.pInt(columns.getValue("row")));
        tBssCabinet.setCoulmn(P.pInt(columns.getValue("lie")));
        tBssCabinet.setName(columns.getValue("name"));
        tBssCabinet.setUs(P.pInt(columns.getValue("alwaysdigits")));
        tBssCabinet.setSpec(columns.getValue("specifications"));
        tBssCabinet.setVoltage(columns.getValue("voltage"));
        tBssCabinet.setAmp(columns.getValue("amp"));
        tBssCabinet.setPower(columns.getValue("power"));
        tBssCabinet.setBearing(columns.getValue("bearing"));
        tBssCabinet.setAttribute(P.pInt(columns.getValue("attribute")));
        tBssCabinet.setIsdel(P.pInt(columns.getValue("del_flag")));
        tBssCabinet.setCreateTime(columns.getValue("create_date"));
        tBssCabinet.setCreateUser(columns.getValue("create_by"));
        tBssCabinet.setUpdateTime(columns.getValue("update_date"));
        tBssCabinet.setUpdateUser(columns.getValue("update_by"));
        tBssCabinet.setLocationId(getLocationId(columns.getValue("remarks")));
        tBssCabinet.setRegionId(columns.getValue("remarks"));
        tBssCabinet.setRemark(columns.getValue("remarks_s"));
        tBssCabinet.setType(getType(columns.getValue("del_flag")));
        tBssCabinet.setStatus(P.pInt(columns.getValue("denominated")));
        saveOrUpdate(tBssCabinet);
    }

    private Integer getType(Object value) {
        int i = P.pInt(value);

        if (i == 0) {
            return 0;
        } else if (i == 2) {
            return 1;
        }

        return i;
    }

    private String getLocationId(Object value) {
        String regionId = P.pString(value);
        if (StringHelper.isNullOrEmptyString(regionId)) {
            return "";
        }


        Wrapper filter = new LambdaQueryWrapper<VBssAreainfo>().eq(VBssAreainfo::getRegionId, regionId);
        List<VBssAreainfo> list = ivBssAreainfoService.list(filter);

        if (list == null || list.size() == 0) {
            return "";
        }

        return list.get(0).getFullLocationId();
    }
}
