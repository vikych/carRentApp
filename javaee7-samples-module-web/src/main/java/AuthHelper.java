

public class AuthHelper {
    public static boolean isAllowed(String username, String password) {
        return username.contentEquals("user1") && password.contentEquals("123");
    }
}
