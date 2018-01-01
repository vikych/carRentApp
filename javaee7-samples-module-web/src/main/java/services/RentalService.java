package services;

import entities.Rental;

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

}
