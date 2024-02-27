package com.michaljach.s26234OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class OrderServiceTest {
//    @Test
//    public void testPlaceOrderWithoutMocks() {
//        // Przygotowanie danych
//        OrderStorage orderStorage = new OrderStorage();
//        ProductStorage productStorage = new ProductStorage();
//        OrderService orderService = new OrderService(orderStorage, productStorage);
//
//        // Dodanie kilku produktów do magazynu
//        Product banana = new Product(1, "Banana", 5);
//        Product orange = new Product(2, "Orange", 3);
//        productStorage.addProduct(banana);
//        productStorage.addProduct(orange);
//
//        // Złóż zamówienie na 2 pomarańcze i 1 banana
//        List<Product> orderItems = Arrays.asList(orange, banana);
//        orderService.placeOrder(1, orderItems, "TestAddress");
//
//        // Sprawdzenie, czy zamówienie zostało dodane do magazynu zamówień
//        List<Order> orderList = orderStorage.getOrderList();
//        Assertions.assertEquals(1, orderList.size());
//
//        // Sprawdzenie, czy zamówienie ma odpowiednie produkty
//        Order placedOrder = orderList.get(0);
//        Assertions.assertEquals(2, placedOrder.getProductStorage().getProductList().size());
//        Assertions.assertTrue(placedOrder.getProductStorage().getProductList().contains(orange));
//        Assertions.assertTrue(placedOrder.getProductStorage().getProductList().contains(banana));
//    }

    @Test
    public void testCancelOrder() {
        // Przygotowanie danych
        OrderStorage orderStorage = new OrderStorage();
        ProductStorage productStorage = new ProductStorage();
        OrderService orderService = new OrderService(orderStorage, productStorage);

        // Dodanie kilku produktów do magazynu
        Product banana = new Product(1, "Banana", 5);
        productStorage.addProduct(banana);

        // Złóż zamówienie na 1 banana
        List<Product> orderItems = Collections.singletonList(banana);
        orderService.placeOrder(1, orderItems, "TestAddress");

        // Anuluj zamówienie
        boolean canceled = orderService.cancelOrder(1);

        // Sprawdzenie, czy zamówienie zostało anulowane
        Assertions.assertTrue(canceled);

        // Sprawdzenie, czy status zamówienia to ANULOWANE
        Order canceledOrder = orderStorage.getOrderList().get(0);
        Assertions.assertEquals(OrderStatus.ANULOWANE, canceledOrder.getStatus());
    }

    @Test
    public void testCheckOrderStatus() {
        // Przygotowanie danych
        OrderStorage orderStorage = new OrderStorage();
        ProductStorage productStorage = new ProductStorage();
        OrderService orderService = new OrderService(orderStorage, productStorage);

        // Dodanie kilku produktów do magazynu
        Product banana = new Product(1, "Banana", 5);
        productStorage.addProduct(banana);

        // Złóż zamówienie na 1 banana
        List<Product> orderItems = Collections.singletonList(banana);
        orderService.placeOrder(1, orderItems, "TestAddress");

        // Sprawdzenie statusu zamówienia
        OrderStatus orderStatus = orderService.checkOrderStatus(1);

        // Sprawdzenie, czy status zamówienia to NOWE
        Assertions.assertEquals(OrderStatus.NOWE, orderStatus);
    }




}
