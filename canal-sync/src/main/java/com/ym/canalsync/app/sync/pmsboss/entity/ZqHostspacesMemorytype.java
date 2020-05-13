package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 内存类型
 * </p>
 *
 * @author ymym
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesMemorytype implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
    private String delFlag;

    /**
     * 产品类型（0：实体，1：虚拟）
     */
    private String type;

    /**
     * 计费方式（0按天，1按月，2按年）
     */
    private String chargeMode;

    /**
     * 地区
     */
    private String area;

    /**
     * 机房
     */
    private String house;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 内存类型
     */
    private String memoryType;

    /**
     * 内存主频
     */
    private String memoryZp;

    /**
     * 内存容量
     */
    private String memoryCapacity;

    /**
     * 价格
     */
    private String price;

    /**
     * 告警价
     */
    private String memoryWarningprice;

    /**
     * 币种
     */
    private String currency;

    /**
     * 物理位置码
     */
    private String positionCode;

    private String approvalPrice;


}
