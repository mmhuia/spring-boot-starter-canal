package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssDiskDetailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHostspacesDiskMonitor {

    @Autowired
    private ITBssDiskDetailService itBssDiskDetailService;

    @MonitorPoint(table = "zq_hostspaces_disk", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssDiskDetailService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_hostspaces_disk", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssDiskDetailService.removeById(id);
    }

    @MonitorPoint(table = "zq_hostspaces_disk", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssDiskDetailService.onInsertOrUpdate(columns, id);
    }

}
