package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssNetworkDevicePortService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHoPortMonitor {

    @Autowired
    private ITBssNetworkDevicePortService itBssNetworkDevicePortService;

    @MonitorPoint(table = "zq_ho_port", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssNetworkDevicePortService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_ho_port", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssNetworkDevicePortService.removeById(id);
    }

    @MonitorPoint(table = "zq_ho_port", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssNetworkDevicePortService.onInsertOrUpdate(columns, id);
    }

}
