package com.ddd.order.interfaces.task;

import com.ddd.order.domain.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private OrderService orderService;

    @Value("${spring.datasource.url}")
    private String url;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("Connection: {} ", url);
        log.info("Now: {} ", dateFormat.format(new Date()));
        System.out.println(orderService.getOrders());
    }
}