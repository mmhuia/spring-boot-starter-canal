package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 区域表
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;

    /**
     * 父级编号
     */
    private String parentId;

    /**
     * 所有父级编号
     */
    private String name;

    /**
     * 名称
     */
    private String type;

    /**
     * 排序
     */
    private String parentIds;

    /**
     * 区域编码
     */
    private String code;

    /**
     * 区域类型
     */
    private BigDecimal sort;

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
     * 删除标记
     */
    private String delFlag;


}
