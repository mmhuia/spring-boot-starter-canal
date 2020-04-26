package com.ym.starter.canal.client.transfer;

/**
 * @author ym
 * @date 2020/4/10
 */
public class MessageTransponders {

    public static TransponderFactory defaultMessageTransponder() {
        return new DefaultTransponderFactory();
    }

}
