package com.ym.canalsync.app.route;

import com.alibaba.otter.canal.protocol.CanalEntry;

import java.lang.annotation.*;

/**
 * used to indicate that method(or methods) is(are) the candidate of the
 * canal event distributor
 *
 * @author ym
 * @date 2020/4/10
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MonitorPoint {

    /**
     * tables which you are concentrate on
     * default for all
     *
     * @return canal destination
     */
    String[] table() default {};

    /**
     * canal event type
     * default for all
     *
     * @return canal event type
     */
    CanalEntry.EventType[] eventType() default {};

}
