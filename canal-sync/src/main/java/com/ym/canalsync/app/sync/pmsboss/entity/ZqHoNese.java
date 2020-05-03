package com.ym.canalsync.app.sync.pmsboss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 网卡和服务器的中间表
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHoNese implements Serializable {

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
     * 网卡id
     */
    private String neId;

    /**
     * 服务器ID
     */
    private String seId;

    /**
     * 交换机id
     */
    private String switchboardId;

    /**
     * 端口id
     */
    private String portId;

    /**
     * 内网端口升级判断
     */
    @TableField("netStatus")
    private String netStatus;

    private String url;


}
