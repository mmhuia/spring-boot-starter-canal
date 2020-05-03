package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssCabinetService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqXyCabinetMonitor {

    @Autowired
    private ITBssCabinetService itBssCabinetService;


    @MonitorPoint(table = "zq_xy_cabinet", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssCabinetService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_xy_cabinet", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssCabinetService.removeById(id);
    }

    @MonitorPoint(table = "zq_xy_cabinet", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssCabinetService.onInsertOrUpdate(columns, id);
    }

}
