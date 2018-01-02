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

    @PreDestroy
    public void onSessionDestruction(){
        INSTANCE_COUNT.decrementAndGet();
    }

}
