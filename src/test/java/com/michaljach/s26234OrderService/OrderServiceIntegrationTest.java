package com.michaljach.s26234OrderService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
@SpringBootTest
public class OrderServiceIntegrationTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void testPlaceOrderIntegration() {
        // Dane rzeczywiste (bez mocków)
        ProductStorage productStorage = new ProductStorage();
        productStorage.addProduct(new Product(1, "Banana", 5));
        productStorage.addProduct(new Product(2, "Orange", 3));

        OrderStorage orderStorage = new OrderStorage();

        OrderService orderService = new OrderService(orderStorage, productStorage);

        // Testowanie
        List<Product> orderItems = Arrays.asList(
                productStorage.getProductById(2),   // Orange
                productStorage.getProductById(1)    // Banana
        );
        orderService.placeOrder(1, orderItems, "TestAddress");

        // Sprawdź, czy zamówienie zostało dodane do magazynu zamówień
        Assertions.assertEquals(1, orderStorage.getOrderList().size());
    }


}
