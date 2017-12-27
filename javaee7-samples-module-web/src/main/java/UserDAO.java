import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public boolean add(User user) {

        Connection connection = ConnectionProvider.jdbcConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user_info(FIRST_NAME, LAST_NAME, "
                    + "USER_NAME, PASSWORD) VALUES (?,?,?,?)");

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        ConnectionProvider.closeConnection(connection);
        return false;
    }
}
