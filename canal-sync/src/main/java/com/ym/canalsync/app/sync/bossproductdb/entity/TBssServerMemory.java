package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 服务器内存
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssServerMemory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 服务器ID
     */
    private String serverId;

    /**
     * 内存名称
     */
    private String memoryName;

    /**
     * 内存型号ID
     */
    private String memoryModelId;

    /**
     * 内存大小(单位:G)
     */
    private Integer memorySize;

    /**
     * 内存插槽
     */
    private Integer memorySlot;

    /**
     * 是否初始内存(0否1是)
     */
    private Integer isInit;

    /**
     * 扩展memory添加时间(当is_init为0时此字段必填)
     */
    private Date addTime;

    private Integer version = 0;


}
