package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssDiskModelService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHostspacesDiskmoduleMonitor {

    @Autowired
    private ITBssDiskModelService itBssDiskModelService;

    @MonitorPoint(table = "zq_hostspaces_diskmodule", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssDiskModelService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_hostspaces_diskmodule", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssDiskModelService.removeById(id);
    }

    @MonitorPoint(table = "zq_hostspaces_diskmodule", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssDiskModelService.onInsertOrUpdate(columns, id);
    }

}
