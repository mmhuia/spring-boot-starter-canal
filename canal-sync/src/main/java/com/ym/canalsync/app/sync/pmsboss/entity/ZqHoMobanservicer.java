package com.ym.canalsync.app.sync.pmsboss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 服务器模板
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHoMobanservicer implements Serializable {

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
     * 图片
     */
    private String seImgurl;

    /**
     * 模板名称
     */
    private String seTempletname;

    /**
     * 产品组
     */
    private String seProductgroup;

    /**
     * 设备类型
     */
    private Integer seUnittype;

    /**
     * 计费方式 （ 按天 按月）
     */
    private Integer seBillingmethods;

    /**
     * 硬盘
     */
    private String seCaliche;

    /**
     * 硬盘插槽数
     */
    private Integer seCalicheslotnum;

    /**
     * cpu
     */
    private String seCpu;

    /**
     * 内存
     */
    private String seEms;

    /**
     * 硬盘类型 1 机械 2 ssd  3  混合
     */
    private String seLocationcode;

    /**
     * 内存插槽数
     */
    private Integer seEmsnum;

    /**
     * 内存容量
     */
    private Integer seMemorycapacity;

    /**
     * 单价
     */
    private Double seUnitprice;

    /**
     * 告警价
     */
    private Double seAlarmprice;

    /**
     * 审核价
     */
    private Double seAuditprice;

    /**
     * 币种
     */
    private Integer seCurrency;

    /**
     * 占用U位数
     */
    private Integer seOccupiednum;

    /**
     * 规格
     */
    private String seNorms;

    /**
     * 使用类型
     */
    private Integer seUsetype;

    /**
     * 显示类型
     */
    private Integer seDisplaytype;

    /**
     * 独特性
     */
    private String seSpecificity;

    private String recommended;

    /**
     * 说明内容
     */
    private String seExplaincontent;

    /**
     * 参数
     */
    private String seParameter;

    /**
     * 内容
     */
    @TableField("se_serviceContent")
    private String seServicecontent;

    /**
     * 库存告警数
     */
    private Integer seEmergency;

    /**
     * 1 模板选配置， 2配置选模板
     */
    private Integer seConfiguretype;

    /**
     * 发布状态
     */
    private Integer serviceInsd;

    /**
     * cpuid
     */
    private String seCpuid;

    /**
     * 父级模板
     */
    @TableField("parentId")
    private String parentId;

    /**
     * 预留字段1
     */
    private String remarks1;

    /**
     * 预留字段2
     */
    private String remarks2;

    /**
     * 预留字段3
     */
    private String remarks3;

    /**
     * 预留字段4
     */
    private String remarks4;

    /**
     * 预留字段5
     */
    private String remarks5;

    /**
     * 硬盘信息
     */
    private String calicheStrs;

    /**
     * 固态硬盘信息
     */
    private String calicheguStrs;

    /**
     * 模板配置信息
     */
    private String calicheguStrsnum;


}
