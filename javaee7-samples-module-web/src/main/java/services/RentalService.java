package services;

import entities.Rental;
import entities.RentalStatus;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RentalService {

    protected EntityManager em;

    public RentalService(EntityManager em) {
        this.em = em;
    }

    public List<Rental> findAllRentals() {
        Query query = em.createQuery("From Rental");
        return (List<Rental>) query.getResultList();
    }

    public void save(Rental rental) {
        em.getTransaction().begin();

        em.persist(rental);

        em.getTransaction().commit();

        System.out.println("Persisted " + rental);
    }

    public String createRentalID(Rental rental, int carPk, int userPk, int days) {
        return String.valueOf(carPk) + userPk + days + rental.getTotalPrice() + rental.getRentalPk();
    }

    public RentalStatus getRentalStatus(int statusPk) {
        return (RentalStatus) em.createQuery("From RentalStatus r where r.rentalStatusPk = :rentalStatusPk")
                .setParameter("rentalStatusPk", statusPk).getSingleResult();
    }

}
