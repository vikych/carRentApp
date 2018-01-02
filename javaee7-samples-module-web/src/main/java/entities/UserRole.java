package entities;

import javax.persistence.*;

@Entity
@Table(name = "USER_INFO_ROLE")
public class UserRole {

    @Id
    @Column(name = "USER_INFO_ROLE_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRolePk;

    @OneToOne
    @JoinColumn(name = "USER_INFO_FK")
    private User userFk;

    @OneToOne
    @JoinColumn(name = "ROLE_FK")
    private Role roleFk;

    public UserRole(int userRolePk, User userFk, Role roleFk) {
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

    public User getUserFk() {
        return userFk;
    }

    public void setUserFk(User userFk) {
        this.userFk = userFk;
    }

    public Role getRoleFk() {
        return roleFk;
    }

    public void setRoleFk(Role roleFk) {
        this.roleFk = roleFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (userRolePk != userRole.userRolePk) return false;
        if (userFk != null ? !userFk.equals(userRole.userFk) : userRole.userFk != null) return false;
        return roleFk != null ? roleFk.equals(userRole.roleFk) : userRole.roleFk == null;
    }

    @Override
    public int hashCode() {
        int result = userRolePk;
        result = 31 * result + (userFk != null ? userFk.hashCode() : 0);
        result = 31 * result + (roleFk != null ? roleFk.hashCode() : 0);
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
