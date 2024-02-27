package com.michaljach.s26234OrderService;

import org.springframework.stereotype.Component;

import java.util.List;


public class Order {
    private Client client;
    private List<Product> orderItems;
    private String address ="";
    private OrderStatus status;

public Order (Client client, List<Product> orderItems, String address, OrderStatus orderStatus) {
    this.client = client;
    this.orderItems = orderItems;
    this.address = address;
    this.status = OrderStatus.NOWE;

}

//    public Order(Client client, ProductStorage productStorage, String testAddress) {
//    }

    public Client getClient() {
    return client;
}

public List<Product> getOrderItems() {
    return orderItems;
}

    public OrderStatus getStatus() {
        return status;
    }

    public String getAddress() {
    return address;
}

public void setStatus (OrderStatus status) {
    this.status = status;
}

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", orderItems=" + orderItems +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}