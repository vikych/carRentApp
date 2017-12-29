package services;

import dbconnection.ConnectionProvider;
import entities.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelService {

    private Connection connection = ConnectionProvider.jdbcConnection();

    public Model getModelByPk(int modelPk) throws SQLException {
        PreparedStatement ps = null;
        String table = "MODEL";

        String sql = "SELECT MODEL_PK, MODEL_NAME FROM ? WHERE MODEL_PK=?";

        Model model = new Model();
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, table);
            ps.setInt(2, modelPk);
            ResultSet resultSet = ps.executeQuery();

            model.setModelPk(resultSet.getInt("MODEL_PK"));
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
