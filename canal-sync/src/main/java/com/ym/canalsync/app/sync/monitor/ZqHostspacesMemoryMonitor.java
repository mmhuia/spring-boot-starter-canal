package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssMemoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHostspacesMemoryMonitor {

    @Autowired
    private ITBssMemoryDetailService itBssMemoryDetailService;

    @MonitorPoint(table = "zq_hostspaces_memory", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssMemoryDetailService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_hostspaces_memory", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssMemoryDetailService.removeById(id);
    }

    @MonitorPoint(table = "zq_hostspaces_memory", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssMemoryDetailService.onInsertOrUpdate(columns, id);
    }

}
