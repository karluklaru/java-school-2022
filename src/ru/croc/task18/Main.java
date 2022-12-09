package ru.croc.task18;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductDao productDao = new ProductDao();
        OrderDao orderDao = new OrderDao();
        System.out.println(productDao.findProduct("Т9"));
        System.out.println(productDao.createProduct(new Product("Т9", "Колонка", 3000)));
        List<Product> products = new ArrayList<>();
        products.add(new Product("Т15", "Колонка", 4000));
        products.add(new Product("Т12", "Наушники", 4000));
        products.add(new Product("Т4", "Блок питания", 200));
        orderDao.createOrder("nina", products);

    }
}
