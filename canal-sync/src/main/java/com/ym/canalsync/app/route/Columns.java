package com.ym.canalsync.app.route;

import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

/**
 * 描述:
 *
 * @author YuanMan
 * @date 2020-04-23 16:01
 */
public class Columns {

    Map<String, Object> data;

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public <T> T getValue(String name) {
        try {
            return data == null || data.get(name) == null ? null : (T) data.get(name);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
