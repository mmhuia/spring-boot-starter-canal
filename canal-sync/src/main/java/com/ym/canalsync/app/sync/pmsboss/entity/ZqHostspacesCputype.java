package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * CPU类型
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesCputype implements Serializable {

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
     * 产品类型
     */
    private String type;

    /**
     * 计费方式
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
     * 使用对象（台式/笔记本）
     */
    private String application;

    /**
     * 核心数
     */
    private String coreNumber;

    /**
     * CPU主频
     */
    private String cpuZp;

    /**
     * 接口类型
     */
    private String interfaceType;

    /**
     * 价格
     */
    private String price;

    /**
     * 告警价
     */
    private String warningPrice;

    /**
     * 币种
     */
    private String currency;

    /**
     * 物理位置码
     */
    private String positionCode;


}
