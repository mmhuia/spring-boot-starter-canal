package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 硬盘入库后
 * </p>
 *
 * @author ymym
 * @since 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesDisk implements Serializable {

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
    private String diskModule;

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
     * 使用状态(0未使用，1已使用)
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
