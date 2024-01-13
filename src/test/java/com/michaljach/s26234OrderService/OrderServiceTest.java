package com.michaljach.s26234OrderService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

    @Test
    public void confirmDeliveryTest() {
    ProductStorage productStorage = new ProductStorage();
    OrderStorage orderStorage = new OrderStorage();
    OrderService orderService = new OrderService(orderStorage,productStorage);

    List<Product> orderItems = Collections.singletonList(new Product(1, "Orange", 3));
    orderService.placeOrder(1, orderItems ,"Adres zastrzeżony");

    boolean confirmed = orderService.confirmDelivery(1);

        Assertions.assertTrue(confirmed);
        Assertions.assertEquals(OrderStatus.DOSTARCZONE,orderStorage.getOrderList().get(0).getStatus());


    }

}
