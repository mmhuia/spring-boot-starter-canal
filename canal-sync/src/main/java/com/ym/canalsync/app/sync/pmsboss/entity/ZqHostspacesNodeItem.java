package com.ym.canalsync.app.sync.pmsboss.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 外机(节点服务器)
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZqHostspacesNodeItem implements Serializable {

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
     * 节点位
     */
    private String node;

    /**
     * 服务器ip
     */
    private String serverIp;

    /**
     * 服务器名称
     */
    private String serverName;

    /**
     * 业务状态
     */
    private String serverStatus;

    /**
     * 服务器id
     */
    private String serverId;

    /**
     * 节点服务器id
     */
    private String nodeServerId;

    /**
     * 节点是否被占用
     */
    private Integer isOccupy;

    /**
     * 排序
     */
    private Integer sort;


}
