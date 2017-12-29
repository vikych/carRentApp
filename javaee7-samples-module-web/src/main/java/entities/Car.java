package entities;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @Column(name="CAR_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carPk;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @OneToOne (targetEntity = Model.class, cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinColumn(name = "MODEL_FK")
    private Model model;

    @Column(name = "YEAR")
    private int year;

    @OneToOne (cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinColumn(name = "VEHICLETYPE_FK")
    private VehicleType vehicletype;

    @OneToOne (cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
    @JoinColumn(name = "TRANSMISSION_FK")
    private Transmission transmission;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "PHOTO")
    private Blob image;

    @Column(name = "AVAILABLE")
    private boolean available;

    public Car() {
    }

    public Car(String registrationNumber, Model model, int year, VehicleType vehicletype, Transmission transmission,
               String color, int price, Blob image, boolean available) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.year = year;
        this.vehicletype = vehicletype;
        this.transmission = transmission;
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public VehicleType getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(VehicleType vehicletype) {
        this.vehicletype = vehicletype;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
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
        if (year != car.year) return false;
        if (price != car.price) return false;
        if (available != car.available) return false;
        if (registrationNumber != null ? !registrationNumber.equals(car.registrationNumber) : car.registrationNumber != null)
            return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (vehicletype != null ? !vehicletype.equals(car.vehicletype) : car.vehicletype != null) return false;
        if (transmission != null ? !transmission.equals(car.transmission) : car.transmission != null) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        return image != null ? image.equals(car.image) : car.image == null;
    }

    @Override
    public int hashCode() {
        int result = carPk;
        result = 31 * result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (vehicletype != null ? vehicletype.hashCode() : 0);
        result = 31 * result + (transmission != null ? transmission.hashCode() : 0);
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
                ", model=" + model +
                ", year=" + year +
                ", vehicletype=" + vehicletype +
                ", transmission=" + transmission +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", image=" + image +
                ", available=" + available +
                '}';
    }
}
