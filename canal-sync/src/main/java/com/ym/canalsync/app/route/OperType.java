package com.ym.canalsync.app.route;

/**
 * @author ym
 * @desc
 * @since 2020-4-23-15:11
 */
public enum OperType {

    /**
     * 新增
     */
    INSERT(1),
    /**
     * 修改
     */
    UPDATE(2),
    /**
     * 删除
     */
    DELETE(3);

    public int v;

    OperType(int v) {
        this.v = v;
    }
}
