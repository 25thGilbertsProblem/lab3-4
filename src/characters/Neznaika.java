package characters;

import java.util.Random;
import fieldobjects.FieldObject;

public class Neznaika extends Character {
    private final Random random = new Random();

    public Neznaika(String name){
        super(name);
    }

    @Override
    public void speak(String message) {
        System.out.println(getName() + " говорит: " + message);
    }

    public void investigate(FieldObject object) {
        if (random.nextBoolean()) {
            System.out.println("\nНо " + getName() +" во что бы то ни стало хотел дознаться, в чем тут дело.");
            System.out.println("Присмотревшись внимательней, " + getName() + " заметил, что посреди поля стоял " + object.getName() + ", вокруг которого был намотан металлический трос.");
        } else {
            System.out.println("\n" +getName() + " решил, что это неважно, и проигнорировал " + object.getName() + ", не став его разглядывать.");
        }
    }
}
