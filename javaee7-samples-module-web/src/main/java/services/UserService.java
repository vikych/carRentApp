package services;

import com.google.gson.JsonObject;
import dao.UserDAO;
import dbconnection.ConnectionProvider;
import entities.User;

import java.sql.*;

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

    public JsonObject getRentedCarByUsername(String user) {
        Connection connection = ConnectionProvider.jdbcConnection();
        try {
            CallableStatement statement = connection.prepareCall("{call getRentedCarListForCurrentUser(?)}");

            statement.setString(1, user);

            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            JsonObject rentedCar = new JsonObject();
            while (resultSet.next()) {
                rentedCar.addProperty("Username",resultSet.getString("USER_NAME"));
                rentedCar.addProperty("Photo",resultSet.getString("PHOTO"));
                rentedCar.addProperty("Manufacturer",resultSet.getString("MANUFACTURER_NAME"));
                rentedCar.addProperty("Model",resultSet.getString("MODEL_NAME"));
                rentedCar.addProperty("RegistrationNumber",resultSet.getString("REGISTRATION_NUMBER"));
                rentedCar.addProperty("Year",resultSet.getString("YEAR"));
                rentedCar.addProperty("Price",resultSet.getDouble("PRICE"));
                rentedCar.addProperty("DateFrom", String.valueOf(resultSet.getDate("DateFrom")));
                rentedCar.addProperty("DateTo", String.valueOf(resultSet.getDate("DateTo")));
                rentedCar.addProperty("PlaceWherePickCar",resultSet.getString("PlaceWherePickCar"));
            }

            statement.close();
            return rentedCar;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            ConnectionProvider.closeConnection(connection);
        }
        return null;
    }
}
