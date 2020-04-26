package com.ym.canalsync.app.config.mdb;

/**
 * 用于切换数据源的枚举常量
 *
 * @author ym
 * @desc 数据源枚举
 * @since 2020-4-20-10:25
 */
public enum DataSourceEnum {

    /**
     *
     */
    BOSS_PMS("boss_pms"),

    /**
     *
     */
    BOSS_PRODUCT_DB("boss_product_db");

    private String value;

    DataSourceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
