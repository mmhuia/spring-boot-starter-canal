package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 网络设备端口
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssNetworkDevicePort implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 逻辑删除标记
     */
    private Integer isdel;

    /**
     * 端口
     */
    private String port;

    /**
     * 链接类型
     */
    private Integer type;

    /**
     * 端口类型
     */
    private Integer sult;

    /**
     * 端口速率
     */
    private Integer speed;

    /**
     * 限制速度
     */
    private Integer career;

    /**
     * 端口状态
     */
    private Integer status;

    /**
     * 连接设备名称
     */
    private String deviceName;

    /**
     * 连接设备ID
     */
    private String deviceId;

    /**
     * 连接设备网卡ID
     */
    private String deviceNetworkId;

    /**
     * 网络设备id
     */
    private String networkDeviceId;

    /**
     * 流量图地址
     */
    private String url;


}
