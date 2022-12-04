package ru.croc.task17;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Set<Product> products = CSVParcer.createProductList("C:\\Users\\ninop\\IdeaProjects\\java-school-2022\\src\\ru\\croc\\task17\\resources\\orders.csv");
        List<OrderPosition> orderPositions = CSVParcer.createOrdersList("C:\\Users\\ninop\\IdeaProjects\\java-school-2022\\src\\ru\\croc\\task17\\resources\\orders.csv");
        TableCreator.createTables(products, orderPositions);
    }
}
