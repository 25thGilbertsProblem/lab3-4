package fieldobjects;

import characters.Character;

import java.util.Objects;

public abstract class FieldObject {
    private String name;

    public FieldObject(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Переопределил методы:

    @Override
    public String toString() {
        return "Предмет " + name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }

        FieldObject that = (FieldObject) obj;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        return hash;
    }
}
