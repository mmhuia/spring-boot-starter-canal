package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssServerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHoServicerMonitor {

    @Autowired
    private ITBssServerService itBssServerService;

    @MonitorPoint(table = "zq_ho_servicer", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssServerService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_ho_servicer", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssServerService.delete(id);
    }

    @MonitorPoint(table = "zq_ho_servicer", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssServerService.onInsertOrUpdate(columns, id);
    }

}
