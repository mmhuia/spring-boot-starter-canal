package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VBssAreainfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fullLocationId;

    private String fullLocationCode;

    private String fullLocationName;

    private String houseLocationId;

    private String houseLocationCode;

    private String houseLocationName;

    /**
     * 主键
     */
    private String areaId;

    /**
     * 名称
     */
    private String areaName;

    /**
     * 编码
     */
    private String areaCode;

    /**
     * 主键
     */
    private String houseId;

    /**
     * 机房名称
     */
    private String houseName;

    /**
     * 机房编码
     */
    private String houseCode;

    /**
     * 主键
     */
    private String regionId;

    /**
     * 区域名称
     */
    private String regionName;

    /**
     * 区域编码
     */
    private String regionCode;


}
