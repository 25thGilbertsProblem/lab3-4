package fieldobjects;
import java.util.Objects;
import java.util.Random;

import others.*;
import interfaces.*;

public class Machine extends FieldObject implements Movable {
    private MoveState moveState;
    private AttachedState attachedState;
    private int radius;
    private FieldObject attachedObject;

    public Machine(String name) {
        super(name);
        this.moveState = MoveState.STOPPED;
        this.attachedState = AttachedState.UNTIED;
        this.radius = 0;
        this.attachedObject = null;
    }

    public MoveState getMoveState() {
        return moveState;
    }

    public FieldObject getAttachedObject() {
        return attachedObject;
    }

    public AttachedState getAttachedState() {
        return attachedState;
    }

    public int getRadius() {
        return radius;
    }

    public void setMoveState(MoveState moveState) {
        this.moveState = moveState;
    }

    public void setAttachedState(AttachedState attachedState) {
        this.attachedState = attachedState;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setAttachedObject(FieldObject attachedObject) {
        this.attachedObject = attachedObject;
    }

    public void attachObj(AttachedState state, FieldObject obj) {
        this.attachedObject = obj;
        attachedState = state;
        if (attachedState == AttachedState.UNTIED){
            System.out.println("Конец этого " + attachedObject.getName() +" был развязан и не прикреплён к " + getName() + ". ");
        }

        else {
            System.out.println("Конец этого " + attachedObject.getName() +" был привязан сбоку к " + getName() + ". ");
        }

    }

    @Override
    public int move() {
        if (attachedState == AttachedState.UNTIED) {
            throw new MachineNotAttachedException();
        }
        int increase;
        if (moveState == MoveState.STOPPED) {
            // будем разматывать немного на старте (что логично, машина не может сразу быстро размотаться)
            increase = new Random().nextInt(2) + 1;;
            radius += increase;
            System.out.println(getName() + " начинает ходить по кругу, как на привязи, расширяя радиус до " + radius + " метров.");
            moveState = MoveState.MOVING;

        } else {
            increase = new Random().nextInt(5) + 1;
            radius += increase;
            System.out.println(getName() + " описывает круги, расширяя радиус до " + radius + " метров.");
        }
        return increase;
    }

    public void stop() {
        if (moveState == MoveState.MOVING) {
            System.out.println(getName() + " останавливается.");
            moveState = MoveState.STOPPED;
        }
    }

    // Переопределил методы:

    @Override
    public String toString() {
        return "Нынешние параметры машины" +
                "Состояние движения: " + moveState +
                ", К машине что-то прикреплено:" + attachedState +
                ", Радиус =" + radius +
                ", Прикрепленный предмет: " + attachedObject +
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


        if (!super.equals(obj)) {
            return false;
        }

        Machine machine = (Machine) obj;
        return radius == machine.radius
                && moveState == machine.moveState
                && attachedState == machine.attachedState
                && Objects.equals(attachedObject, machine.attachedObject);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + super.hashCode();
        hash = 31 * hash + (moveState != null ? moveState.hashCode() : 0);
        hash = 31 * hash + (attachedState != null ? attachedState.hashCode() : 0);
        hash = 31 * hash + radius; // Учитываем радиус
        hash = 31 * hash + (attachedObject != null ? attachedObject.hashCode() : 0);
        return hash;
    }
}