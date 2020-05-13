package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 磁盘型号
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssDiskModel implements Serializable {

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
     * 磁盘名称
     */
    private String diskName;

    /**
     * 磁盘品牌
     */
    private String diskBrand;

    /**
     * 磁盘型号
     */
    private String diskModel;

    /**
     * 磁盘类别(0:机械硬盘 1:固态硬盘 2:未知)
     */
    private Integer diskType;

    /**
     * 类别简称(0:HDD 1:SSD 2:UNKNOWN)
     */
    private Integer diskShort;

    /**
     * 磁盘尺寸
     */
    private String diskMeasure;

    /**
     * 接口类型(0:SATA 1:SAS 2:UNKNOWN)
     */
    private Integer interfaceType;

    /**
     * 缓存大小(单位:M)
     */
    private String diskCache;

    /**
     * 磁盘转速
     */
    private String diskRpm;

    /**
     * 磁盘大小(单位:G)
     */
    private Integer diskSize;

    /**
     * 产品组映射ID
     */
    private String productMapId;

    /**
     * 用途类型
     */
    private Integer useType;

    private Integer version = 0;


}
