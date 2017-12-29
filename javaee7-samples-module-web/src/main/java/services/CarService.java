package services;

import dao.CarDAO;
import dbconnection.ConnectionProvider;
import entities.Car;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarService implements CarDAO {

    private Connection connection = ConnectionProvider.jdbcConnection();

    @Inject
    private ModelService modelService;
    @Inject
    private VehicleTypeService vehicleTypeService;
    @Inject
    private TransmissionService transmissionService;

    @Override
    public boolean addCar(Car car) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car(REGISTRATION_NUMBER, MODEL_FK, YEAR, "
                    + "VEHICLETYPE_FK, TRANSMISSION_FK, COLOR, PRICE, PHOTO, AVAILABLE) VALUES (?,?,?,?,?,?,?,?)");

            ps.setString(1, car.getRegistrationNumber());
            ps.setInt(2, car.getYear());
            ps.setInt(3, car.getModel().getModelPk());
            ps.setInt(4, car.getVehicletype().getVehicleTypePk());
            ps.setInt(5, car.getTransmission().getTransmissionPk());
            ps.setString(6, car.getColor());
            ps.setInt(7, car.getPrice());
            ps.setBlob(8, car.getImage());
            ps.setBoolean(9, car.isAvailable());

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
    public List<Car> getCars() throws SQLException {
        List<Car> cars = new ArrayList<>();

        String sql = "SELECT CAR_PK, REGISTRATION_NUMBER, MODEL_FK, YEAR, VEHICLETYPE_FK, TRANSMISSION_FK, COLOR, "
                + "PRICE, PHOTO, AVAILABLE FROM CAR";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Car car = new Car();
                car.setCarPk(resultSet.getInt("CAR_PK"));
                car.setRegistrationNumber(resultSet.getString("REGISTRATION_NUMBER"));
                car.setModel(modelService.getModelByPk(resultSet.getInt("MODEL_FK")));
                car.setYear(resultSet.getInt("YEAR"));
                car.setVehicletype(vehicleTypeService.getVehicleTypeByPk(resultSet.getInt("VEHICLETYPE_FK")));
                car.setTransmission(transmissionService.getTransmissionByPk(resultSet.getInt("TRANSMISSION_FK")));
                car.setColor(resultSet.getString("COLOR"));
                car.setPrice(resultSet.getInt("PRICE"));
                car.setImage(resultSet.getBlob("PHOTO"));
                car.setAvailable(resultSet.getBoolean("AVAILABLE"));

                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return cars;
    }

    @Override
    public Car getCarByPk(int carPk) throws SQLException {
        PreparedStatement ps = null;

        String sql = "SELECT CAR_PK, REGISTRATION_NUMBER, MODEL_FK, YEAR, VEHICLETYPE_FK, TRANSMISSION_FK, COLOR, " +
                "PRICE, PHOTO, AVAILABLE FROM CAR WHERE CAR_PK=?";

        Car car = new Car();
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, carPk);
            ResultSet resultSet = ps.executeQuery();

            car.setCarPk(resultSet.getInt("CAR_PK"));
            car.setRegistrationNumber(resultSet.getString("REGISTRATION_NUMBER"));
            car.setModel(modelService.getModelByPk(resultSet.getInt("MODEL_FK")));
            car.setYear(resultSet.getInt("YEAR"));
            car.setVehicletype(vehicleTypeService.getVehicleTypeByPk(resultSet.getInt("VEHICLETYPE_FK")));
            car.setTransmission(transmissionService.getTransmissionByPk(resultSet.getInt("TRANSMISSION_FK")));
            car.setColor(resultSet.getString("COLOR"));
            car.setPrice(resultSet.getInt("PRICE"));
            car.setImage(resultSet.getBlob("PHOTO"));
            car.setAvailable(resultSet.getBoolean("AVAILABLE"));

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
        return car;
    }

    @Override
    public void updateCar(Car car) throws SQLException {
        PreparedStatement ps = null;

        String sql = "UPDATE CAR SET REGISTRATION_NUMBER=?, MODEL_FK=?, YEAR=?, VEHICLETYPE_FK=?, TRANSMISSION_FK=?, " +
                "COLOR=?, PRICE=?, PHOTO=?, AVAILABLE=? WHERE CAR_PK=?";

        try {
            ps = connection.prepareStatement(sql);

            ps.setString(1, car.getRegistrationNumber());
            ps.setInt(2, car.getModel().getModelPk());
            ps.setInt(3, car.getYear());
            ps.setInt(4, car.getVehicletype().getVehicleTypePk());
            ps.setInt(5, car.getTransmission().getTransmissionPk());
            ps.setString(6, car.getColor());
            ps.setInt(7, car.getPrice());
            ps.setBlob(8, car.getImage());
            ps.setBoolean(9, car.isAvailable());
            ps.setInt(10, car.getCarPk());

            ps.executeUpdate();
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
    }

    @Override
    public void removeCar(Car car) throws SQLException {
        PreparedStatement ps = null;

        String sql = "DELETE FROM CAR WHERE CAR_PK=?";

        try {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, car.getCarPk());

            ps.executeUpdate();
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
    }
}