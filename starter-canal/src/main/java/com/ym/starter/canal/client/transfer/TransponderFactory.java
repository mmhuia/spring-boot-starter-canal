package com.ym.starter.canal.client.transfer;

import com.alibaba.otter.canal.client.CanalConnector;
import com.ym.starter.canal.client.ListenerPoint;
import com.ym.starter.canal.config.CanalConfig;
import com.ym.starter.canal.event.CanalEventListener;

import java.util.List;
import java.util.Map;

/**
 * TransponderFactory
 *
 * @author ym
 * @date 2020/4/10
 */
public interface TransponderFactory {

    /**
     * @param connector     connector
     * @param config        config
     * @param listeners     listeners
     * @param annoListeners annoListeners
     * @return MessageTransponder
     */
    MessageTransponder newTransponder(CanalConnector connector, Map.Entry<String, CanalConfig.Instance> config, List<CanalEventListener> listeners,
                                      List<ListenerPoint> annoListeners);
}
