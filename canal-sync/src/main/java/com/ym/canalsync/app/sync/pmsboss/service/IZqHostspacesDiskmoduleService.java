package com.ym.canalsync.app.sync.pmsboss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHostspacesDiskmodule;

import java.util.List;

/**
 * <p>
 * 硬盘模板 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-05-11
 */
public interface IZqHostspacesDiskmoduleService extends IService<ZqHostspacesDiskmodule> {

    List<ZqHostspacesDiskmodule> getBy(String typeName);
}
