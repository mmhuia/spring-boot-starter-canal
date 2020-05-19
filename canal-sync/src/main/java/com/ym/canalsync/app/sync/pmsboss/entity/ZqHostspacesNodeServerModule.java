package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 服务器外机(节点服务器)
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesNodeServerModule implements Serializable {

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
     * 产品组
     */
    private String division;

    /**
     * 模版名称
     */
    private String modelName;

    /**
     * 外机名称
     */
    private String nodeServerName;

    /**
     * 占用U位
     */
    private Integer uNum;

    /**
     * 计费方式
     */
    private String chargeType;

    /**
     * 机柜id
     */
    private String cabinetId;

    /**
     * 图片
     */
    private String image;

    /**
     * 节点总数
     */
    private Integer nodeNum;

    /**
     * 节点集
     */
    private String nodes;

    /**
     * 类型
     */
    private String type;

    /**
     * 编号
     */
    private String number;

    /**
     * 地区
     */
    private String area;

    /**
     * 机房
     */
    private String house;


}
