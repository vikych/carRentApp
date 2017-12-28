package dao;

import entities.User;

public interface UserDAO {

    boolean addUser(User user);

    User getUser();
}
