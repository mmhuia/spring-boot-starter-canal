package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 硬盘模板
 * </p>
 *
 * @author ymym
 * @since 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesDiskmodule implements Serializable {

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
     * 类型名称
     */
    private String typeName;

    /**
     * 硬盘名称
     */
    private String name;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 显示类型（0：外显，1：内显）
     */
    private String showMode;

    /**
     * 接口类型
     */
    private String interfaceType;

    /**
     * 接口速率
     */
    private String interfaceSpeed;

    /**
     * 读取速度
     */
    private String readSpeed;

    /**
     * 缓存
     */
    private String diskCache;

    /**
     * 转速
     */
    private String speed;

    /**
     * 库存告警数量
     */
    private String warningNum;

    /**
     * 产品组
     */
    private String productGroup;


}
