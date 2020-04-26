package com.ym.canalsync.app.route;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * inject the present class to the spring context
 * as a listener of the canal event
 *
 * @author ym
 * @date 2020/4/10
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CanalEventMonitor {

    @AliasFor(annotation = Component.class)
    String value() default "";

}
