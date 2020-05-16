package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssCpuModel;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssCpuModelMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssCpuModelService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesCpumodule;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesCputype;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesCpumoduleService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesCputypeService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    @Autowired
    private IZqHostspacesCputypeService iZqHostspacesCputypeService;

    @Autowired
    private IZqHostspacesCpumoduleService iZqHostspacesCpumoduleService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssCpuModel tBssCpuModel = new TBssCpuModel();
        tBssCpuModel.setId(columns.getValue("id"));
        tBssCpuModel.setCreateUser(columns.getValue("create_by"));
        tBssCpuModel.setCreateTime(columns.getValue("create_date"));
        tBssCpuModel.setUpdateUser(columns.getValue("update_by"));
        tBssCpuModel.setUpdateTime(columns.getValue("update_date"));
        tBssCpuModel.setRemark(columns.getValue("remarks"));
        tBssCpuModel.setIsdel(P.pInt(columns.getValue("del_flag")));
        tBssCpuModel.setCpuBrand(columns.getValue("brand"));

        tBssCpuModel.setCpuNumber(getCpuNumber(columns.getValue("cpu_model")));
        tBssCpuModel.setCpuModel(getCpuModel(columns.getValue("cpu_model")));


        ZqHostspacesCputype zqHostspacesCputype = iZqHostspacesCputypeService.getById(columns.getValue("type_name"));
        if (zqHostspacesCputype != null) {
            tBssCpuModel.setCpuHz(zqHostspacesCputype.getCpuZp());
            tBssCpuModel.setInterfaceType(zqHostspacesCputype.getInterfaceType());
            tBssCpuModel.setCpuCore(getCpuCore(zqHostspacesCputype.getCoreNumber()));
            tBssCpuModel.setCpuThread(getCpuThread(zqHostspacesCputype.getCoreNumber()));
        }

        tBssCpuModel.setCpuName(getCpuName(tBssCpuModel));
        tBssCpuModel.setProductMapId(null);

        saveOrUpdate(tBssCpuModel);

    }

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void updateCputypeAttr(Columns columns, String id) {
        if (StringHelper.isNullOrEmptyString(id)) {
            return;
        }
        LambdaQueryWrapper<ZqHostspacesCpumodule> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(ZqHostspacesCpumodule::getTypeName, id);
        List<ZqHostspacesCpumodule> list = iZqHostspacesCpumoduleService.list(lambdaQueryWrapper);
        if (list == null || list.isEmpty()) {
            return;
        }

        List<String> ids = list.stream().map(ZqHostspacesCpumodule::getId).collect(Collectors.toList());


        LambdaQueryWrapper<TBssCpuModel> lambdaQueryWrapper1 = new LambdaQueryWrapper<>();
        lambdaQueryWrapper1.in(TBssCpuModel::getId, ids);

        List<TBssCpuModel> tBssCpuModelList = this.list(lambdaQueryWrapper1);
        if (tBssCpuModelList == null || tBssCpuModelList.isEmpty()) {
            return;
        }

        tBssCpuModelList.forEach(t -> {
            t.setCpuHz(columns.getValue("cpu_zp"));
            t.setInterfaceType(columns.getValue("interface_type"));
            t.setCpuCore(getCpuCore(columns.getValue("core_number")));
            t.setCpuThread(getCpuThread(columns.getValue("core_number")));
            t.setUpdateTime(columns.getValue("update_date"));
            t.setUpdateUser(columns.getValue("update_by"));
        });

        updateBatchById(tBssCpuModelList);
    }

    private String getCpuName(TBssCpuModel tBssCpuModel) {
        return String.format("%s*%s_%s_%s核_%s线程",
                tBssCpuModel.getCpuNumber(),
                tBssCpuModel.getCpuBrand(),
                tBssCpuModel.getCpuModel(),
                tBssCpuModel.getCpuCore(),
                tBssCpuModel.getCpuThread());
    }

    private Integer getCpuThread(String coreNumber) {
        return getRegexPreNum(coreNumber, "线程");
    }

    private Integer getCpuCore(String coreNumber) {
        return getRegexPreNum(coreNumber, "核");
    }

    private Integer getRegexPreNum(String str, String rex) {
        if (StringHelper.isNullOrEmptyString(str)) {
            return 0;
        }

        Matcher matcher = Pattern.compile("\\d+" + rex).matcher(str);// 指定要匹配的字符串

        List<String> matchStrs = new ArrayList<>();

        while (matcher.find()) { //此处find（）每次被调用后，会偏移到下一个匹配
            matchStrs.add(matcher.group());//获取当前匹配的值
        }

        if (matchStrs.size() != 1) {
            return 0;
        }

        String s = matchStrs.get(0);

        try {
            return Integer.valueOf(s.substring(0, s.indexOf(rex)));
        } catch (Exception e) {
            return 0;
        }
    }

    private String getCpuModel(String cpuModel) {
        if (StringHelper.isNullOrEmptyString(cpuModel)) {
            return "";
        }

        if (!cpuModel.contains("*")) {
            return cpuModel;
        }

        String[] split = cpuModel.split("\\*");
        for (String s : split) {
            if (!s.matches("[0-9]+")) {
                return s;
            }
        }

        return "";
    }

    private Integer getCpuNumber(String cpuModel) {
        if (StringHelper.isNullOrEmptyString(cpuModel)) {
            return 0;
        }

        if (!cpuModel.contains("*")) {
            return 1;
        }

        String[] split = cpuModel.split("\\*");

        for (String s : split) {
            try {
                return Integer.parseInt(s);
            } catch (Exception ignored) {
            }
        }


        return 0;
    }
}
