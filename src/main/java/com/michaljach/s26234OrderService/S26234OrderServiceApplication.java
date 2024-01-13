package com.michaljach.s26234OrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class S26234OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(S26234OrderServiceApplication.class, args);

	ProductStorage productStorage = new ProductStorage();
	productStorage.addProduct(new Product(1,"Banana", 5));
	productStorage.addProduct(new Product(2,"Orange", 3));

	OrderStorage orderStorage = new OrderStorage();
	OrderService orderService = new OrderService(orderStorage, productStorage);

		List<Product> firstOrder = Arrays.asList( productStorage.getProductById(1),productStorage.getProductById(2));
									orderService.placeOrder(12,firstOrder,"ul.Truskawkowa15");

		OrderStatus firstOrderStatus = orderService.checkOrderStatus(12);
		System.out.println("Status zamówienia " + firstOrderStatus);

		boolean cancelOrderr = orderService.cancelOrder(12);
		System.out.println("Zamówienie " + cancelOrderr + " zostało anulowane");





	}

}
