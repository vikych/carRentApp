package entities;

import java.util.Date;

public class Rental {

    private int rentalPk;
    private String rentalID;
    private int carFk;
    private int userFk;
    private Date pickUpTime;
    private Date dropOffTime;
    private int totalPrice;
    private int statusFk;

    public Rental(int rentalPk, String rentalID, int carFk, int userFk, Date pickUpTime, Date dropOffTime, int totalPrice, int statusFk) {
        this.rentalPk = rentalPk;
        this.rentalID = rentalID;
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

    public int getCarFk() {
        return carFk;
    }

    public void setCarFk(int carFk) {
        this.carFk = carFk;
    }

    public int getUserFk() {
        return userFk;
    }

    public void setUserFk(int userFk) {
        this.userFk = userFk;
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

    public int getStatusFk() {
        return statusFk;
    }

    public void setStatusFk(int statusFk) {
        this.statusFk = statusFk;
    }


}
