package fieldobjects;
import others.*;

import java.util.Objects;

public class Rope extends FieldObject {
    private int length;
    private final int maxLength;

    public Rope(String name, int maxLength) {
        super(name);
        this.length = 0;
        this.maxLength = maxLength;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void unwind(int amount) throws RopeOverextensionException {
        if (length + amount > maxLength) {
            throw new RopeOverextensionException(maxLength);
        }
        length += amount;
        System.out.println(getName() + " разматывается ещё на " + amount + " метров.");
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

        if (!super.equals(obj)) {
            return false;
        }

        Rope rope = (Rope) obj;
        return length == rope.length && maxLength == rope.maxLength;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + super.hashCode();
        hash = 31 * hash + length;
        hash = 31 * hash + maxLength;

        return hash;
    }
}