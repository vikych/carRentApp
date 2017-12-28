package dao;

import entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO {

    boolean addCar(Car car);

    List<Car> getCars() throws SQLException;

    Car getCarByPk(int carPk) throws SQLException;

    void updateCar(Car car) throws SQLException;

    void removeCar(Car car) throws SQLException;
}
