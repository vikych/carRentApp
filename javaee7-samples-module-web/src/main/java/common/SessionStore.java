package common;

import entities.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@SessionScoped
public class SessionStore implements Serializable {

    public static AtomicLong INSTANCE_COUNT = new AtomicLong(0);

    private User user;
    private String manufacturer;
    private String model;
    private String year;
    private String color;

    @PostConstruct
    public void onNewSession(){
        INSTANCE_COUNT.incrementAndGet();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @PreDestroy
    public void onSessionDestruction(){
        INSTANCE_COUNT.decrementAndGet();
    }

}
