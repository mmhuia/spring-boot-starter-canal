package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 网络设备表
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssNetworkDevices implements Serializable {

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
     * 区域位置码
     */
    private String locationId;

    /**
     * 机柜ID
     */
    private String cabinetId;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备类型
     */
    private Integer deviceType;

    /**
     * 采购时间
     */
    private Date purchasingtime;

    /**
     * 入库时间
     */
    private Date storagetime;

    /**
     * 端口数量
     */
    private Integer num;

    /**
     * 占用U位
     */
    private Integer uw;

    /**
     * 起始U位
     */
    private Integer startubat;

    /**
     * 管理ip
     */
    private String ip;

    /**
     * 设备型号(字典维护)
     */
    private Integer modelnumber;

    /**
     * 设备状态
     */
    private Integer status;

    /**
     * 设备SN号
     */
    private String deviceSn;

    /**
     * 设备品牌(字典维护)
     */
    private Integer brand;

    /**
     * 引用模版ID
     */
    private String templateId;


}
