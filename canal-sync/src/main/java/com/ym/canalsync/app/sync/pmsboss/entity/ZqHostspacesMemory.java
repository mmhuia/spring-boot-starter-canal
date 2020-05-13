package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 入库后的内存
 * </p>
 *
 * @author ymym
 * @since 2020-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesMemory implements Serializable {

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
     * 类型名称(关联模板得到类型)
     */
    private String typeName;

    /**
     * 内存名称
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
     * 使用状态(0:未使用，1：已使用,2故障中)
     */
    private String useState;

    /**
     * 发布状态（0：已发布，1：未发布）
     */
    private String publishState;

    /**
     * 物理位置码
     */
    private String positionCode;

    /**
     * 地区
     */
    private String area;

    /**
     * 机房
     */
    private String house;

    /**
     * èµ„äº§ç¼–ç 
     */
    private String assetCoding;


}
