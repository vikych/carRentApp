package entities;

public class RentalStatus {

    private int rentalStatusPk;
    private String rentalStatusName;

    public RentalStatus(int rentalStatusPk, String rentalStatusName) {
        this.rentalStatusPk = rentalStatusPk;
        this.rentalStatusName = rentalStatusName;
    }

    public int getRentalStatusPk() {
        return rentalStatusPk;
    }

    public void setRentalStatusPk(int rentalStatusPk) {
        this.rentalStatusPk = rentalStatusPk;
    }

    public String getRentalStatusName() {
        return rentalStatusName;
    }

    public void setRentalStatusName(String rentalStatusName) {
        this.rentalStatusName = rentalStatusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentalStatus that = (RentalStatus) o;

        if (rentalStatusPk != that.rentalStatusPk) return false;
        return rentalStatusName != null ? rentalStatusName.equals(that.rentalStatusName) : that.rentalStatusName == null;
    }

    @Override
    public int hashCode() {
        int result = rentalStatusPk;
        result = 31 * result + (rentalStatusName != null ? rentalStatusName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RentalStatus{" +
                "rentalStatusPk=" + rentalStatusPk +
                ", rentalStatusName='" + rentalStatusName + '\'' +
                '}';
    }
}
