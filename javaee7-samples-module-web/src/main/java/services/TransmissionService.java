package services;

import dbconnection.ConnectionProvider;
import entities.Transmission;
import entities.VehicleType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransmissionService {


    public Transmission getTransmissionByPk(int transmissionPk) throws SQLException {
        Connection connection = ConnectionProvider.jdbcConnection();
        PreparedStatement ps = null;
        String table = "TRANSMISSION";

        String sql = "SELECT TRANSMISSION_PK, TRANSMISSION_NAME FROM ? WHERE TRANSMISSION_PK=?";

        Transmission transmission = new Transmission();
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, table);
            ps.setInt(2, transmissionPk);
            ResultSet resultSet = ps.executeQuery();

            transmission.setTransmissionPk(resultSet.getInt("TRANSMISSION_PK"));
            transmission.setTransmissionName(resultSet.getString("TRANSMISSION_NAME"));
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
        return transmission;
    }
}
