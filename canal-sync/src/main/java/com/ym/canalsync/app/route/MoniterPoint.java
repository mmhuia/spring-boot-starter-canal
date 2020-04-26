package com.ym.canalsync.app.route;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * MoniterPoint
 * save the information of listener's method-info
 *
 * @author ym
 * @date 2020/4/10
 */
public class MoniterPoint {
    private Object target;
    private Map<Method, MonitorPoint> invokeMap = new HashMap<>();

    MoniterPoint(Object target, Method method, MonitorPoint anno) {
        this.target = target;
        this.invokeMap.put(method, anno);
    }

    public Object getTarget() {
        return target;
    }

    public Map<Method, MonitorPoint> getInvokeMap() {
        return invokeMap;
    }
}
