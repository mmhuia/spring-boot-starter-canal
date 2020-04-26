package com.ym.canalsync;

import com.ym.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ym
 */
@SpringBootApplication
@EnableCanalClient
public class CanalSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanalSyncApplication.class, args);
    }

}
