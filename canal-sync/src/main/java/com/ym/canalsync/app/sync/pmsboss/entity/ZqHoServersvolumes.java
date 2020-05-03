package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 存内存或硬盘的容量卡槽
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHoServersvolumes implements Serializable {

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
     * 卡槽
     */
    private String voCardslot;

    /**
     * 服务器id
     */
    private String voServicesid;

    /**
     * 容量
     */
    private String voVolume;

    /**
     * 类型（1内存2硬盘）
     */
    private String voTyep;

    /**
     * 服务器id
     */
    private String voVolumeid;

    /**
     * 模板id
     */
    private String voSeviceid;

    /**
     * 是否是升级之后的默认配置（0是）
     */
    private String isDefault;

    /**
     * 硬盘类型（0机械，1固态）
     */
    private String volumeType;


}
