import java.sql.*;

public class AuthHelper {

    public static final String SELECT_USERNAME_PASSWORD_FROM_USER_INFO = "SELECT Username, Password from user_info " +
            "WHERE Username=? and Password=?";

    public static boolean isAllowed(String username, String password) {
        Connection connection = ConnectionProvider.jdbcConnection();
        boolean isAllowed = false;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERNAME_PASSWORD_FROM_USER_INFO);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                String usernameFromDB = res.getString(1);
                String passwordFromDB = res.getString(2);
                isAllowed = username.contentEquals(usernameFromDB) && password.contentEquals(passwordFromDB);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        ConnectionProvider.closeConnection(connection);
        return isAllowed;
    }
}
