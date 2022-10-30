package com.ddd.order.interfaces.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ddd.order.domain",
        "com.ddd.order.infrastructure",
        "com.ddd.order.interfaces.commandline"})
public class CommandLineApp implements CommandLineRunner {

    public static void main(String... args) {
        SpringApplication springApplication = new SpringApplication(CommandLineApp.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(args);
    }
}
