package com.ym.canalsync.app.sync.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ym.canalsync.app.config.mdb.DataSource;
import com.ym.canalsync.app.config.mdb.DataSourceEnum;
import com.ym.canalsync.app.sync.entity.CanalErrorLog;
import com.ym.canalsync.app.sync.mapper.CanalErrorLogMapper;
import com.ym.canalsync.app.sync.service.ICanalErrorLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ymym
 * @since 2020-04-20
 */
@Service
@Slf4j
public class CanalErrorLogServiceImpl extends ServiceImpl<CanalErrorLogMapper, CanalErrorLog> implements ICanalErrorLogService {

    public static final String LOG_ERROR = "table[%s] event[%s] id[%s] Saving the exception log failed";
    private static final String ENTER = "\n";

    @Override
    @DataSource(DataSourceEnum.BOSS_PMS)
    public void saveErrorLog(String table, String event, String id, String monitorId, Throwable t) {
        try {
            CanalErrorLog errorLog = new CanalErrorLog();
            errorLog.setMonitorId(monitorId);
            errorLog.setErrorDetail(buildErrorDetail(t));
            errorLog.setCreatedTime(new Date());
            boolean save = super.save(errorLog);
            if (!save) {
                log.error(String.format(LOG_ERROR, table, event, id));
            }
        } catch (Exception e) {
            log.error(String.format(LOG_ERROR, table, event, id));
            log.error(e.getMessage(), e);
        }

    }

    private String buildErrorDetail(Throwable t) {
        StringBuilder sb = new StringBuilder();

        if (!StringUtils.isEmpty(t.getMessage())) {
            sb.append(t.getMessage()).append(ENTER);
        }

        sb.append(t.toString()).append(ENTER);


        for (StackTraceElement ste : t.getStackTrace()) {
            sb.append(ste.toString()).append(ENTER);
        }

        return sb.toString();
    }

    @Override
    public String getDataString(List<CanalEntry.Column> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        list.forEach((c) -> jsonObject.put(c.getName(), c.getValue()));
        return jsonObject.toJSONString();
    }
}
