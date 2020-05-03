package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 机柜
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssCabinet implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 行
     */
    private Integer row;

    /**
     * 列
     */
    private Integer coulmn;

    /**
     * 机柜名称
     */
    private String name;

    /**
     * U数
     */
    private Integer us;

    /**
     * 规格
     */
    private String spec;

    /**
     * 电压
     */
    private String voltage;

    /**
     * 电流
     */
    private String amp;

    /**
     * 功率
     */
    private String power;

    /**
     * 承重
     */
    private String bearing;

    /**
     * 机柜属性
     */
    private Integer attribute;

    /**
     * 逻辑删除
     */
    private Integer isdel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * 区域位置码
     */
    private String locationId;

    /**
     * 区域ID
     */
    private String regionId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 类型(0:机柜 1:障碍物)
     */
    private Integer type;

    /**
     * 机柜状态
     */
    private Integer status;


}
