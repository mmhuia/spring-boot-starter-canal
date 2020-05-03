package com.ym.canalsync.app.sync.monitor;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.CanalEventMonitor;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.route.MonitorPoint;
import com.ym.canalsync.app.sync.bossproductdb.service.ITBssHouseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ym
 */
@CanalEventMonitor
public class ZqHostspacesHouseMonitor {

    @Autowired
    private ITBssHouseService itBssHouseService;

    @MonitorPoint(table = "zq_hostspaces_house", eventType = CanalEntry.EventType.UPDATE)
    public void onUpdate(Columns columns, String id) {
        itBssHouseService.updateOldHousePart(columns, id);
    }

}
