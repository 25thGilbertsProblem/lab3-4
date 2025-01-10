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
            handleAfternoon(obj, time);
        } else {
            handleMorning(time);
        }
    }

    // Метод, который будет вызывать фразы Кнопочки, если ещё рано ехать
    private void handleMorning(Time time) {
        System.out.print(getName() + ", проверила часы");
        speak("пока только " + time + ", ещё рано ехать.");
    }

    // Метод, который будет вызывать фразы Кнопочки, если время для отправки уже настало:
    private void handleAfternoon(FieldObject obj, Time time) {
        if (obj == null) {
            System.out.print(getName() + ", вообще не была заинтересована");
            speak("пора ехать дальше, уже " + time + "!");
        } else if (random.nextBoolean()) {
            System.out.print(getName() + ", которая не особенно интересовалась " + obj.getName());
            speak("пора ехать дальше. уже " + time + "!");
        } else {
            System.out.print(getName() + " тоже была заинтересована " + obj.getName());
            speak("надо осмотреться, но помни, что пора ехать, уже " + time + "!");
        }
    }
}
