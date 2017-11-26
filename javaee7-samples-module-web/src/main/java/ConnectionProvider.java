import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private final static String URL = "jdbc:mysql://localhost:3306/databaseconnection";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "user1";
    private static Connection connection;

    public static Connection jdbcConnection() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Opened connection to " + URL);
            }

            connection.close();

            if (connection.isClosed()) {
                System.out.println("Connection closed to " + URL);
            }
        } catch (SQLException e) {
            System.err.println("Unable to download driver " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
