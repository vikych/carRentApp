package services;

import entities.Car;
import entities.Model;
import entities.Transmission;
import entities.VehicleType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Blob;
import java.util.Collection;

public class CarServiceTest {

    protected EntityManager em;

    public CarServiceTest(EntityManager em) {
        this.em = em;
    }

    public Car createCar(String registrationNumber, Model model, int year, VehicleType vehicletype, Transmission transmission,
                         String color, int price, Blob image, boolean available) {
        Car car = new Car();
//        car.setCarPk(carPk);
        car.setRegistrationNumber(registrationNumber);
        car.setModel(model);
        car.setYear(year);
        car.setVehicletype(vehicletype);
        car.setTransmission(transmission);
        car.setColor(color);
        car.setPrice(price);
        car.setImage(image);
        car.setAvailable(available);
        return car;
    }

    public void removeProfessor(int carPk) {
        Car car = findCar(carPk);
        if (car != null) {
            em.remove(car);
        }
    }

//    public Car raiseProfessorSalary(int id, long raise) {
//        Professor emp = em.find(Professor.class, id);
//        if (emp != null) {
//            emp.setSalary(emp.getSalary() + raise);
//        }
//        return emp;
//    }

    public Car findCar(int carPk) {
        return em.find(Car.class, carPk);
    }

    public Collection<Car> findAllCars() {
        Query query = em.createQuery("SELECT * FROM Car");
        return (Collection<Car>) query.getResultList();
    }
}
