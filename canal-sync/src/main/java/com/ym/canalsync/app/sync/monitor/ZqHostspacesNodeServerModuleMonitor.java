package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssNodeServerMasterService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHostspacesNodeServerModuleMonitor {

    @Autowired
    private ITBssNodeServerMasterService itBssNodeServerMasterService;

    @MonitorPoint(table = "zq_hostspaces_node_server_module", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssNodeServerMasterService.updateNodeServerModuleAttr(columns, id);
    }

}
