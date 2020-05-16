package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssMemoryDetail;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssMemoryModel;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssMemoryModelMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssMemoryDetailService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssMemoryModelService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesMemorymodule;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesMemorytype;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesMemorymoduleService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesMemorytypeService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 内存型号 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssMemoryModelServiceImpl extends ServiceImpl<TBssMemoryModelMapper, TBssMemoryModel> implements ITBssMemoryModelService {

    @Autowired
    private IZqHostspacesMemorytypeService iZqHostspacesMemorytypeService;

    @Autowired
    private ITBssMemoryDetailService itBssMemoryDetailService;

    @Autowired
    private IZqHostspacesMemorymoduleService iZqHostspacesMemorymoduleService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssMemoryModel t = new TBssMemoryModel();
        t.setId(id);
        t.setCreateUser(columns.getValue("create_by"));
        t.setCreateTime(columns.getValue("create_date"));
        t.setUpdateUser(columns.getValue("update_by"));
        t.setUpdateTime(columns.getValue("update_date"));
        t.setRemark(columns.getValue("remarks"));
        t.setIsdel(P.pInt(columns.getValue("del_flag")));
        t.setMemBrand(columns.getValue("brand"));

        t.setMemSpec(getMemSpec(columns.getValue("name")));
        t.setMemVerify(getMemVerify(columns.getValue("name")));
        ZqHostspacesMemorytype zqHostspacesMemorytype = iZqHostspacesMemorytypeService.getById(columns.getValue("type_name"));
        if (zqHostspacesMemorytype != null) {
            t.setMemSize(P.pInt(zqHostspacesMemorytype.getMemoryCapacity()));
            t.setMemType(getMemType(zqHostspacesMemorytype.getMemoryType()));
            t.setMemHz(getMemHz(zqHostspacesMemorytype.getMemoryZp()));
        }

        t.setMemName(getMemName(t, columns, zqHostspacesMemorytype));

        t.setProductMapId(null);
        t.setMemModel(null);

        saveOrUpdate(t);
        updateTBssMemoryDetail(id, columns.getValue("show_mode"));
    }

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void updateMemoryTypeAttr(Columns columns, String id) {
        int memoryCapacity = P.pInt(columns.getValue("memory_capacity"));
        Integer memoryType = getMemType(columns.getValue("memory_type"));
        String memoryZp = getMemHz(columns.getValue("memory_zp"));

        List<ZqHostspacesMemorymodule> list = iZqHostspacesMemorymoduleService.list(
                new LambdaQueryWrapper<ZqHostspacesMemorymodule>().eq(ZqHostspacesMemorymodule::getTypeName, id)
        );

        if (list == null || list.isEmpty()) {
            return;
        }

        List<TBssMemoryModel> list2 = new ArrayList<>();
        for (ZqHostspacesMemorymodule z : list) {
            TBssMemoryModel t = getById(z.getId());
            if (t != null) {
                t.setMemSize(memoryCapacity);
                t.setMemType(memoryType);
                t.setMemHz(memoryZp);
                list2.add(t);
            }
        }

        if (list2.isEmpty()) {
            return;
        }

        updateBatchById(list2);
    }

    private void updateTBssMemoryDetail(String id, String showMode) {
        if (StringHelper.isNullOrEmptyString(showMode)) {
            return;
        }

        List<TBssMemoryDetail> list = itBssMemoryDetailService.list(new LambdaQueryWrapper<TBssMemoryDetail>().eq(TBssMemoryDetail::getMemModelId, id));

        if (list == null || list.isEmpty()) {
            return;
        }

        list.forEach(t -> t.setShowType(P.pInt(showMode)));


        itBssMemoryDetailService.updateBatchById(list);

    }

    private String getMemName(TBssMemoryModel t, Columns columns, ZqHostspacesMemorytype zqHostspacesMemorytype) {
        String memBrand = columns.getValue("brand");
        String memType = getMemTypeDesc(zqHostspacesMemorytype);
        String memHz = t.getMemHz();
        String memVerify = getMemVerifyDesc(columns.getValue("name"));
        String memSpec = getMemSpecDesc(columns.getValue("name"));
        String memSize = P.pString(t.getMemSize());

        return String.format("%s_%s_%s_%s_%s_%sGB",
                getOrDefault(memBrand),
                getOrDefault(memType),
                getOrDefault(memHz),
                getOrDefault(memVerify),
                getOrDefault(memSpec),
                getOrDefault(memSize));
    }

    private String getOrDefault(String str) {
        return StringHelper.isNullOrEmptyString(str) ? "UNKNOW" : str;
    }

    private static String getMemHz(String memoryZp) {
        if (StringHelper.isNullOrEmptyString(memoryZp)) {
            return "";
        }
        Matcher matcher = Pattern.compile("\\d+").matcher(memoryZp);

        int a = 0;
        while (matcher.find()) {
            String num = matcher.group();
            if (StringHelper.isNullOrEmptyString(num)) {
                continue;
            }
            int b = P.pInt(num);
            if (a < b) {
                a = b;
            }
        }


        return String.valueOf(a);
    }

    private Integer getMemType(String memoryType) {
        if ("DDR3".equalsIgnoreCase(memoryType)) {
            return 1;
        } else if ("DDR4".equalsIgnoreCase(memoryType)) {
            return 2;
        } else {
            return 3;
        }
    }

    private String getMemTypeDesc(ZqHostspacesMemorytype zqHostspacesMemorytype) {
        if (zqHostspacesMemorytype == null) {
            return "UNKNOW";
        }

        String memoryType = zqHostspacesMemorytype.getMemoryType();
        if ("DDR3".equalsIgnoreCase(memoryType)) {
            return "DDR3";
        } else if ("DDR4".equalsIgnoreCase(memoryType)) {
            return "DDR4";
        } else {
            return "UNKNOW";
        }
    }

    private Integer getMemVerify(String name) {
        if (name.contains("ECC")) {
            return 1;
        } else if (name.contains("RECC")) {
            return 2;
        } else {
            return 3;
        }
    }

    private String getMemVerifyDesc(String name) {
        if (name.contains("ECC")) {
            return "ECC";
        } else if (name.contains("RECC")) {
            return "RECC";
        } else {
            return "UNKNOW";
        }
    }

    private Integer getMemSpec(String name) {
        if (name.contains("HM")) {
            return 1;
        } else if (name.contains("FM")) {
            return 2;
        } else {
            return 3;
        }
    }

    private String getMemSpecDesc(String name) {
        if (name.contains("HM")) {
            return "HM";
        } else if (name.contains("FM")) {
            return "FM";
        } else {
            return "UNKNOW";
        }
    }
}
