package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 内存型号
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssMemoryModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 逻辑删除标记
     */
    private Integer isdel;

    /**
     * 内存名称
     */
    private String memName;

    /**
     * 内存大小（GB）
     */
    private Integer memSize;

    /**
     * 内存类型(1:DDR3 2:DDR4 3:未知)
     */
    private Integer memType;

    /**
     * 内存主频(Mhz)
     */
    private String memHz;

    /**
     * 内存品牌
     */
    private String memBrand;

    /**
     * 内存型号
     */
    private String memModel;

    /**
     * 内存规格(1:HM 2:FM 3:未知)
     */
    private Integer memSpec;

    /**
     * 内存校验(1:ECC 2:RECC 3:未知)
     */
    private Integer memVerify;

    /**
     * 产品组映射ID
     */
    private Integer productMapId;

    private Integer version = 0;
}
