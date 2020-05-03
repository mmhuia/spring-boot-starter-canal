package com.ym.canalsync.app.aspect;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.canalsync.app.route.OperType;
import com.ym.canalsync.app.sync.pmsboss.service.ICanalErrorLogService;
import com.ym.starter.canal.annotation.ListenPoint;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author ym
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    public static final String ENTER = "\n \n";
    public static final String UNKNOW = "UNKNOW";
    private static final String LOG_START = "========= table[%s] event[%s] id[%s] start =========";
    private static final String LOG_END = "========= table[%s] event[%s] id[%s] end =========";
    @Autowired
    private ICanalErrorLogService iCanalErrorLogService;

    @Pointcut("@within(com.ym.starter.canal.annotation.ListenPoint) || @annotation(com.ym.starter.canal.annotation.ListenPoint)")
    private void listenerPointcut() {
    }

    @Around(value = "listenerPointcut() && @annotation(listenPoint)")
    public Object aroundListener(ProceedingJoinPoint jp, ListenPoint listenPoint) {
        Object proceed = null;
        String table = null;
        String event = null;
        String id = null;
        String monitorId = null;
        try {

            Object[] args = jp.getArgs();
            CanalEntry.RowData rowData = (CanalEntry.RowData) args[1];

            monitorId = rowData.getAfterColumnsList().get(0).getValue();
            table = rowData.getAfterColumnsList().get(1).getValue();
            id = rowData.getAfterColumnsList().get(2).getValue();
            event = getEventStr(rowData.getAfterColumnsList().get(4).getValue());


            log.info(ENTER);
            log.info(String.format(LOG_START, table, event, id));


            log.debug("[monitor data]:");
            log.debug(iCanalErrorLogService.getDataString(rowData.getAfterColumnsList()));

            proceed = jp.proceed(jp.getArgs());
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            iCanalErrorLogService.saveErrorLog(table, event, id, monitorId, t);
        } finally {
            log.info(String.format(LOG_END, table, event, id));
            log.info(ENTER);
        }
        return proceed;
    }

    private String getEventStr(String event) {
        String eventStr = UNKNOW;
        if (StringUtils.isEmpty(event)) {
            return eventStr;
        }
        int e;
        try {
            e = Integer.parseInt(event);
        } catch (Throwable t) {
            return "";
        }

        if (e == OperType.INSERT.v) {
            return OperType.INSERT.name();
        } else if (e == OperType.UPDATE.v) {
            return OperType.UPDATE.name();
        } else if (e == OperType.DELETE.v) {
            return OperType.DELETE.name();
        }

        return eventStr;
    }
}
