package entity;

import java.sql.Blob;

public class Car {

    private int carPk;
    private String registrationNumber;
    private int modelFk;
    private int year;
    private int vehicletypeFk;
    private int transmissionFk;
    private String color;
    private int price;
    private Blob image;
    private boolean available;

    public Car(int carPk, String registrationNumber, int modelFk, int year, int vehicletypeFk, int transmissionFk, String color, int price, Blob image, boolean available) {
        this.carPk = carPk;
        this.registrationNumber = registrationNumber;
        this.modelFk = modelFk;
        this.year = year;
        this.vehicletypeFk = vehicletypeFk;
        this.transmissionFk = transmissionFk;
        this.color = color;
        this.price = price;
        this.image = image;
        this.available = available;
    }

    public int getCarPk() {
        return carPk;
    }

    public void setCarPk(int carPk) {
        this.carPk = carPk;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getModelFk() {
        return modelFk;
    }

    public void setModelFk(int modelFk) {
        this.modelFk = modelFk;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVehicletypeFk() {
        return vehicletypeFk;
    }

    public void setVehicletypeFk(int vehicletypeFk) {
        this.vehicletypeFk = vehicletypeFk;
    }

    public int getTransmissionFk() {
        return transmissionFk;
    }

    public void setTransmissionFk(int transmissionFk) {
        this.transmissionFk = transmissionFk;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carPk != car.carPk) return false;
        if (modelFk != car.modelFk) return false;
        if (year != car.year) return false;
        if (vehicletypeFk != car.vehicletypeFk) return false;
        if (transmissionFk != car.transmissionFk) return false;
        if (price != car.price) return false;
        if (available != car.available) return false;
        if (registrationNumber != null ? !registrationNumber.equals(car.registrationNumber) : car.registrationNumber != null)
            return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        return image != null ? image.equals(car.image) : car.image == null;
    }

    @Override
    public int hashCode() {
        int result = carPk;
        result = 31 * result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
        result = 31 * result + modelFk;
        result = 31 * result + year;
        result = 31 * result + vehicletypeFk;
        result = 31 * result + transmissionFk;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (available ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carPk=" + carPk +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", modelFk=" + modelFk +
                ", year=" + year +
                ", vehicletypeFk=" + vehicletypeFk +
                ", transmissionFk=" + transmissionFk +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", image=" + image +
                ", available=" + available +
                '}';
    }
}
