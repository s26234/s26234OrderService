package com.michaljach.s26234OrderService;

import org.springframework.stereotype.Component;


public class Order {
    private Client client;
    private ProductStorage productStorage;
    private String address ="";

public Order (Client client, ProductStorage productStorage, String address) {
    this.client = client;
    this.productStorage = productStorage;
    this.address = address;
}

public Client getClient() {
    return client;
}

public ProductStorage getProductStorage() {
    return productStorage;
}

public String getAddress() {
    return address;
}




}