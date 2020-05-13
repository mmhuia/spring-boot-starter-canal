package com.ym.canalsync.app.sync.pmsboss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ym.canalsync.app.route.Columns;
import com.ym.canalsync.app.sync.pmsboss.entity.ZqHoServersvolumes;

import java.util.List;

/**
 * <p>
 * 存内存或硬盘的容量卡槽 服务类
 * </p>
 *
 * @author ymym
 * @since 2020-04-29
 */
public interface IZqHoServersvolumesService extends IService<ZqHoServersvolumes> {

    Integer getVoVolumeBy(String voServicesid, int voTyep);

    List<ZqHoServersvolumes> getBy(String voServicesid, int voTyep);

    ZqHoServersvolumes getBy(String voVolumeid);

    void onInsertOrUpdate(Columns columns, String id);

    void delete(Columns columns, String id);

}
