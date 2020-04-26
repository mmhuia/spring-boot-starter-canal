package com.ym.canalsync.app.sync.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Column;
import com.ym.canalsync.app.sync.entity.SysArea;

import java.util.List;


/**
 * <p>
 * 区域表 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-20
 */
public interface ISysAreaService extends IService<SysArea> {

    void sync(List<Column> data, String id);
}
