package com.ym.canalsync.app.config.mdb;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 描述:动态数据源切换AOP
 *
 * @author YuanMan
 * @date 2020/4/10
 */
@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {

    @Pointcut("@within(com.ym.canalsync.app.config.mdb.DataSource) || @annotation(com.ym.canalsync.app.config.mdb.DataSource)")
    public void pointCut() {

    }

    @Before("pointCut() && @annotation(dataSource)")
    public void doBefore(DataSource dataSource) {
        log.debug("选择数据源---" + dataSource.value().getValue());
        DataSourceContextHolder.setDataSource(dataSource.value().getValue());
    }

    @After("pointCut()")
    public void doAfter() {
        DataSourceContextHolder.clear();
    }

}
