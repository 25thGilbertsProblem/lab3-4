package characters;

import interfaces.Speakable;
import others.Gender;

import java.util.Objects;

public abstract class Character implements Speakable {
    private String name;
    private Gender gender;
    private int age;
    private int height;
    private int weight;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Gender gender, int age, int height, int weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public abstract void speak(String message);

//    // Переопределил методы:

    @Override
    public String toString() {
        return "Персонаж с" +
                "именем'" + name + '\'' +
                ", полом " + gender +
                ", возрастом " + age +
                ", ростом " + height +
                ", весом " + weight +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Character character = (Character) obj;

        return age == character.age &&
                height == character.height &&
                weight == character.weight &&
                (Objects.equals(name, character.name)) &&
                gender == character.gender;
    }

    @Override
    public int hashCode() {
        int hash = 17; // Начальное значение
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        hash = 31 * hash + (gender != null ? gender.hashCode() : 0);
        hash = 31 * hash + age;
        hash = 31 * hash + height;
        hash = 31 * hash + weight;
        return hash;
    }
}
