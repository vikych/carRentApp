package service;

import dao.UserDAO;
import dbconnection.ConnectionProvider;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService implements UserDAO {

    private Connection connection = ConnectionProvider.jdbcConnection();

    @Override
    public boolean addUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user_info(FIRST_NAME, LAST_NAME, "
                    + "USER_NAME, PASSWORD, EMAIL) VALUES (?,?,?,?,?)");

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());

            if (ps.executeUpdate() > 0) {
                ps.close();
                ConnectionProvider.closeConnection(connection);
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            ConnectionProvider.closeConnection(connection);
        }

        return false;
    }

    @Override
    public User getUser() {
        return null;
    }
}
