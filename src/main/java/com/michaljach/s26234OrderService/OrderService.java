package com.michaljach.s26234OrderService;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    private final OrderStorage orderStorage;
    private final ProductStorage productStorage;

    public OrderService(OrderStorage orderStorage, ProductStorage productStorage) {
        this.orderStorage = orderStorage;
        this.productStorage = productStorage;
    }

    public void placeOrder (int idClient, List<Product> orderItems,String address) {
        Client client = new Client(idClient);
        Order order = new Order(client, orderItems, address, OrderStatus.NOWE);
        validateAndPalceOrder(order);

    }

    public OrderStatus checkOrderStatus (int idOrder) {
        Order order = orderStorage.getOrderById(idOrder);
        return order.getStatus();
    }

    public boolean cancelOrder (int idOrder) {
        Order order = orderStorage.getOrderById(idOrder);
        if(order.getStatus() == OrderStatus.NOWE || order.getStatus() == OrderStatus.W_REALIZACJI) {
            order.setStatus(OrderStatus.ANULOWANE);
            return true;
        }
        return false;
    }


    public boolean confirmDelivery (int idOrder) {
        Order order = orderStorage.getOrderById(idOrder);
        if(order.getStatus() == OrderStatus.W_REALIZACJI) {
            order.setStatus(OrderStatus.DOSTARCZONE);
            return true;
        }
        return false;
    }

    public void validateAndPalceOrder (Order order) {
        for (Product orderItem : order.getOrderItems()) {
            validateProductExistence(orderItem);
            validateProductQuantity(orderItem);

        } orderStorage.addOrder(order);

    }

    public void validateProductQuantity (Product product) {
        int requestedQuantity = 1;
        int availableQuantity = (int)product.getQuantity();
        if (requestedQuantity > availableQuantity) {
            throw new IllegalArgumentException("Niewystarczająca ilość produktu: " + product.getIdProd());
        }
    }


    public void validateProductExistence (Product product) {
        if (!productStorage.getProductStorage().contains(product)) {
            throw new IllegalArgumentException("Produkt " + product.getIdProd() + " nie istnieje");
        }
    }


}
