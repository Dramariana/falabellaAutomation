package co.com.falabella.utils;

import java.util.List;

public class Product {
    private String name;
    private int quantity;
    private int price;

    public Product() {

    }

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product(String name, int quantity, int price) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public int Total(List<Product> products) {
        int total = 0;
        for (int i = 0; i < products.size(); i++) {total = total + products.get(i).getPrice() * products.get(i).getQuantity();

        }

        return total;
    }

    public boolean compareList(List<Product> list1, List<Product> list2) {

        Boolean isEqual = false;
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).getName().equals(list2.get(j).getName())) {
                    if (list1.get(i).getQuantity() == list2.get(j).getQuantity()) {
                        if (list1.get(i).getPrice() == list2.get(j).getPrice()) {
                            isEqual = true;

                        }
                    }
                }
            }

        }


        return isEqual;
    }
}
