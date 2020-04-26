package com.ym.starter.canal.annotation;

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
public @interface CanalEventListener {

    @AliasFor(annotation = Component.class)
    String value() default "";

}
