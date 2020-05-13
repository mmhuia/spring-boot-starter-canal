package com.ym.canalsync.app.sync.pmsboss.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 模板网卡
 * </p>
 *
 * @author ymym
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHoNetworkcard implements Serializable {

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
    private String neMobanid;

    /**
     * 网卡名称
     */
    private String neName;

    /**
     * 网卡类型
     */
    private String neType;

    /**
     * 网口类型
     */
    private String neExport;

    /**
     * 1  是默认    2 不是默认
     */
    private String neDefaultport;

    /**
     * 是否管理网卡（0：否；1：是）
     */
    @TableField("isMangeCard")
    private String isMangeCard;

    private String neUrl;

    private String neUsername;

    private String nePassword;


}
