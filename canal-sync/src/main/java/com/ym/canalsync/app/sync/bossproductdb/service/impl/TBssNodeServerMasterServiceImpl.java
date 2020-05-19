package com.ym.canalsync.app.sync.bossproductdb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.DSEnum;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.bossproductdb.entity.TBssNodeServerMaster;
import com.ym.canalsync.app.sync.bossproductdb.mapper.TBssNodeServerMasterMapper;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssCabinetService;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssNodeServerMasterService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServicer;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesNodeItem;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesNodeServer;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesNodeServerModule;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoServicerService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesNodeItemService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesNodeServerModuleService;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHostspacesNodeServerService;
import com.ym.canalsync.app.utils.P;
import io.seata.spring.annotation.GlobalTransactional;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>
 * 外机主表 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Service
@DS(DSEnum.BOSS_PRODUCT_DB)
public class TBssNodeServerMasterServiceImpl extends ServiceImpl<TBssNodeServerMasterMapper, TBssNodeServerMaster> implements ITBssNodeServerMasterService {

    @Autowired
    private IZqHostspacesNodeServerModuleService iZqHostspacesNodeServerModuleService;

    @Autowired
    private ITBssCabinetService itBssCabinetService;

    @Autowired
    private IZqHostspacesNodeItemService iZqHostspacesNodeItemService;

    @Autowired
    private IZqHoServicerService iZqHoServicerService;

    @Autowired
    private IZqHostspacesNodeServerService iZqHostspacesNodeServerService;

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void onInsertOrUpdate(Columns columns, String id) {
        TBssNodeServerMaster t = new TBssNodeServerMaster();
        t.setId(id);
        t.setCreateUser(columns.getValue("create_by"));
        t.setCreateTime(columns.getValue("create_date"));
        t.setUpdateUser(columns.getValue("update_by"));
        t.setUpdateTime(columns.getValue("update_date"));
        t.setRemark(columns.getValue("remarks"));
        t.setIsdel(P.pInt(columns.getValue("del_flag")));

        t.setStartUs(P.pInt(columns.getValue("start_num")));
        t.setLocationId(getLocationId(columns.getValue("cabinetId")));
        t.setCabinetId(columns.getValue("cabinetId"));
        t.setPurchasingTime(null);
        t.setStorageTime(null);
        t.setStatus(getStatus(columns.getValue("id")));

        ZqHostspacesNodeServerModule nodeServerModule = getNodeServerModule(columns.getValue("node_server_module_id"));
        if (nodeServerModule != null) {
            setBrandModelSpec(t, nodeServerModule.getModelName());
            t.setNodeNum(nodeServerModule.getNodeNum());
            t.setUs(nodeServerModule.getUNum());
        }


        saveOrUpdate(t);
    }

    @Override
    @GlobalTransactional(rollbackFor = Throwable.class)
    public void updateNodeServerModuleAttr(Columns columns, String id) {
        if (StringHelper.isNullOrEmptyString(id)) {
            return;
        }

        List<ZqHostspacesNodeServer> list = iZqHostspacesNodeServerService.list(
                new LambdaQueryWrapper<ZqHostspacesNodeServer>().eq(ZqHostspacesNodeServer::getNodeServerModuleId, id)
        );

        if (list == null || list.isEmpty()) {
            return;
        }

        List<String> ids = list.stream().map(ZqHostspacesNodeServer::getId).collect(Collectors.toList());

        List<TBssNodeServerMaster> tBssNodeServerMasters = listByIds(ids);

        if (tBssNodeServerMasters == null || tBssNodeServerMasters.isEmpty()) {
            return;
        }

        tBssNodeServerMasters.forEach(t -> {
            setBrandModelSpec(t, columns.getValue("model_name"));
            t.setNodeNum(columns.getValue("node_num"));
            t.setUs(columns.getValue("u_num"));
            t.setUpdateTime(columns.getValue("create_date"));
            t.setUpdateUser(columns.getValue("update_by"));
        });

        updateBatchById(tBssNodeServerMasters);
    }

    private void setBrandModelSpec(TBssNodeServerMaster t, String modelName) {
        if (StringHelper.isNullOrEmptyString(modelName)) {
            t.setDeviceBrand("");
            t.setDeviceModel("");
            t.setDeviceSpec("");
            return;
        }


        if (modelName.contains("_")) {
            String[] s = modelName.split("_");
            if (s.length == 2) {
                t.setDeviceBrand(s[0]);
                t.setDeviceModel(getContentBeforeTheBrackets(s[1]));
                t.setDeviceSpec(getContentInTheBracket(s[1]));
            } else if (s.length == 3) {
                t.setDeviceBrand(s[1]);
                t.setDeviceModel(getContentBeforeTheBrackets(s[2]));
                t.setDeviceSpec(getContentInTheBracket(s[2]));
            }
        } else if (modelName.contains(" ")) {
            String[] s = modelName.split(" ");
            if (s.length >= 1) {
                t.setDeviceBrand(s[0]);
            }
            if (s.length >= 2) {
                t.setDeviceSpec(getContentBeforeTheBrackets(s[1]));
            }
            t.setDeviceModel(getContentInTheBracket(modelName));
        }


    }

    private final static Pattern CONTENT_BEFORE_THE_BRACKETS = Pattern.compile("\\S+(\\(|（)");

    private static String getContentBeforeTheBrackets(String s) {
        Matcher m = CONTENT_BEFORE_THE_BRACKETS.matcher(s);
        if (m.find()) {
            String group = m.group(0);
            return group.substring(0, group.length() - 1);
        }
        return null;
    }

    private final static Pattern CONTENT_IN_THE_BRACKET = Pattern.compile("(\\(|（)\\S+(）|\\))");

    private String getContentInTheBracket(String s) {
        Matcher m = CONTENT_IN_THE_BRACKET.matcher(s);
        if (m.find()) {
            String group = m.group(0);
            return group.substring(1, group.length() - 1);
        }
        return null;
    }

    private Integer getStatus(String id) {
        if (StringHelper.isNullOrEmptyString(id)) {
            return null;
        }

        List<ZqHostspacesNodeItem> list = iZqHostspacesNodeItemService.list(
                new LambdaQueryWrapper<ZqHostspacesNodeItem>().eq(ZqHostspacesNodeItem::getNodeServerId, id)
        );

        if (list == null || list.isEmpty()) {
            return null;
        }

        for (ZqHostspacesNodeItem item : list) {
            ZqHoServicer servicer = iZqHoServicerService.getById(item.getServerId());
            if (servicer != null && servicer.getSeSalesstatus() == 2) {
                return 2;
            }
        }

        return 1;
    }

    private String getLocationId(String cabinetId) {
        return itBssCabinetService.getLocationId(cabinetId);
    }

    private ZqHostspacesNodeServerModule getNodeServerModule(String nodeServerModuleId) {
        return Optional.ofNullable(nodeServerModuleId).map(iZqHostspacesNodeServerModuleService::getById).orElse(null);
    }

}
