package com.michaljach.s26234OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class OrderServiceMockTest {

    @Mock
    private OrderStorage orderStorage;

    @Mock
    private ProductStorage productStorage;

    @InjectMocks
    private OrderService orderService;

//    @Test
//    public void testPlaceOrder() {
//        // Mock danych
//        Client client = new Client(1);
//        Product orange = new Product(2, "Orange", 3);
//        List<Product> orderItems = Collections.singletonList(orange);
//
//        // Mock zachowań
//        Mockito.when(productStorage.getProductById(2)).thenReturn(orange);
//
//        // Testowanie
//        orderService.placeOrder(1, orderItems, "TestAddress");
//
//        // Sprawdź, czy zamówienie zostało dodane do magazynu zamówień
//        Mockito.verify(orderStorage).addOrder(Mockito.any(Order.class));
//    }

//    @Test
//    public void testCheckOrderStatusM() {
//        // Przygotowanie danych
//        Client client = new Client(1);
//        Product banana = new Product(1, "Banana", 5);
//        Mockito.when(productStorage.getProductById(1)).thenReturn(banana);
//
//        // Złóż zamówienie na 1 banana
//        orderService.placeOrder(1, Collections.singletonList(banana), "TestAddress");
//
//        // Ustawienie statusu zamówienia na W_REALIZACJI
//        Order placedOrder = new Order(client, productStorage, "TestAddress");
//        placedOrder.setStatus(OrderStatus.W_REALIZACJI);
//        Mockito.when(orderStorage.getOrderById(1)).thenReturn(placedOrder);
//
//        // Sprawdzenie statusu zamówienia
//        OrderStatus orderStatus = orderService.checkOrderStatus(1);
//
//        // Sprawdzenie, czy status zamówienia to W_REALIZACJI
//        Assertions.assertEquals(OrderStatus.W_REALIZACJI, orderStatus);
//    }





}