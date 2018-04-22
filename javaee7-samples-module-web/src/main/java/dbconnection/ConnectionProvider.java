package dbconnection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private final static String URL = "jdbc:mysql://localhost:3306/databaseconnection";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private static Connection connection;

    public static Connection jdbcConnection() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Connection to " + URL + " opened");
            }

        } catch (SQLException e) {
            System.err.println("Unable to download driver " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Connection to " + URL + " closed");
            }
        } catch (SQLException e) {
            System.err.println("Unable to download driver " + e.getMessage());
            e.printStackTrace();
        }
    }
}
