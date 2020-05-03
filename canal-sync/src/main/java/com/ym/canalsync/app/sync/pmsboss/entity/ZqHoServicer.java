package com.ym.canalsync.app.sync.pmsboss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 单个服务类型
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHoServicer implements Serializable {

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
     * 模板服务器id
     */
    private String seMobanid;

    /**
     * 机柜
     */
    private String seCabinet;

    /**
     * 机柜区域
     */
    private String seCabinetarea;

    /**
     * 管理IP
     */
    private String seIp;

    /**
     * 采购时间
     */
    private Date sePurchasingtime;

    /**
     * 入库时间
     */
    private Date seStoragetime;

    /**
     * 入库类型
     */
    private Integer seStoragetype;

    /**
     * 销售状态(1：未售；2：已售)
     */
    private Integer seSalesstatus;

    /**
     * 内存
     */
    private String seNeicun;

    /**
     * 硬盘
     */
    private String seYingpan;

    /**
     * 区域
     */
    private String seArae;

    /**
     * 机房
     */
    private String seMachineroom;

    /**
     *  配置详情
     */
    private String seStorey;

    /**
     * 区域
     */
    private String seDistrict;

    /**
     * 机柜id
     */
    private String seCabinetid;

    /**
     * 物理位置码
     */
    private String sePositionalcode;

    /**
     * 预留字段1(用作开关机标识（开机，关机）)
     */
    private String remarks1;

    /**
     * 预留字段2
     */
    private String remarks2;

    private String remarks3;

    /**
     * 预留字段4(服务器控制台备注）
     */
    private String remarks4;

    /**
     * 预留字段5(销售控制台备注）
     */
    private String remarks5;

    /**
     * 是否升级
     */
    @TableField("isPromote")
    private String isPromote;

    /**
     * 开关机状态(默认开机为空，关机为关机）
     */
    private String switchState;

    /**
     * 是否是标准配置,0是，1不是
     */
    @TableField("isStandard")
    private String isStandard;

    /**
     * èµ„äº§ç¼–ç 
     */
    private String assetCoding;

    /**
     * 域名
     */
    private String domain;


}
