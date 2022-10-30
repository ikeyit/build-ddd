package com.ddd.order.interfaces.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yourname <yourname@kuaishou.com>
 * Created on 2021-09-16
 */
@SpringBootApplication(scanBasePackages = {"com.ddd.order.domain",
        "com.ddd.order.infrastructure",
        "com.ddd.order.interfaces.rest"})
public class RestApp {

    public static void main(String... args) {
        SpringApplication springApplication = new SpringApplication(RestApp.class);
        springApplication.run(args);
    }
}
