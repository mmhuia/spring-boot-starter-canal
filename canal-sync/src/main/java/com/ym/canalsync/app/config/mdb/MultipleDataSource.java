package com.ym.canalsync.app.config.mdb;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 描述:
 *
 * @author YuanMan
 * @date 2020/4/10
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }

}
