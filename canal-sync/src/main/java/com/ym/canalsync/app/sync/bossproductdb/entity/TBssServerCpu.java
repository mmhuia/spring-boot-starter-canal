package com.ym.canalsync.app.sync.bossproductdb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 服务器CPU
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssServerCpu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 服务器ID
     */
    private String serverId;

    /**
     * CPU名称
     */
    private String cpuName;

    /**
     * CPU型号ID
     */
    private String cpuModelId;

    /**
     * CPU插槽
     */
    private Integer cpuSlot;

    /**
     * 是否初始CPU(0否1是)
     */
    private Integer isInit;

    /**
     * 扩展CPU添加时间(当is_init为0时此字段必填)
     */
    private Date addTime;

    private Integer version = 0;
}
