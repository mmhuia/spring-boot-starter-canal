package com.ym.canalsync.app.utils;

/**
 * 描述:
 *
 * @author YuanMan
 * @date 2020-04-24 17:17
 */
public class P {

    public static String pString(Object o) {
        return o == null ? "" : String.valueOf(o);
    }

    public static int pInt(Object o) {
        if (o == null) {
            return 0;
        }

        int i = 0;
        try {
            i = Integer.parseInt(String.valueOf(o));
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return i;
    }
}
