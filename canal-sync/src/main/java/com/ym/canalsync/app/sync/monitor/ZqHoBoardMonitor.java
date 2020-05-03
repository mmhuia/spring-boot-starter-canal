package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssNetworkDevicesService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHoBoardMonitor {

    @Autowired
    private ITBssNetworkDevicesService itBssNetworkDevicesService;

    @MonitorPoint(table = "zq_ho_board", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssNetworkDevicesService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_ho_board", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssNetworkDevicesService.removeById(id);
    }

    @MonitorPoint(table = "zq_ho_board", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssNetworkDevicesService.onInsertOrUpdate(columns, id);
    }

}
