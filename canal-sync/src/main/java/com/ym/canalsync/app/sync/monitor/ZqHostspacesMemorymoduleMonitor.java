package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssMemoryModelService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHostspacesMemorymoduleMonitor {

    @Autowired
    private ITBssMemoryModelService itBssMemoryModelService;

    @MonitorPoint(table = "zq_hostspaces_memorymodule", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssMemoryModelService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_hostspaces_memorymodule", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssMemoryModelService.removeById(id);
    }

    @MonitorPoint(table = "zq_hostspaces_memorymodule", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssMemoryModelService.onInsertOrUpdate(columns, id);
    }

}
