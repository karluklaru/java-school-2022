package ru.croc.task17;

import java.util.ArrayList;
import java.util.List;

public class OrderPosition {
    private final String number;
    private final String login;
    private final List<String> products;

    public OrderPosition(String number, String login, String product) {
        this.number = number;
        this.login = login;
        this.products = new ArrayList<>();
        this.products.add(product);
    }

    public static int containsOrder(List<OrderPosition> positions, String number) {
        int i = 0;
        for (OrderPosition pos : positions) {
            if (pos.number.equals(number)) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    public String getNumber() {
        return number;
    }

    public String getLogin() {
        return login;
    }

    public List<String> getProducts() {
        return products;
    }

    public void addProduct(String product) {
        products.add(product);
    }
}
