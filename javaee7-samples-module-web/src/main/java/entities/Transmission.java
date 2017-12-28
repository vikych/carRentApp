package entities;

public class Transmission {

    private int transmissionPk;
    private String transmissionName;

    public Transmission(int transmissionPk, String transmissionName) {
        this.transmissionPk = transmissionPk;
        this.transmissionName = transmissionName;
    }

    public int getTransmissionPk() {
        return transmissionPk;
    }

    public void setTransmissionPk(int transmissionPk) {
        this.transmissionPk = transmissionPk;
    }

    public String getTransmissionName() {
        return transmissionName;
    }

    public void setTransmissionName(String transmissionName) {
        this.transmissionName = transmissionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transmission that = (Transmission) o;

        if (transmissionPk != that.transmissionPk) return false;
        return transmissionName != null ? transmissionName.equals(that.transmissionName) : that.transmissionName == null;
    }

    @Override
    public int hashCode() {
        int result = transmissionPk;
        result = 31 * result + (transmissionName != null ? transmissionName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "transmissionPk=" + transmissionPk +
                ", transmissionName='" + transmissionName + '\'' +
                '}';
    }
}
