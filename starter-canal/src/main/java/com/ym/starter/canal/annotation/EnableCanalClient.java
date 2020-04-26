package com.ym.starter.canal.annotation;

import com.ym.starter.canal.config.CanalClientConfiguration;
import com.ym.starter.canal.config.CanalConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Enables the canal client
 *
 * @author ym
 * @date 2020/4/10
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CanalConfig.class, CanalClientConfiguration.class})
public @interface EnableCanalClient {
}
