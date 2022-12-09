package ru.croc.task18;

import java.sql.*;

public class ProductDao {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "sa";

    Product findProduct(String productCode) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        String sql = "SELECT * FROM PRODUCT WHERE ID = " + "'" + productCode + "'";
        String vendor = null;
        String name = null;
        int price = 0;
        try (Statement statement = connection.createStatement()) {
            try (ResultSet result = statement.executeQuery(sql)) {
                while (result.next()) {
                    vendor = result.getString("ID");
                    name = result.getString("NAME");
                    price = result.getInt("PRICE");
                }
            }
        }
        if (vendor != null && name != null && price != 0) {
            return new Product(vendor, name, price);
        }
        return null;
    }

    Product createProduct(Product product) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        if (findProduct(product.getVendor()) == null) {
            String sql = "INSERT INTO PRODUCT VALUES ('" + product.getVendor() + "',"
                    + "'" + product.getName() + "',"
                    + product.getPrice() + ")";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
                return product;
            }
        }
        else throw new SQLException("Продукт с таким артикулом уже есть!");
    }

    Product updateProduct(Product product) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        if (findProduct(product.getVendor()) != null) {
            String sql = "UPDATE PRODUCT SET NAME = '" + product.getName() + "', PRICE = " + product.getPrice() +
                    " WHERE ID = '" + product.getVendor() + "'";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
                return product;
            }
        }
        return null;
    }

    void deleteProduct(String productCode) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        if (findProduct(productCode) != null) {
            String sql = "DELETE FROM PRODUCT WHERE ID = '" + productCode + "'";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
                sql = "DELETE FROM ORDER_POSITION WHERE PRODUCT_ID = '" + productCode + "'";
                statement.executeUpdate(sql);
            }
        }
        else throw new SQLException("Продукта с таким артикулом не существует!");
    }

}
