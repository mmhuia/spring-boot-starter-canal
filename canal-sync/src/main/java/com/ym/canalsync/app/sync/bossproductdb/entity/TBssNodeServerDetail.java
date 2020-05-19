package com.ym.canalsync.app.sync.bossproductdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 外机明细表
 * </p>
 *
 * @author ymym
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssNodeServerDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

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
     * 备注
     */
    private String remark;

    /**
     * 外机主表ID
     */
    private String nodeMasterId;

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
     * 服务器id
     */
    private String serverId;

    /**
     * 节点是否被占用
     */
    private Integer isOccupy;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 销售状态
     */
    private Integer status;

    /**
     * 版本号
     */
    private Long version = 0L;


}
