package ru.croc.task18;

import java.util.List;

public class Order {
    private final int number;
    private final String name;
    private final List<Product> vendors;

    public Order(int number, String name, List<Product> vendors) {
        this.number = number;
        this.name = name;
        this.vendors = vendors;
    }
}
