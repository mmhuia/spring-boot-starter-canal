package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 机房管理
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesHouse implements Serializable {

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
     * 机房名称
     */
    private String name;

    /**
     * 代码
     */
    private String code;

    /**
     * 机房属性
     */
    private String attribution;

    /**
     * 地区
     */
    private String area;

    /**
     * 坐标
     */
    private String coordinate;

    /**
     * 电压
     */
    private String voltage;

    /**
     * 电流
     */
    private String amp;

    /**
     * 功率
     */
    private String power;

    /**
     * 负责人
     */
    private String head;

    /**
     * 描述
     */
    private String description;

    /**
     * 物理位置码
     */
    private String positionCode;

    /**
     * 机房排序
     */
    private String sort;


}
