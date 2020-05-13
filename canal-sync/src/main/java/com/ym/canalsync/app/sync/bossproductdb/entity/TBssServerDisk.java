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
 * 服务器磁盘
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssServerDisk implements Serializable {

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
     * 磁盘名称
     */
    private String diskName;

    /**
     * 磁盘型号ID/磁盘列表ID
     */
    private String diskModelId;

    /**
     * 磁盘大小(单位:G)
     */
    private Integer diskSize;

    /**
     * 磁盘插槽
     */
    private Integer diskSlot;

    /**
     * 是否初始磁盘(0否1是)
     */
    private Integer isInit;

    /**
     * 扩展磁盘添加时间(当is_init为0时此字段必填)
     */
    private Date addTime;

    private Integer version = 0;


}
