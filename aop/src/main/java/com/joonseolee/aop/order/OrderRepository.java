package com.joonseolee.aop.order;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private static final List<Order> orders = new ArrayList<>();

    public Order findById(Long id) {
        return orders.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Order> findAll() {
        return orders.stream()
                .map(it -> new Order(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    public Order save(Order order) {
        var lastIndex = orders.size();
        var obj = new Order((long) lastIndex, order.getName());
        orders.add(obj);
        return obj;
    }
}
