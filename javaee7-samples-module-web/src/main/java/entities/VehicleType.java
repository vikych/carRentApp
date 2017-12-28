package entities;

public class VehicleType {

    private int vehicleTypePk;
    private String vehicleTypeName;

    public VehicleType(int vehicleTypePk, String vehicleTypeName) {
        this.vehicleTypePk = vehicleTypePk;
        this.vehicleTypeName = vehicleTypeName;
    }

    public int getVehicleTypePk() {
        return vehicleTypePk;
    }

    public void setVehicleTypePk(int vehicleTypePk) {
        this.vehicleTypePk = vehicleTypePk;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleType that = (VehicleType) o;

        if (vehicleTypePk != that.vehicleTypePk) return false;
        return vehicleTypeName != null ? vehicleTypeName.equals(that.vehicleTypeName) : that.vehicleTypeName == null;
    }

    @Override
    public int hashCode() {
        int result = vehicleTypePk;
        result = 31 * result + (vehicleTypeName != null ? vehicleTypeName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "vehicleTypePk=" + vehicleTypePk +
                ", vehicleTypeName='" + vehicleTypeName + '\'' +
                '}';
    }
}
