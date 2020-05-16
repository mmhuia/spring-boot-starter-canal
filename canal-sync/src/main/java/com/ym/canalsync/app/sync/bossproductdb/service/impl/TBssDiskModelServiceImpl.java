package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssDiskDetail;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssDiskModel;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssDiskModelMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssDiskDetailService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssDiskModelService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesDiskmodule;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesDisktype;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesDiskmoduleService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesDisktypeService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>
 * 磁盘型号 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssDiskModelServiceImpl extends ServiceImpl<TBssDiskModelMapper, TBssDiskModel> implements ITBssDiskModelService {

    @Autowired
    private IZqHostspacesDisktypeService iZqHostspacesDisktypeService;

    @Autowired
    private IZqHostspacesDiskmoduleService iZqHostspacesDiskmoduleService;

    @Autowired
    private ITBssDiskDetailService itBssDiskDetailService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssDiskModel t = new TBssDiskModel();
        t.setId(id);
        t.setCreateUser(columns.getValue("create_by"));
        t.setCreateTime(columns.getValue("create_date"));
        t.setUpdateUser(columns.getValue("update_by"));
        t.setUpdateTime(columns.getValue("update_date"));
        t.setRemark(columns.getValue("remarks"));
        t.setIsdel(P.pInt(columns.getValue("del_flag")));
        t.setDiskName(getDiskName(columns));
        t.setDiskBrand(columns.getValue("brand"));


        t.setDiskMeasure(getDiskMeasure(columns.getValue("specifications")));
        t.setInterfaceType(getInterfaceType(columns.getValue("interface_type")));
        t.setDiskRpm(getDiskRpm(columns.getValue("speed")));

        ZqHostspacesDisktype zqHostspacesDisktype = getDisktype(columns.getValue("type_name"));
        if (zqHostspacesDisktype != null) {
            t.setDiskSize(getDiskSize(zqHostspacesDisktype.getDiskCapacity()));
            t.setDiskType(getDiskType(zqHostspacesDisktype.getDiskType()));
            t.setDiskShort(getDiskType(zqHostspacesDisktype.getDiskType()));
        }

        t.setDiskModel(null);
        t.setProductMapId(null);
        t.setUseType(null);
        t.setDiskCache(null);

        saveOrUpdate(t);
        updateDiskDetailAttr(columns, id);
    }

    private void updateDiskDetailAttr(Columns columns, String id) {

        List<TBssDiskDetail> list = itBssDiskDetailService.list(
                new LambdaQueryWrapper<TBssDiskDetail>().eq(TBssDiskDetail::getDiskModelId, id));

        if (list == null || list.isEmpty()) {
            return;
        }

        list.forEach(e -> e.setShowType(
                StringHelper.isNullOrEmptyString(columns.getValue("show_mode")) ?
                        0 : P.pInt(columns.getValue("show_mode"))));

        itBssDiskDetailService.updateBatchById(list);

    }

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void updateDiskTypeAttr(Columns columns, String id) {
        List<ZqHostspacesDiskmodule> zqHostspacesDiskmoduleList = iZqHostspacesDiskmoduleService.getBy(id);
        if (zqHostspacesDiskmoduleList == null || zqHostspacesDiskmoduleList.isEmpty()) {
            return;
        }

        List<String> ids = zqHostspacesDiskmoduleList.stream().map(ZqHostspacesDiskmodule::getId).collect(Collectors.toList());


        List<TBssDiskModel> tBssDiskModels = listByIds(ids);

        if (tBssDiskModels == null || tBssDiskModels.isEmpty()) {
            return;
        }

        tBssDiskModels.forEach(e -> {
            e.setDiskSize(getDiskSize(columns.getValue("disk_capacity")));
            e.setDiskType(getDiskType(columns.getValue("disk_type")));
            e.setDiskShort(getDiskType(columns.getValue("disk_type")));
        });

        updateBatchById(tBssDiskModels);

    }

    private Integer getDiskSize(String diskCapacity) {
        if (StringHelper.isNullOrEmptyString(diskCapacity)) {
            return 0;
        }

        Matcher matcher = Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])").matcher(diskCapacity);
        if (matcher.find()) {
            return P.pInt(matcher.group(0));
        } else {
            return 0;
        }
    }

    private String getDiskRpm(String speed) {
        if (StringHelper.isNullOrEmptyString(speed)) {
            return null;
        }

        Matcher matcher = Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])").matcher(speed);
        if (matcher.find()) {
            return matcher.group(0);
        } else {
            return null;
        }

    }

    private Integer getInterfaceType(String interfaceType) {
        if (StringHelper.isNullOrEmptyString(interfaceType)) {
            return 2;
        }

        if (interfaceType.toUpperCase().contains("SATA")) {
            return 0;
        } else if (interfaceType.toUpperCase().contains("SAS")) {
            return 1;
        } else {
            return 2;
        }
    }

    private String getDiskMeasure(String specifications) {
        if (StringHelper.isNullOrEmptyString(specifications)) {
            return "";
        }
        Matcher matcher = Pattern.compile("([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])").matcher(specifications);

        if (matcher.find()) {
            return matcher.group(0);
        } else {
            return "";
        }
    }

    private Integer getDiskType(String diskType) {
        if (StringHelper.isNullOrEmptyString(diskType)) {
            return 2;
        }
        int a = P.pInt(diskType);
        if (a != 0 && a != 1) {
            return 2;
        }
        return a;
    }

    private ZqHostspacesDisktype getDisktype(String typeName) {
        if (StringHelper.isNullOrEmptyString(typeName)) {
            return null;
        }

        return iZqHostspacesDisktypeService.getById(typeName);
    }

    private String getDiskName(Columns columns) {
        //brand
        String brand = columns.getValue("brand");
        if (StringHelper.isNullOrEmptyString(brand)) {
            brand = "UNKNOW";
        } else {
            brand = brand.toUpperCase();
        }

        //disk type
        String diskType;
        ZqHostspacesDisktype zqHostspacesDisktype = getDisktype(columns.getValue("type_name"));
        if (zqHostspacesDisktype != null && !StringHelper.isNullOrEmptyString(zqHostspacesDisktype.getDiskType())) {
            String s = zqHostspacesDisktype.getDiskType();
            switch (s) {
                case "1":
                    diskType = "SSD";
                    break;
                case "0":
                    diskType = "HDD";
                    break;
                default:
                    diskType = "UNKNOW";
            }
        } else {
            diskType = "UNKNOW";
        }


        //interfaceType
        String interfaceType = StringHelper.isNullOrEmptyString(columns.getValue("interface_type")) ?
                "UNKNOW" : ((String) columns.getValue("interface_type")).toUpperCase();


        //disk size
        String diskSize;
        if (zqHostspacesDisktype != null && !StringHelper.isNullOrEmptyString(zqHostspacesDisktype.getDiskCapacity())) {
            String diskCapacity = zqHostspacesDisktype.getDiskCapacity();
            int i = P.pInt(diskCapacity);
            if (i < 1024) {
                diskSize = diskCapacity + "GB";
            } else {
                diskSize = Math.floor(P.pInt(diskCapacity) / 1024) + "TB";
            }
        } else {
            diskSize = "UNKNOW";
        }


        return String.format("%s_%s_%s_%s", brand, diskType, interfaceType, diskSize);
    }
}
