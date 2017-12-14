package thread1;

import java.util.ArrayList;
import java.util.List;

/*
Неправильные пчелы, подсчитав в конце месяца убытки от наличия в лесу Винни-Пуха,
решили разыскать его и наказать в назидание всем другим любителям сладкого.
Для поисков медведя они поделили лес на участки, каждый из которых прочесывает одна стая неправильных пчел.
В случае нахождения медведя на своем участке стая проводит показательное наказание и возвращается в улей.
Если участок прочесан, а Винни-Пух на нем не обнаружен, стая также возвращается в улей.
Требуется создать многопоточное приложение, моделирующее действия пчел.
При решении использовать парадигму портфеля задач.
*/
public class Main {
    private static Forest forest;
    private static List<Coordinate> task;

    public static void main(String[] args) {
        forest = new Forest(new String[5000][200]);
        forest.putBear();
        createTask();
        searchBear();
    }

    private static void searchBear() {
        int begin = 0;
        int end = 5;
        while (!forest.isBear()) {
            Thread com1 = commandCreator();
            Thread com2 = commandCreator();
            Thread com3 = commandCreator();
            com1.setName("Альфа бжжжж");
            com2.setName("Бетта бж-бж");
            com3.setName("Дельта вжу-вжжу");
            com1.start();
            com2.start();
            com3.start();
            try {
                com3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Thread commandCreator() {
        Thread bees = new Thread(new Bees(forest, task.get(0)));
        task.remove(0);
        return bees;
    }

    private static void createTask() {
        task = new ArrayList<>();
        int size = forest.getForest().length;
        for (int i = 0; i < size; i += 6) {
            if ((i + 6) < size) {
                task.add(new Coordinate(i, i + 5));
            } else {
                int end = (i + 6) - ((i + 6) - size);
                task.add(new Coordinate(i, end));
            }
        }
    }

}
