package entities;

import javax.persistence.*;

@Entity
@Table(name = "TRANSMISSION")
public class Transmission {

    @Id
    @Column(name="TRANSMISSION_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transmissionPk;

    @Column(name = "TRANSMISSION_NAME")
    private String transmissionName;

    public Transmission() {
    }

    public Transmission(String transmissionName) {
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
