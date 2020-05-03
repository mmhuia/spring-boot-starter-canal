package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 楼层
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesFloor implements Serializable {

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
     * 楼层名称
     */
    private String name;

    /**
     * 楼层代码
     */
    private String code;

    /**
     * 所属机房
     */
    private String house;

    /**
     * 楼层号
     */
    private String number;

    /**
     * 楼层面积
     */
    private String proportion;

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
     * 楼层别名
     */
    private String alias;


}
