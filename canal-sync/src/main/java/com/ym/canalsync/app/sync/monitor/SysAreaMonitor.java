package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Column;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.service.ITBssAreainfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ym
 */
@CanalEventMonitor
public class SysAreaMonitor {

    @Autowired
    private ITBssAreainfoService itBssAreainfoService;

    @MonitorPoint(table = "sys_area", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(List<Column> data, String id) {
        itBssAreainfoService.onInsertOrUpdate(data, id);
    }

    @MonitorPoint(table = "sys_area", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssAreainfoService.onDelete(id);
    }

    @MonitorPoint(table = "sys_area", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(List<Column> data, String id) {
        itBssAreainfoService.onInsertOrUpdate(data, id);
    }

}
