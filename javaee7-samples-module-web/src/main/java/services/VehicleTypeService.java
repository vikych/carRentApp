package services;

import dbconnection.ConnectionProvider;
import entities.Model;
import entities.VehicleType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleTypeService {

    private Connection connection = ConnectionProvider.jdbcConnection();

    public VehicleType getVehicleTypeByPk(int vehicleTypePk) throws SQLException {
        PreparedStatement ps = null;
        String table = "VEHICLETYPE";

        String sql = "SELECT VEHICLETYPE_PK, VEHICLETYPE_NAME FROM ? WHERE VEHICLETYPE_PK=?";

        VehicleType vehicleType = new VehicleType();
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, table);
            ps.setInt(2, vehicleTypePk);
            ResultSet resultSet = ps.executeQuery();

            vehicleType.setVehicleTypePk(resultSet.getInt("VEHICLETYPE_PK"));
            vehicleType.setVehicleTypeName(resultSet.getString("VEHICLETYPE_NAME"));
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
        return vehicleType;
    }
}
