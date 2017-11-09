package UniverEpamJava.task2____07_11_2017.until;
import UniverEpamJava.task2____07_11_2017.vehicle.*;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**Абстрактнй класс генерации случайных объектов*/
public abstract class FactoryVehicle {
    /** Возвращает случайный механизм*/
    public static CVehicle factoryVechicle() {
        return createVechicle(random(0,5));
    }
    /** Создает механиз по заданному ключу
     * 1 - Машина
     * 2 - Самолет
     * 3 - Корабль
     * 4 - Бэтмобиль
     * 5 - Машина-амфибия
     * @param key рандомное число в диапазоне от 0 до 5(не включительно)
     */
    private static CVehicle createVechicle(int key) {
        String[] modelsCars = {"Buggati", "Lamborghini", "Mazda", "Honda", "Ferrari", "Mercedes", "Audi"};
        String[] modelsShips = {"Hyundai", "Tsuneishi", "New Century", "Sinopacific", "CSIC", "Daewoo", "Aker Kvaerner"};
        String[] ports = {"Said ", "Shanghai", "Hamburg", "Los Angeles", "Vancouver", "Melbourne", "Valencia"};
        String[] modelsPlanes = {"Rolls-Royce", "Thales", "BAE Systems", "Safran", "Northrop Grumman", "Raytheon", "Airbus Group"};
        switch (key) {
            case 0: return new CCar(modelsCars[random(0,6)], random(500,700000), random(70,450), random(2000,18),new Coordinate(random(40.0d),random(40.0d)));
            case 1: return new CPlane(modelsPlanes[random(0,6)], random(3000,3000000), random(200,800),random(2000,18),new Coordinate(random(40.0d),random(40.0d)),random(4000,9000),random(100,800));
            case 2: return new CShip(modelsShips[random(0,6)], random(2000,700000), random(40,300),random(2000,18),new Coordinate(random(40.0d),random(40.0d)),ports[random(0,6)],random(500,3000));
            case 3: return new Batmobile("Batmobile", 200000000, random(200,700), 2000, new Coordinate(random(40.0d),random(40.0d)));
            case 4: return new Batmobile("AmphibiousCar", 10000000, random(200,300), 2000, new Coordinate(random(40.0d),random(40.0d)));
            default: return null;
        }
    }
    /** Генерирует псевдорандомное число, типа int
     * @param min минимальное значение
     * @param max максимальное значение (не включительно)
     */
    public static int random(int min, int max) {
        return min + (int) (Math.random() * max);
    }

    /** Генерирует псевдорандомное число, типа double
     * @param max максимальное значение (не включительно)
     */
    public static double random(double max) {
        double d = (double) Math.random() * max;
        d = new BigDecimal(d).setScale(2, RoundingMode.UP).doubleValue();
        return d;
    }
}
