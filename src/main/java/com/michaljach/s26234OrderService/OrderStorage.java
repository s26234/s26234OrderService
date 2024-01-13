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

    public Order getOrderById( int idOrder) {
        return orderList.stream().filter(order -> order.getClient().getIdClient() == idOrder).findFirst().orElseThrow(()->new IllegalArgumentException("Brak zamówienia o id " + idOrder));

    }



}
