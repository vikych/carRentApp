package entities;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable //TODO @Cacheable
@Table(name = "Color")
public class Color {

    @Id
    @Column(name = "COLOR_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int colorPk;
    @Column(name = "COLOR_NAME")
    private String colorName;

    public Color(int colorPk, String colorName) {
        this.colorPk = colorPk;
        this.colorName = colorName;
    }

    public int getColorPk() {
        return colorPk;
    }

    public void setColorPk(int colorPk) {
        this.colorPk = colorPk;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (colorPk != color.colorPk) return false;
        return colorName != null ? colorName.equals(color.colorName) : color.colorName == null;
    }

    @Override
    public int hashCode() {
        int result = colorPk;
        result = 31 * result + (colorName != null ? colorName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Color{" +
                "colorPk=" + colorPk +
                ", colorName='" + colorName + '\'' +
                '}';
    }
}
