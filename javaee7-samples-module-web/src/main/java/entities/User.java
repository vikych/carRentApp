package entities;

import java.util.Date;

public class User {

    private String username;
    private String password;
    private String email;
    private String lastName;
    private String firstName;
    private String personID;
    private String Phone;
    private boolean blocked;
    private int loginAttempts;
    private Date dateOfBirth;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (blocked != user.blocked) return false;
        if (loginAttempts != user.loginAttempts) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (personID != null ? !personID.equals(user.personID) : user.personID != null) return false;
        if (Phone != null ? !Phone.equals(user.Phone) : user.Phone != null) return false;
        return dateOfBirth != null ? dateOfBirth.equals(user.dateOfBirth) : user.dateOfBirth == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (personID != null ? personID.hashCode() : 0);
        result = 31 * result + (Phone != null ? Phone.hashCode() : 0);
        result = 31 * result + (blocked ? 1 : 0);
        result = 31 * result + loginAttempts;
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", personID='" + personID + '\'' +
                ", Phone='" + Phone + '\'' +
                ", blocked=" + blocked +
                ", loginAttempts=" + loginAttempts +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
