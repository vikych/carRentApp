package entities;

import javax.persistence.*;

@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @Column(name="LOCATION_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationPk;
    private String locationName;

    public Location(int locationPk, String locationName) {
        this.locationPk = locationPk;
        this.locationName = locationName;
    }

    public int getLocationPk() {
        return locationPk;
    }

    public void setLocationPk(int locationPk) {
        this.locationPk = locationPk;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (locationPk != location.locationPk) return false;
        return locationName != null ? locationName.equals(location.locationName) : location.locationName == null;
    }

    @Override
    public int hashCode() {
        int result = locationPk;
        result = 31 * result + (locationName != null ? locationName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationPk=" + locationPk +
                ", locationName='" + locationName + '\'' +
                '}';
    }
}
