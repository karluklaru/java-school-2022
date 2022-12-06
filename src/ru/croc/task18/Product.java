package ru.croc.task18;

public class Product {
    String vendor;
    String name;
    int price;

    public Product(String vendor, String name, int price) {
        this.vendor = vendor;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "vendor='" + vendor + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getVendor() {
        return vendor;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

}
