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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carRentPU");
        EntityManager em = emf.createEntityManager();
        CarServiceTest service = new CarServiceTest(em);

        em.getTransaction().begin();

        Manufacturer manufacturer = new Manufacturer("audi");
        Model model = new Model(manufacturer, "name");
        VehicleType vehicleType = new VehicleType("name");
        Transmission transmission = new Transmission( "name");

        Car car = new Car("lv-0003", model, 1999,
                vehicleType, transmission, "red", 200, null, true);

        em.persist(manufacturer);
        em.persist(model);
        em.persist(vehicleType);
        em.persist(transmission);
        em.persist(car);

        em.getTransaction().commit();

        System.out.println("Persisted " + car);

        try {
            if (util != null) {
                util.checkData("select * from Car");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        em.close();
        emf.close();
    }
}
