package entities;

public class Manufacturer {
    
    private int manufacturerPk;
    private String manufacturerName;

    public Manufacturer(int manufacturerPk, String manufacturerName) {
        this.manufacturerPk = manufacturerPk;
        this.manufacturerName = manufacturerName;
    }

    public int getManufacturerPk() {
        return manufacturerPk;
    }

    public void setManufacturerPk(int manufacturerPk) {
        this.manufacturerPk = manufacturerPk;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (manufacturerPk != that.manufacturerPk) return false;
        return manufacturerName != null ? manufacturerName.equals(that.manufacturerName) : that.manufacturerName == null;
    }

    @Override
    public int hashCode() {
        int result = manufacturerPk;
        result = 31 * result + (manufacturerName != null ? manufacturerName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerPk=" + manufacturerPk +
                ", manufacturerName='" + manufacturerName + '\'' +
                '}';
    }
}
