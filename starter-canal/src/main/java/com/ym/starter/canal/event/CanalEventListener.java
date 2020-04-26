package com.ym.starter.canal.event;

import com.alibaba.otter.canal.protocol.CanalEntry;

/**
 * @author ym
 * @date 2020/4/10
 */
public interface CanalEventListener {

    /**
     * run when event was fired
     *
     * @param eventType eventType
     * @param rowData   rowData
     */
    void onEvent(CanalEntry.EventType eventType, CanalEntry.RowData rowData);

}
