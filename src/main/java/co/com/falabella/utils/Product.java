package co.com.falabella.utils;

import java.util.List;

public class Product {
    private String name;
    private int quantity;
    private String price;

    public Product() {

    }

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product(String name, int quantity, String price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public double Total(List<Product> products) {
        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            total = total + Double.parseDouble(products.get(i).getPrice());
        }
        System.out.println("total:" + total);
        return total;
    }
}
