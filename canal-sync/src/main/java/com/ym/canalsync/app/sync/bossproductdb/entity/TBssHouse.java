package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 国家/城市/机房/
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssHouse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 地区ID
     */
    private String districtId;

    /**
     * 机房编码
     */
    private String code;

    /**
     * 机房名称
     */
    private String name;

    /**
     * 别名
     */
    private String alias;

    /**
     * 逻辑删除
     */
    private Integer isdel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 楼层号
     */
    private String num;

    /**
     * 地址信息
     */
    private String addr;

    /**
     * 原机房code
     */
    private String oldHouseCode;

    /**
     * 原机房名称
     */
    private String oldHouseName;

    /**
     * 机房属性
     */
    private Integer attribute;

    /**
     * 机房等级
     */
    private Integer houseLevel;

    /**
     * 备注
     */
    private String remark;

    /**
     * 机柜U数
     */
    private Integer cabinetUs;

    /**
     * 机柜规格
     */
    private String cabinetSpec;

    /**
     * 机柜承重
     */
    private String cabinetBearing;

    /**
     * 机柜电压
     */
    private String cabinetVoltage;

    /**
     * 机柜电力
     */
    private String cabinetAmp;

    /**
     * PDU情况
     */
    private String cabinetPdu;

    private Integer version = 0;


}
