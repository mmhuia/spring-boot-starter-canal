package com.ym.canalsync.app.sync.pmsboss.service;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.pmsboss.entity.CanalErrorLog;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-20
 */
public interface ICanalErrorLogService extends IService<CanalErrorLog> {

    void saveErrorLog(String table, String event, String id, String monitorId, Throwable t);

    String getDataString(List<CanalEntry.Column> list);
}
