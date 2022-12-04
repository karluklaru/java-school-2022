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

    public static void createTables(Set<Product> products, List<OrderPosition> orderPositions) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);

            statement = connection.createStatement();

            String sql = "DROP TABLE IF EXISTS ORDER_POSITION";
            statement.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS PRODUCT;";
            statement.executeUpdate(sql);

            sql =  "CREATE TABLE IF NOT EXISTS PRODUCT " +
                    "(ID VARCHAR(255) not NULL, " +
                    " NAME VARCHAR(255) not NULL, " +
                    " PRICE INTEGER not NULL, " +
                    " PRIMARY KEY ( ID ))";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS ORDER_POSITION " +
                    " (ID INTEGER not NULL PRIMARY KEY AUTO_INCREMENT, " +
                    " NUM INTEGER not NULL, " +
                    " LOGIN VARCHAR(255) not NULL, " +
                    " PRODUCT_ID VARCHAR(255) not NULL REFERENCES PRODUCT(ID) " +
                    " )";
            statement.executeUpdate(sql);

            for (Product p : products) {
                sql = "INSERT INTO PRODUCT " + " VALUES( '" + p.id() + "', '" + p.name() + "',  " + p.price() + ")";
                statement.executeUpdate(sql);
            }

            int i = 0;
            for (OrderPosition op : orderPositions) {
                sql = "INSERT INTO ORDER_POSITION " + " VALUES( "
                        + i + ", "
                        + op.number() + " ,'"
                        + op.login() + "', '"
                        + op.product() + "' ) ";
                ++i;
                statement.executeUpdate(sql);
            }

            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
