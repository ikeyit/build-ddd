package com.ddd.order.interfaces.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yourname <yourname@kuaishou.com>
 * Created on 2021-09-16
 */
@SpringBootApplication(scanBasePackages = {"com.ddd.order.domain",
        "com.ddd.order.infrastructure",
        "com.ddd.order.interfaces.task"})
@EnableScheduling
public class TaskApp {

    public static void main(String... args) {
        SpringApplication springApplication = new SpringApplication(TaskApp.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }
}
