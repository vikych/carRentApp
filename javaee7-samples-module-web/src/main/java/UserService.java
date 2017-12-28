import entity.User;

public class UserService {
    public boolean addUser(User user) {

        UserDAO dao = new UserDAO();

        // Validation Should go here....

        return dao.add(user);
    }
}
