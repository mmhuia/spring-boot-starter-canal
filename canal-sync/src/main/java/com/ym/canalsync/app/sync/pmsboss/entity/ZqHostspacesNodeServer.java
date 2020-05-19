package com.ym.canalsync.app.sync.pmsboss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 外机
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesNodeServer implements Serializable {

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
     * 关联交换机
     */
    private String switchId;

    /**
     * 管理ip
     */
    private String ip;

    /**
     * 采购时间
     */
    private Date buyTime;

    /**
     * 入库时间
     */
    private Date storageTime;

    /**
     * 关联外机模版
     */
    private String nodeServerModuleId;

    /**
     * 编号
     */
    private String number;

    /**
     * 物理位置碼
     */
    private String mac;

    /**
     * 起始U位
     */
    private String startNum;

    /**
     * 地区
     */
    private String area;

    /**
     * 机房
     */
    private String house;

    @TableField("cabinetId")
    private String cabinetId;


}
