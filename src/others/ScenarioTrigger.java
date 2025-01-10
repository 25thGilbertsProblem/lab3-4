package others;

import fieldobjects.*;
import characters.*;

import java.util.Random;

public class ScenarioTrigger {

    // Вызываем воспроизведение произвольного сценария:
    public void triggerScenario(Neznaika neznaika, Knopochka button,  Machine machine, Rope rope, FieldObject pole, Time currentTime ) {

        // Сам сценарий:
        System.out.println("Он уже хотел удивиться, но вовремя спохватился и замолчал.");
        button.suggestMoving(machine, currentTime); // Будем проверять, настало ли уже 13:00 или нет
        neznaika.investigate(pole);

        // Сделаем рандомизацию, чтобы в 20% случаев трос был не привязан, тогда будем получать unchecked MachineNotAttachedException
        Random randomTied = new Random();
        double randomValue = randomTied.nextDouble();
        if (randomValue < 0.8) {
            machine.attachObj(AttachedState.TIED, rope); // Трос привязан к машине.
        } else {
            machine.attachObj(AttachedState.UNTIED, rope); // Трос не привязан к машине.
        }

        try {
            Random randomRotationsCount = new Random();
            int iterations = randomRotationsCount.nextInt(4) + 3; // Зададим количество раскруток

            // Выполняем движение и разматывание троса несколько раз
            for (int i = 0; i < iterations; i++) {
                int radiusIncrease = machine.move(); // Машина увеличивает свой радиус вращения
                rope.unwind(radiusIncrease); // Передаем увеличение радиуса тросу
            }

        } catch (RopeOverextensionException e) {
            System.err.println("Дальше не получится раскрутиться, трос растянулся и порвался, " + e.getMessage());
            machine.stop();
        }

        if (machine.getMoveState() == MoveState.MOVING) {
            System.out.print("Постепенно замедляясь, ");
            machine.stop();
        }
    }
}
