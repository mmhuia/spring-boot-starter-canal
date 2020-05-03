package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssUlocationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqXyULocationMonitor {

    @Autowired
    private ITBssUlocationService itBssUlocationService;

    @MonitorPoint(table = "zq_xy_ulocation", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssUlocationService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_xy_ulocation", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssUlocationService.removeById(id);
    }

    @MonitorPoint(table = "zq_xy_ulocation", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssUlocationService.onInsertOrUpdate(columns, id);
    }

}
