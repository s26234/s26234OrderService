package com.michaljach.s26234OrderService;

public class Product {
    private int idProd;
    private String name;
    private int quantity;

    public Product (int idProd, String name, int quantity) {
        this.idProd = idProd;
        this.name = name;
        this.quantity = quantity;

    }

    public int getIdProd() {
        return idProd;
    }

    public String getName() {
        return name;
    }

    public  double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProd=" + idProd +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
