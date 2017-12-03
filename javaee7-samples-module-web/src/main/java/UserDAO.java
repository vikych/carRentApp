import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public boolean add(User user) {

        Connection connection = ConnectionProvider.jdbcConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user_info(userID, FirstName, LastName, "
                    + "Username, Password) VALUES (3,?,?,?,?)");

            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());

            if(ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
}
