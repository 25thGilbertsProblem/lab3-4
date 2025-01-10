package characters;
import fieldobjects.FieldObject;
import others.Time;

import java.util.Random;

public class Knopochka extends Character{
    public Knopochka(String name){
        super(name);
    }
    private final Random random = new Random();

    @Override
    public void speak(String message){
        System.out.print(", сказала, что " + message);
    }

    public void suggestMoving(FieldObject obj, Time time) {

        if (time.isAfter(12)) {
            if (obj == null) {
                System.out.print(getName() + ", вообще не была заинтересована");
                speak("пора ехать дальше, уже " + time + "!");
            }
            else {
                if (random.nextBoolean()) {
                    System.out.print(getName() + ", которая не особенно интересовалась " + obj.getName());
                    speak("пора ехать дальше. уже " + time + "!");
                }
                else {
                    System.out.print(getName() + " тоже была заинтересована " + obj.getName());
                    speak("надо осмотреться, но помни, что пора ехать, уже " + time + "!");
                }
            }
        }

        else {
            System.out.print(getName() + ", проверила часы");
            speak("пока только " + time + ", ещё рано ехать.");
        }

    }

}
