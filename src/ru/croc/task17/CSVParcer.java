package ru.croc.task17;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSVParcer {

    /**
     *
     * @param pathToCSV пусть до csv файла
     * @return список объектов типа Product, представляющего данные для таблицы PRODUCT
     */
    public static Set<Product> createProductList(String pathToCSV) throws IOException {
        Set<Product> productEntries = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathToCSV), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                productEntries.add(new Product(values[2], values[3], values[4]));
            }
            return productEntries;
        }
    }

    /**
     *
     * @param pathToCSV пусть до csv файла
     * @return список объектов типа OrderPosition, представляющего данные для таблицы ORDER_POSITION
     */
    public static List<OrderPosition> createOrdersList(String pathToCSV) throws IOException {
        List<OrderPosition> orderEntries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathToCSV), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (OrderPosition.containsOrder(orderEntries, values[0]) >= 0) {
                    int i = OrderPosition.containsOrder(orderEntries, values[0]);
                    orderEntries.get(i).addProduct(values[2]);
                }
                else {
                    orderEntries.add(new OrderPosition(values[0], values[1], values[2]));
                }
            }
        }
        return orderEntries;
    }
}
