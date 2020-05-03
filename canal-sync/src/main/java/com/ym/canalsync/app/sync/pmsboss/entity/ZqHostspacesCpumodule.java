package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * CPU模板
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesCpumodule implements Serializable {

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
     * cpu名称
     */
    private String name;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 型号
     */
    private String cpuModel;

    /**
     * 图片
     */
    private String url;

    /**
     * 显示类型
     */
    private String showMode;

    /**
     * 库存告警数量
     */
    private String warningNum;

    /**
     * 产品组
     */
    private String productGroup;


}
