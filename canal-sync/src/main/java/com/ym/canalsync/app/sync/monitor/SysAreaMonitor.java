package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssAreainfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class SysAreaMonitor {

    @Autowired
    private ITBssAreainfoService itBssAreainfoService;

    @MonitorPoint(table = "sys_area", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssAreainfoService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "sys_area", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssAreainfoService.removeById(id);
    }

    @MonitorPoint(table = "sys_area", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssAreainfoService.onInsertOrUpdate(columns, id);
    }

}
