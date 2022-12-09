package ru.croc.task18;

import java.sql.*;
import java.util.List;

public class OrderDao {


    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "sa";

    ProductDao productDao = new ProductDao();

    Order createOrder(String userLogin, List<Product> products) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        String sql = "SELECT MAX(NUM) as MAX FROM ORDER_POSITION";

        try (Statement statement = connection.createStatement()) {
            int max = 0;
            try (ResultSet result = statement.executeQuery(sql)) {
                while (result.next()) {
                    max = result.getInt("MAX");
                }
            }
            int num = max + 1;

            for (Product product : products) {
                if (productDao.findProduct(product.getVendor()) == null) {
                    productDao.createProduct(product);
                }
                sql = "INSERT INTO ORDER_POSITION VALUES (" + num + ","
                        + "'" + userLogin + "',"
                        + "'" + product.getVendor() + "')";
                statement.executeUpdate(sql);
            }

            return new Order(num, userLogin, products);
        }
    }
}
