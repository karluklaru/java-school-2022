package ru.croc.task17;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSVParcer {

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

    public static List<OrderPosition> createOrdersList(String pathToCSV) throws IOException {
        List<OrderPosition> orderEntries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(pathToCSV), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                orderEntries.add(new OrderPosition(values[0], values[1], values[2]));
            }
        }

        return orderEntries;
    }
}