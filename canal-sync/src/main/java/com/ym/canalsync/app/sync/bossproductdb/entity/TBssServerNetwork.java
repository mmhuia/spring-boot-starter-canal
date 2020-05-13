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
 * 服务器网卡
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssServerNetwork implements Serializable {

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
     * 网卡状态
     */
    private Integer status;

    /**
     * 网卡名称
     */
    private String network;

    /**
     * 连接到网络设备ID
     */
    private String networkDeviceId;

    /**
     * 网络设备端口ID
     */
    private String networkDevicePort;

    /**
     * 网口速率(单位:M)
     */
    private Integer speed;

    /**
     * 是否IPMI口
     */
    private Integer isIpmi;

    /**
     * 网口类型
     */
    private Integer interfaceType;

    /**
     * 是否初始网卡(0否1是)
     */
    private Integer isInit;

    /**
     * 扩展网卡添加时间(当is_init为0时此字段必填)
     */
    private Date addTime;

    private Integer version = 0;


}
