package services;

import dbconnection.ConnectionProvider;
import entities.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManufacturerService {

    public Manufacturer getManufacturerByPk(int manufacturerPk) throws SQLException {
        Connection connection = ConnectionProvider.jdbcConnection();
        PreparedStatement ps = null;

        String sql = "SELECT MANUFACTURER_PK, MANUFACTURER_NAME FROM MANUFACTURER WHERE MANUFACTURER_PK=?";

        Manufacturer manufacturer = new Manufacturer();
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, manufacturerPk);
            ResultSet resultSet = ps.executeQuery();

            manufacturer.setManufacturerPk(resultSet.getInt("MANUFACTURER_PK"));
            manufacturer.setManufacturerName(resultSet.getString("MANUFACTURER_NAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return manufacturer;
    }
}
