package entity;

public class Role {

    private int rolePk;
    private String roleName;

    public Role(int rolePk, String roleName) {
        this.rolePk = rolePk;
        this.roleName = roleName;
    }

    public int getRolePk() {
        return rolePk;
    }

    public void setRolePk(int rolePk) {
        this.rolePk = rolePk;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (rolePk != role.rolePk) return false;
        return roleName != null ? roleName.equals(role.roleName) : role.roleName == null;
    }

    @Override
    public int hashCode() {
        int result = rolePk;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rolePk=" + rolePk +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
