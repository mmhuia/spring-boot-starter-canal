package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * CPU型号
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssCpuModel implements Serializable {

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
     * CPU名称
     */
    private String cpuName;

    /**
     * CPU个数
     */
    private Integer cpuNumber;

    /**
     * CPU品牌
     */
    private String cpuBrand;

    /**
     * CPU型号
     */
    private String cpuModel;

    /**
     * CPU主频
     */
    private String cpuHz;

    /**
     * 接口类型
     */
    private String interfaceType;

    /**
     * CPU核心数
     */
    private Integer cpuCore;

    /**
     * CPU线程数
     */
    private Integer cpuThread;

    /**
     * 产品组映射ID
     */
    private String productMapId;

    private Integer version = 0;
}
