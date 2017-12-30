package common;

import entities.*;
import services.CarServiceTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtilImpl {

    public void test() {
        JPAUtil util = null;
        try {
            util = new JPAUtil();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Manufacturer manufacturer8 = new Manufacturer("Chevrolet");
        Model model8 = new Model(manufacturer8, "Cruze");

        createCar("LV-0009", model8, 2006,
                new VehicleType("Pick up"), new Transmission( "Manual"), "Brown",
                25, "css/image/car9.jpg", true, manufacturer8);

        Manufacturer manufacturer9 = new Manufacturer("Citroen");
        Model model9 = new Model(manufacturer9, "J-90");

        createCar("LV-0010", model9, 2011,
                new VehicleType("Sedan"), new Transmission( "Manual"), "White",
                45, "css/image/car10.jpg", true, manufacturer9);

        Manufacturer manufacturer10 = new Manufacturer("FIAT");
        Model model10 = new Model(manufacturer10, "City");

        createCar("LV-0011", model10, 2013,
                new VehicleType("Duo"), new Transmission( "Manual"), "Blue",
                45, "css/image/car11.jpg", true, manufacturer10);

        Manufacturer manufacturer11 = new Manufacturer("Toyota");
        Model model11 = new Model(manufacturer11, "Yaris");

        createCar("LV-0012", model11, 2015,
                new VehicleType("Duo"), new Transmission( "Manual"), "White",
                70, "css/image/car12.jpg", true, manufacturer11);

        Manufacturer manufacturer = new Manufacturer("Hyundai");
        Model model = new Model(manufacturer, "i20");

        createCar("LV-0001", model, 2015,
                new VehicleType("Green Driving"), new Transmission( "Automatic"), "Grey",
                25, "css/image/car1.jpg", true, manufacturer);

        Manufacturer manufacturer1 = new Manufacturer("Renault");
        Model model1 = new Model(manufacturer1, "Sandero");

        createCar("LV-0002", model1, 2015,
                new VehicleType("SUV"), new Transmission( "Manual"), "Brown",
                40, "css/image/car2.jpg", true, manufacturer1);

        Manufacturer manufacturer2 = new Manufacturer("Toyota");
        Model model2 = new Model(manufacturer2, "Auris");

        createCar("LV-0003", model2, 2016,
                new VehicleType("Green Driving"), new Transmission( "Automatic"), "Blue",
                35, "css/image/car3.jpg", true, manufacturer2);

        Manufacturer manufacturer3 = new Manufacturer("Mercedes");
        Model model3 = new Model(manufacturer3, "A800");

        createCar("LV-0004", model3, 2012,
                new VehicleType("Sedan"), new Transmission( "Automatic"), "Black",
                30, "css/image/car4.jpg", true, manufacturer3);

        Manufacturer manufacturer4 = new Manufacturer("BMW");
        Model model4 = new Model(manufacturer4, "M5");

        createCar("LV-0005", model4, 2016,
                new VehicleType("Sedan"), new Transmission( "Manual"), "Grey",
                76, "css/image/car5.jpg", true, manufacturer4);

        Manufacturer manufacturer5 = new Manufacturer("KIA");
        Model model5 = new Model(manufacturer5, "KIA New Era");

        createCar("LV-0006", model5, 2004,
                new VehicleType("Sedan"), new Transmission( "Manual"), "White",
                20, "css/image/car6.jpg", true, manufacturer5);

        Manufacturer manufacturer6 = new Manufacturer("Hyundai");
        Model model6 = new Model(manufacturer6, "i10");

        createCar("LV-0007", model6, 2014,
                new VehicleType("Sedan"), new Transmission( "Automatic"), "Grey",
                45, "css/image/car7.jpg", true, manufacturer6);


        Manufacturer manufacturer7 = new Manufacturer("Toyota");
        Model model7 = new Model(manufacturer7, "Auris");

        createCar("LV-0008", model7, 2015,
                new VehicleType("Green Driving"), new Transmission( "Automatic"), "Red",
                80, "css/image/car8.jpg", true, manufacturer7);


        try {
            if (util != null) {
                util.checkData("select * from Car");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void createCar(String registrationNumber, Model model, int year, VehicleType vehicleType, Transmission transmission,
                   String color, int price, String imgURL, boolean available, Manufacturer manufacturer) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carRentPU");
        EntityManager em = emf.createEntityManager();
        CarServiceTest service = new CarServiceTest(em);

        em.getTransaction().begin();

        Car car = new Car(registrationNumber, model, year,
                vehicleType, transmission, color, price, imgURL, available);


        em.persist(manufacturer);
        em.persist(model);
        em.persist(vehicleType);
        em.persist(transmission);
        em.persist(car);

        em.getTransaction().commit();

        System.out.println("Persisted " + car);

        em.close();
        emf.close();
    }
}
