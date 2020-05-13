package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 服务器信息主表
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssServer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更改时间
     */
    private Date updateTime;

    /**
     * 更改人
     */
    private String updateUser;

    /**
     * 逻辑删除
     */
    private Integer isdel;

    /**
     * 备注
     */
    private String remark;

    /**
     * 服务器IP
     */
    private String serverIp;

    /**
     * 服务器品牌
     */
    private Integer serverBrand;

    /**
     * 服务器型号
     */
    private Integer serverModel;

    /**
     * 服务器规格
     */
    private String serverSpec;

    /**
     * 服务器类型
     */
    private Integer serverType;

    /**
     * 硬盘插槽
     */
    private Integer serverDiskSlot;

    /**
     * 支持规格
     */
    private Integer serverDiskSpec;

    /**
     * 是否热插拔
     */
    private Integer serverDiskHot;

    /**
     * 硬盘接口类型
     */
    private Integer diskInterfaceType;

    /**
     * 当前硬盘大小(单位:G)
     */
    private Integer serverCurrentDisk;

    /**
     * CPU插槽
     */
    private Integer serverCpuSlot;

    /**
     * 内存插槽
     */
    private Integer serverMemorySlot;

    /**
     * 单槽最大支持(单位:G)
     */
    private Integer serverOneMemory;

    /**
     * 当前内存大小(单位:G)
     */
    private Integer serverCurrentMemory;

    /**
     * 最大支持内存(单位:G)
     */
    private Integer serverMaxMemory;

    /**
     * 内存支持类型
     */
    private Integer serverMemoryType;

    /**
     * 支持内存规格
     */
    private Integer serverMemorySpec;

    /**
     * U数
     */
    private Integer serverUs;

    /**
     * 起始U数(服务器为通用服务器时必填)
     */
    private Integer startUs;

    /**
     * 用途
     */
    private Integer serverUseType;

    /**
     * 销售状态
     */
    private Integer status;

    /**
     * 显示方式
     */
    private Integer showMode;

    /**
     * 服务器位置
     */
    private String locationId;

    /**
     * 机柜ID
     */
    private String cabinetId;

    /**
     * 采购时间
     */
    private Date purchasingTime;

    /**
     * 入库时间
     */
    private Date storageTime;

    /**
     * 业务类型
     */
    private Integer businessType;

    /**
     * 网卡数量
     */
    private Integer networkNumber;

    /**
     * 是否支持raid
     */
    private Integer isRaid;

    /**
     * raid卡型号ID
     */
    private String raidModelId;

    /**
     * raid卡名称
     */
    private String raidName;

    /**
     * 发布状态(1否2是)
     */
    private Integer releaseStatus;

    private Integer isUseRaid;

    private Integer version = 0;
}
