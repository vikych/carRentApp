package dao;

import entity.User;

public interface UserDAO {

    boolean addUser(User user);

    User getUser();
}
