package ru.croc.task17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

public class TableCreator {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    static final String USER = "sa";
    static final String PASS = "sa";

    public static void createTables(Set<Product> products, List<OrderPosition> orderPositions) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL,USER,PASS)) {
            try (Statement statement = connection.createStatement()) {
                String sql;

                sql = "CREATE TABLE IF NOT EXISTS PRODUCT " +
                        "(ID VARCHAR(255) not NULL, " +
                        " NAME VARCHAR(255) not NULL, " +
                        " PRICE INTEGER not NULL, " +
                        " PRIMARY KEY ( ID ))";
                statement.executeUpdate(sql);

                sql = "CREATE TABLE IF NOT EXISTS ORDER_POSITION " +
                        " (NUM INTEGER not NULL, " +
                        " LOGIN VARCHAR(255) not NULL, " +
                        " PRODUCT_ID VARCHAR(255) not NULL REFERENCES PRODUCT(ID) " +
                        " )";
                statement.executeUpdate(sql);

                for (Product p : products) {
                    sql = "INSERT INTO PRODUCT " + " VALUES( '" + p.id() + "', '" + p.name() + "',  " + p.price() + ")";
                    statement.executeUpdate(sql);
                }

                for (OrderPosition op : orderPositions) {
                    sql = "INSERT INTO ORDER_POSITION " + " VALUES( "
                            + op.number() + " ,'"
                            + op.login() + "', '"
                            + op.product() + "' ) ";
                    statement.executeUpdate(sql);
                }
            }
        }
    }
}