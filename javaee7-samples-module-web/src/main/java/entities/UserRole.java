package entities;

public class UserRole {

    private int userRolePk;
    private int userFk;
    private int roleFk;

    public UserRole(int userRolePk, int userFk, int roleFk) {
        this.userRolePk = userRolePk;
        this.userFk = userFk;
        this.roleFk = roleFk;
    }

    public int getUserRolePk() {
        return userRolePk;
    }

    public void setUserRolePk(int userRolePk) {
        this.userRolePk = userRolePk;
    }

    public int getUserFk() {
        return userFk;
    }

    public void setUserFk(int userFk) {
        this.userFk = userFk;
    }

    public int getRoleFk() {
        return roleFk;
    }

    public void setRoleFk(int roleFk) {
        this.roleFk = roleFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (userRolePk != userRole.userRolePk) return false;
        if (userFk != userRole.userFk) return false;
        return roleFk == userRole.roleFk;
    }

    @Override
    public int hashCode() {
        int result = userRolePk;
        result = 31 * result + userFk;
        result = 31 * result + roleFk;
        return result;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRolePk=" + userRolePk +
                ", userFk=" + userFk +
                ", roleFk=" + roleFk +
                '}';
    }
}
