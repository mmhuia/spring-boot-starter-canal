package com.ym.canalsync.app.sync.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 区域表
 * </p>
 *
 * @author ymym
 * @since 2020-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysArea implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String parentId;

    private String name;

    private String type;

    private String parentIds;

    private String code;

    private Integer sort;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;


}
