package com.ym.canalsync;

import com.ym.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ym
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCanalClient
@EnableEurekaClient
public class CanalSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanalSyncApplication.class, args);
    }

}
