package com.ddd.order.infrastructure.repository;

import com.ddd.order.domain.model.Order;
import com.ddd.order.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    private final BeanPropertyRowMapper<Order> rowMapper = new BeanPropertyRowMapper<>(Order.class);

    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> listOrders() {
        String sql = "select * from orders limit 100" ;
        return jdbcTemplate.query(sql, rowMapper);
    }

}
