package com.ym.canalsync.app.sync.bossauthdb.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户字典表
 * </p>
 *
 * @author ymym
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBssUserDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 值
     */
    private Integer keyValues;

    /**
     * 名称
     */
    private String keyNames;

    /**
     * 类型
     */
    private String keyType;

    /**
     * 描述
     */
    private String keyDesc;


}
