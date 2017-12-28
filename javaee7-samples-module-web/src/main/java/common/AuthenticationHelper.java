package common;

import dbconnection.ConnectionProvider;

import java.sql.*;

public class AuthenticationHelper {

    public static final String SELECT_USERNAME_PASSWORD_FROM_USER_INFO = "SELECT USER_NAME, PASSWORD from user_info";

    public static boolean isAllowed(String username, String password) {
        Connection connection = ConnectionProvider.jdbcConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERNAME_PASSWORD_FROM_USER_INFO);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                String usernameFromDB = res.getString(1);
                String passwordFromDB = res.getString(2);
                if (username.contentEquals(usernameFromDB) && password.contentEquals(passwordFromDB)) {
                    ConnectionProvider.closeConnection(connection);
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        ConnectionProvider.closeConnection(connection);
        return false;
    }
}
