package com.michaljach.s26234OrderService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderStorage {
    private List<Order> orderList= new ArrayList<>();


    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    // find product ??

    // find product by id ??

    // purge database

}
