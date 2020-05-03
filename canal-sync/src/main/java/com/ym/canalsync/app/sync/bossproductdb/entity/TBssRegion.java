package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 国家/城市/机房/区域表
 * </p>
 *
 * @author ymym
 * @since 2020-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssRegion implements Serializable {

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
     * 机房ID
     */
    private String houseId;

    /**
     * 区域编码
     */
    private String code;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

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
     * 功率
     */
    private String power;

    /**
     * 电压
     */
    private String voltage;

    /**
     * 电流
     */
    private String amp;

    /**
     * 行
     */
    private Integer row;

    /**
     * 列
     */
    private Integer col;

    /**
     * 负责人
     */
    private String fzr;

    /**
     * 描述
     */
    private String description;

    /**
     * 机柜U位数
     */
    private Integer cabinetUCount;

    /**
     * 机柜规格
     */
    private String spec;

    /**
     * 机柜承重
     */
    private String bearing;


}
