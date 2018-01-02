package services;

import dao.UserDAO;
import dbconnection.ConnectionProvider;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService implements UserDAO {

    @Override
    public boolean addUser(User user) {
        Connection connection = ConnectionProvider.jdbcConnection();
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
    public User getUserByUsername(String username) {
        Connection connection = ConnectionProvider.jdbcConnection();

        PreparedStatement ps = null;

        String sql = "SELECT * FROM USER_INFO WHERE USER_NAME = ?";

        User user = new User();
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                user.setUserPk(resultSet.getInt("USER_PK"));
                user.setUsername(resultSet.getString("USER_NAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setBlocked(resultSet.getBoolean("BLOCKED"));
                user.setLoginAttempts(resultSet.getInt("LOGIN_ATTEMPTS"));
                user.setFirstName(resultSet.getString("FIRST_NAME"));
                user.setLastName(resultSet.getString("LAST_NAME"));
                user.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"));
                user.setPersonID(resultSet.getString("PERSON_ID"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setPhone(resultSet.getString("PHONE"));
                user.setPhone(resultSet.getString("PHONE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
