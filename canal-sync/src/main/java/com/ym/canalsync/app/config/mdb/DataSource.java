package com.ym.canalsync.app.config.mdb;

import java.lang.annotation.*;

/**
 * 数据源切换注解，默认为DB1
 *
 * @author ym
 * @desc
 * @since 2020-4-20-10:27
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceEnum value() default DataSourceEnum.BOSS_PRODUCT_DB;

}
