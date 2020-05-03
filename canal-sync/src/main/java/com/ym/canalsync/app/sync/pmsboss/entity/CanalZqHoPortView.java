package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CanalZqHoPortView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    private String delFlag;

    /**
     * 备注信息
     */
    private String remarks;

    private String net;

    private String ip;

    private String deviceName;

    /**
     * 主键
     */
    private String deviceId;

    /**
     * 网卡id
     */
    private String deviceNetworkId;

    /**
     * 交换机id
     */
    private String networkDeviceId;


}
