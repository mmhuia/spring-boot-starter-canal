package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 磁盘列表
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssDiskDetail implements Serializable {

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
     * 磁盘编号
     */
    private String diskCode;

    /**
     * 磁盘型号ID
     */
    private String diskModelId;

    /**
     * 机房ID
     */
    private String houseId;

    /**
     * 采购时间
     */
    private Date purchasingTime;

    /**
     * 入库时间
     */
    private Date storageTime;

    /**
     * 资源归属(1:公用 2:专用)
     */
    private Integer resourceAttribution;

    /**
     * 资源归属方ID
     */
    private String customerId;

    /**
     * 资源归属方名称
     */
    private String customerName;

    /**
     * 销售状态
     */
    private Integer saleStatus;

    /**
     * 服务器ID
     */
    private String serverId;

    /**
     * 服务器管理IP
     */
    private String serverManagerIp;

    /**
     * 显示类型
     */
    private Integer showType;

    /**
     * 发布状态
     */
    private Integer releaseStatus;

    /**
     * 磁盘来源
     */
    private Integer source;

    private Integer version = 0;


}
