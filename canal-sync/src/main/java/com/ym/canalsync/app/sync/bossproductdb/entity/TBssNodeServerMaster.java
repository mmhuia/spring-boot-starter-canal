package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 外机主表
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssNodeServerMaster implements Serializable {

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
     * 外机设备品牌
     */
    private String deviceBrand;

    /**
     * 外机设备型号
     */
    private String deviceModel;

    /**
     * 外机设备规格
     */
    private String deviceSpec;

    /**
     * 节点数
     */
    private Integer nodeNum;

    /**
     * 占用U数
     */
    private Integer us;

    /**
     * 起始U数
     */
    private Integer startUs;

    /**
     * 位置ID
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
     * 销售状态
     */
    private Integer status;

    /**
     * 版本号
     */
    private Long version = 0L;


}
