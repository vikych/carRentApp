package services;

import dbconnection.ConnectionProvider;
import entities.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelService {

    private ManufacturerService manufacturerService = new ManufacturerService();

    public Model getModelByPk(int modelPk) throws SQLException {
        Connection connection = ConnectionProvider.jdbcConnection();
        PreparedStatement ps = null;

        String sql = "SELECT MODEL_PK, MANUFACTURER_FK, MODEL_NAME FROM CAR_MODEL WHERE MODEL_PK=?";

        Model model = new Model();
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, modelPk);
            ResultSet resultSet = ps.executeQuery(sql);

            model.setModelPk(resultSet.getInt("MODEL_PK"));
            model.setManufacturerFk(manufacturerService.getManufacturerByPk(resultSet.getInt("MANUFACTURER_FK")));
            model.setModelName(resultSet.getString("MODEL_NAME"));
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
        return model;
    }
}
