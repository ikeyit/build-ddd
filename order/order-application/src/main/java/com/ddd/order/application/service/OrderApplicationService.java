package com.ddd.order.application.service;

import com.ddd.order.application.model.CreateOrderCommand;
import com.ddd.order.application.model.CreateOrderResult;
import com.ddd.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderApplicationService {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public CreateOrderResult createOrder(CreateOrderCommand createOrderCommand) {
        return new CreateOrderResult();
    }
}
