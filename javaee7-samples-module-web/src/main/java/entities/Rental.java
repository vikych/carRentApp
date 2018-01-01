package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RENTAL")
public class Rental {

    @Id
    @Column(name = "RENTAL_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalPk;

    @Column(name = "RENTAL_ID")
    private String rentalID;

    @OneToOne
    @JoinColumn(name = "CAR_FK")
    private Car carFk;

    @OneToOne
    @JoinColumn(name = "USER_FK")
    private User userFk;

    @Column(name = "PICKUP_TIME")
    private Date pickUpTime;

    @Column(name = "DROPOFF_TIME")
    private Date dropOffTime;

    @Column(name = "TOTAL_PRICE")
    private int totalPrice;

    @OneToOne
    @JoinColumn(name = "STATUS_FK")
    private RentalStatus statusFk;

    public Rental() {
    }

    public Rental(Car carFk, User userFk, Date pickUpTime, Date dropOffTime, int totalPrice, RentalStatus statusFk) {
        this.carFk = carFk;
        this.userFk = userFk;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
        this.totalPrice = totalPrice;
        this.statusFk = statusFk;
    }

    public int getRentalPk() {
        return rentalPk;
    }

    public void setRentalPk(int rentalPk) {
        this.rentalPk = rentalPk;
    }

    public String getRentalID() {
        return rentalID;
    }

    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public Date getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(Date dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Car getCarFk() {
        return carFk;
    }

    public void setCarFk(Car carFk) {
        this.carFk = carFk;
    }

    public User getUserFk() {
        return userFk;
    }

    public void setUserFk(User userFk) {
        this.userFk = userFk;
    }

    public RentalStatus getStatusFk() {
        return statusFk;
    }

    public void setStatusFk(RentalStatus statusFk) {
        this.statusFk = statusFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rental rental = (Rental) o;

        if (rentalPk != rental.rentalPk) return false;
        if (totalPrice != rental.totalPrice) return false;
        if (rentalID != null ? !rentalID.equals(rental.rentalID) : rental.rentalID != null) return false;
        if (carFk != null ? !carFk.equals(rental.carFk) : rental.carFk != null) return false;
        if (userFk != null ? !userFk.equals(rental.userFk) : rental.userFk != null) return false;
        if (pickUpTime != null ? !pickUpTime.equals(rental.pickUpTime) : rental.pickUpTime != null) return false;
        if (dropOffTime != null ? !dropOffTime.equals(rental.dropOffTime) : rental.dropOffTime != null) return false;
        return statusFk != null ? statusFk.equals(rental.statusFk) : rental.statusFk == null;
    }

    @Override
    public int hashCode() {
        int result = rentalPk;
        result = 31 * result + (rentalID != null ? rentalID.hashCode() : 0);
        result = 31 * result + (carFk != null ? carFk.hashCode() : 0);
        result = 31 * result + (userFk != null ? userFk.hashCode() : 0);
        result = 31 * result + (pickUpTime != null ? pickUpTime.hashCode() : 0);
        result = 31 * result + (dropOffTime != null ? dropOffTime.hashCode() : 0);
        result = 31 * result + totalPrice;
        result = 31 * result + (statusFk != null ? statusFk.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalPk=" + rentalPk +
                ", rentalID='" + rentalID + '\'' +
                ", carFk=" + carFk +
                ", userFk=" + userFk +
                ", pickUpTime=" + pickUpTime +
                ", dropOffTime=" + dropOffTime +
                ", totalPrice=" + totalPrice +
                ", statusFk=" + statusFk +
                '}';
    }
}
