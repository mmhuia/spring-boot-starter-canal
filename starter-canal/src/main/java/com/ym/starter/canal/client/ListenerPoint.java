package com.ym.starter.canal.client;

import com.ym.starter.canal.annotation.ListenPoint;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * ListenerPoint
 * save the information of listener's method-info
 *
 * @author ym
 * @date 2020/4/10
 */
public class ListenerPoint {
    private Object target;
    private Map<Method, ListenPoint> invokeMap = new HashMap<>();

    ListenerPoint(Object target, Method method, ListenPoint anno) {
        this.target = target;
        this.invokeMap.put(method, anno);
    }

    public Object getTarget() {
        return target;
    }

    public Map<Method, ListenPoint> getInvokeMap() {
        return invokeMap;
    }
}
