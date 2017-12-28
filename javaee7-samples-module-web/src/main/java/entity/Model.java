package entity;

public class Model {

    private int modelPk;
    private int manufacturerFk;
    private String modelName;

    public Model(int modelPk, int manufacturerFk, String modelName) {
        this.modelPk = modelPk;
        this.manufacturerFk = manufacturerFk;
        this.modelName = modelName;
    }

    public int getModelPk() {
        return modelPk;
    }

    public void setModelPk(int modelPk) {
        this.modelPk = modelPk;
    }

    public int getManufacturerFk() {
        return manufacturerFk;
    }

    public void setManufacturerFk(int manufacturerFk) {
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
        result = 31 * result + manufacturerFk;
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
