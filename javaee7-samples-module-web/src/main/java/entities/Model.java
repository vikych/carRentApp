package entities;

import javax.persistence.*;

@Entity
@Table(name = "CAR_MODEL")
public class Model {

    @Id
    @Column(name = "MODEL_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelPk;

    @OneToOne
    @JoinColumn(name = "MANUFACTURER_FK")
    private Manufacturer manufacturerFk;

    @Column(name = "MODEL_NAME")
    private String modelName;

    public Model() {
    }

    public Model(Manufacturer manufacturerFk, String modelName) {
        this.manufacturerFk = manufacturerFk;
        this.modelName = modelName;
    }

    public int getModelPk() {
        return modelPk;
    }

    public void setModelPk(int modelPk) {
        this.modelPk = modelPk;
    }

    public Manufacturer getManufacturerFk() {
        return manufacturerFk;
    }

    public void setManufacturerFk(Manufacturer manufacturerFk) {
        this.manufacturerFk = manufacturerFk;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (modelPk != model.modelPk) return false;
        if (manufacturerFk != model.manufacturerFk) return false;
        return modelName != null ? modelName.equals(model.modelName) : model.modelName == null;
    }

    @Override
    public int hashCode() {
        int result = modelPk;
        result = 31 * result + (manufacturerFk != null ? manufacturerFk.hashCode() : 0);
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelPk=" + modelPk +
                ", manufacturerFk=" + manufacturerFk +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
