package com.ym.canalsync.app.route;

/**
 * 描述:
 *
 * @author YuanMan
 * @date 2020-04-23 16:01
 */
public class Column {

    private String name;

    private Object value;

    public Column(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public <T> T getValue() {
        try {

            return (T) value;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }
}
