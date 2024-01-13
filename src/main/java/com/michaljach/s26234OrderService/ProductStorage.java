package com.michaljach.s26234OrderService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductStorage {
    private List<Product> productStorage = new ArrayList<>();

    public List<Product> getProductStorage() {
        return productStorage;
    }

    public void addProduct ( Product product) {
        productStorage.add(product);
    }

    public Product getProductById(int id) {
        return productStorage.stream().filter(product -> product.getIdProd()==id).findFirst().orElseThrow(()-> new IllegalArgumentException("Brak produktu z id " + id));
    }


}
