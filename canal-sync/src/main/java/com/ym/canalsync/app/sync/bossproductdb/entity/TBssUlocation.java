package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * U位
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssUlocation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 逻辑删除
     */
    private Integer isdel;

    /**
     * 机柜ID
     */
    private String cabinetId;

    /**
     * U位
     */
    private Integer uw;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 管理IP
     */
    private String managerIp;

    /**
     * 备注
     */
    private String remark;

    /**
     * U位状态(使用状态) 0:占用 1:可用 3:已预约
     */
    private Integer status;

    /**
     * 设备类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * 预约客户
     */
    private String subscribeCustomer;


}
