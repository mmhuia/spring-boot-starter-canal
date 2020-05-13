package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * CPU列表
 * </p>
 *
 * @author ymym
 * @since 2020-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssCpuDetail implements Serializable {

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
     * CPU编号
     */
    private String cpuCode;

    /**
     * CPU型号ID
     */
    private String cpuModelId;

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
     * 服务器ID
     */
    private String serverId;

    /**
     * 服务器管理IP
     */
    private String serverManagerIp;

    /**
     * 资源状态
     */
    private Integer status;

    /**
     * CPU来源
     */
    private Integer source;

    private Integer version = 0;


}
