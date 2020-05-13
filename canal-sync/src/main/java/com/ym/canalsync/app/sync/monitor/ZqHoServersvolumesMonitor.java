package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.pmsboss.service.IZqHoServersvolumesService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHoServersvolumesMonitor {

    @Autowired
    private IZqHoServersvolumesService iZqHoServersvolumesService;

    @MonitorPoint(table = "zq_ho_serversvolumes", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        iZqHoServersvolumesService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_ho_serversvolumes", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(Columns columns, String id) {
        iZqHoServersvolumesService.delete(columns, id);
    }

    @MonitorPoint(table = "zq_ho_serversvolumes", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        iZqHoServersvolumesService.onInsertOrUpdate(columns, id);
    }

}
