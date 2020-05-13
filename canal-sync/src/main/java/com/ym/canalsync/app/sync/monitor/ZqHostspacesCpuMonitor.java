package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssCpuDetailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHostspacesCpuMonitor {

    @Autowired
    private ITBssCpuDetailService itBssCpuDetailService;

    @MonitorPoint(table = "zq_hostspaces_cpu", eventType = CanalEntry.EventType.INSERT)
    public void onInsert(Columns columns, String id) {
        itBssCpuDetailService.onInsertOrUpdate(columns, id);
    }

    @MonitorPoint(table = "zq_hostspaces_cpu", eventType = CanalEntry.EventType.DELETE)
    public void onDelete(String id) {
        itBssCpuDetailService.removeById(id);
    }

    @MonitorPoint(table = "zq_hostspaces_cpu", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssCpuDetailService.onInsertOrUpdate(columns, id);
    }

}
