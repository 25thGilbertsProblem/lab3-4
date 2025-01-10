package characters;

import interfaces.Speakable;

import java.util.Objects;

public abstract class Character implements Speakable {
    private String name;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void speak(String message);

    // Переопределил методы:

    @Override
    public String toString() {
        return "Персонаж с именем" + name;
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

        Character character = (Character) obj;
        return Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        return hash;
    }
}
