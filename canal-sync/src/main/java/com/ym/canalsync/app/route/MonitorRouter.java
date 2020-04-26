package com.ym.canalsync.app.route;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.ym.starter.canal.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author YuanMan
 * @date 2020-04-23 13:55
 */
@Slf4j
public class MonitorRouter {

    private volatile static MonitorRouter monitorRouting;
    /**
     * listeners which are used by annotation
     */
    private final List<MoniterPoint> annoListeners = new ArrayList<>();

    private MonitorRouter() {
        initRouter();
    }

    public static MonitorRouter get() {
        if (monitorRouting == null) {
            synchronized (MonitorRouter.class) {
                if (monitorRouting == null) {
                    monitorRouting = new MonitorRouter();
                }
            }
        }
        return monitorRouting;
    }

    /**
     * init listeners
     */
    private void initRouter() {
        Map<String, Object> listenerMap = BeanUtil.getBeansWithAnnotation(CanalEventMonitor.class);
        if (listenerMap != null) {
            for (Object target : listenerMap.values()) {
                Method[] methods = target.getClass().getDeclaredMethods();
                for (Method method : methods) {
                    MonitorPoint l = AnnotationUtils.findAnnotation(method, MonitorPoint.class);
                    if (l != null) {
                        annoListeners.add(new MoniterPoint(target, method, l));
                    }
                }
            }
        }
    }


    public void route(Map<String, Object> data, String table, String pk, CanalEntry.EventType eventType) throws InvocationTargetException, IllegalAccessException {
        //invoke the listeners
        for (MoniterPoint point : annoListeners) {
            Map<Method, MonitorPoint> collect = point
                    .getInvokeMap()
                    .entrySet()
                    .stream()
                    .filter(getAnnotationFilter(table, eventType)).collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue));

            for (Map.Entry<Method, MonitorPoint> entry : collect.entrySet()) {
                Method method = entry.getKey();
                method.setAccessible(true);
                Object[] args = getInvokeArgs(method, data, pk);
                method.invoke(point.getTarget(), args);
            }
        }


    }

    /**
     * get the filters predicate
     *
     * @param tableName table name
     * @param eventType event type
     * @return predicate
     */
    private Predicate<Map.Entry<Method, MonitorPoint>> getAnnotationFilter(
            String tableName,
            CanalEntry.EventType eventType) {

        Predicate<Map.Entry<Method, MonitorPoint>> tf = e -> e.getValue().table().length == 0
                || Arrays.stream(e.getValue().table()).anyMatch(t -> t.equals(tableName));
        Predicate<Map.Entry<Method, MonitorPoint>> ef = e -> e.getValue().eventType().length == 0
                || Arrays.stream(e.getValue().eventType()).anyMatch(ev -> ev == eventType);
        return tf.and(ef);
    }

    private Object[] getInvokeArgs(Method method, Map<String, Object> data, String pk) {
        List<Column> list = new ArrayList<>();

        if (data != null) {
            data.forEach((key, value) -> list.add(new Column(key, value)));
        }

        return Arrays.stream(method.getParameterTypes())
                .map(p -> p == List.class
                        ? list
                        : p == String.class
                        ? pk : null)
                .toArray();
    }

}
