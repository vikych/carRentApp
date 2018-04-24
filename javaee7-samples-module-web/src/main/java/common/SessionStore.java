package common;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class SessionStore implements Serializable {

    private String username = "";
    private String manufacturer = "";
    private String model = "";
    private String year = "";
    private String color = "";


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
