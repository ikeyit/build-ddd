package com.ddd.order.domain.repository;

import com.ddd.order.domain.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> listOrders();
}
