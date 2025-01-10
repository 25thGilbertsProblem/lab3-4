import fieldobjects.*;
import characters.*;
import others.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Создание персонажей
        Neznaika neznaika = new Neznaika("Незнайка");
        Knopochka button = new Knopochka("Кнопочка");

        // Создание объектов сцены
        Machine machine = new Machine("Машина");
        Rope rope = new Rope("Трос", 15);
        FieldObject pole = new FieldObject("Столб") {};

        // Список с временем для случайного выбора
        List<Time> timeList = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            timeList.add(new Time(i, 0)); // Время с шагом 1 час
        }

        // Сгенерируем время в которое происходит событие
        // (это нужно чтобы Кнопочка смогла понять, пора или не пора им ещё ехать):
        Random random = new Random();
        Time randomTime = timeList.get(random.nextInt(timeList.size())); // Случайное время



        // Вызываем метод для запуска сценария
        ScenarioTrigger eventTrigger = new ScenarioTrigger();
        eventTrigger.triggerScenario(neznaika, button, machine, rope, pole, randomTime);
    }

}

