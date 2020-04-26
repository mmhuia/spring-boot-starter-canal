package com.ym.canalsync.app.route;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.starter.canal.annotation.CanalEventListener;
import com.ym.starter.canal.annotation.ListenPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author ym
 */
@CanalEventListener
@Slf4j
public class TMonitorListener {

    @Autowired
    private GetDataService getDataService;

    @ListenPoint(destination = "oldToNew", schema = "boss_pms", table = {"t_monitor"}, eventType = CanalEntry.EventType.INSERT)
    public void onEvent(CanalEntry.EventType eventType, CanalEntry.RowData rowData) throws Exception {
        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();

        if (afterColumnsList == null || afterColumnsList.size() == 0) {
            return;

        }

        String tableName = afterColumnsList.get(1).getValue();
        String tablePkId = afterColumnsList.get(2).getValue();
        int operType = Integer.parseInt(afterColumnsList.get(4).getValue());

        Map<String, Object> data = getDataService.selectData(tablePkId, tableName);
        log.debug("[business data]:");
        log.debug(JSONObject.toJSONString(data));


        boolean noData = (data == null || data.size() == 0) && operType != OperType.DELETE.v;
        if (noData) {
            log.warn("no data selected, break");
            return;
        }


        CanalEntry.EventType event = null;
        if (operType == OperType.INSERT.v) {
            event = CanalEntry.EventType.INSERT;
        } else if (operType == OperType.UPDATE.v) {
            event = CanalEntry.EventType.UPDATE;
        } else if (operType == OperType.DELETE.v) {
            event = CanalEntry.EventType.DELETE;
        }


        MonitorRouter.get().route(data, tableName, tablePkId, event);
    }

}
