package com.ym.canalsync.app.config.mdb;

/**
 * 数据源上下文，线程安全
 *
 * @author ym
 * @desc
 * @since 2020-4-20-10:25
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new InheritableThreadLocal<>();

    /**
     * 取得当前数据源
     *
     * @return
     */
    public static String getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 设置数据源
     *
     * @param db
     */
    public static void setDataSource(String db) {
        CONTEXT_HOLDER.set(db);
    }

    /**
     * 清除上下文数据
     */
    public static void clear() {
        CONTEXT_HOLDER.remove();
    }
}