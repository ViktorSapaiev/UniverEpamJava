package task2.until;
import task2.vehicle.*;


/**Абстрактнй класс генерации случайных объектов*/
public abstract class FactoryVehicle {
    /** Возвращает случайный механизм*/
    public static CVehicle factoryVechicle() {
        int[] rarity = {0,0,0,0,0,0,0,0,1,1,3,1,1,1,2,2,2,2,4,2,2,2,1,2,0,0,0,0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,2,2,1,2};// вероятность выпадения объекта;
        return createVechicle(rarity[random(0,rarity.length)]);
    }
    /** Создает механизм по заданному ключу
     * 1 - Машина
     * 2 - Самолет
     * 3 - Корабль
     * 4 - Бэтмобиль
     * 5 - Машина-амфибия
     * @param key рандомное число в диапазоне от 0 до 5(не включительно)
     */
    public static CVehicle createVechicle(int key) {
        String[] modelsCars = {"Buggati", "Lamborghini", "Mazda", "Honda", "Ferrari", "Mercedes", "Audi"};
        String[] modelsShips = {"Hyundai", "Tsuneishi", "New Century", "Sinopacific", "CSIC", "Daewoo", "Aker Kvaerner"};
        String[] ports = {"Said ", "Shanghai", "Hamburg", "Los Angeles", "Vancouver", "Melbourne", "Valencia"};
        String[] modelsPlanes = {"Rolls-Royce", "Thales", "BAE Systems", "Safran", "Northrop Grumman", "Raytheon", "Airbus Group"};
        switch (key) {
            case 0: return new CCar(
                    modelsCars[random(0,6)],
                    0,
                    random(70,450), random(2000,18),
                    new Coordinate(random(0,40),random(0,40),0)
            );
            case 1: return new CPlane(
                    modelsPlanes[random(0,6)],
                    0,
                    random(200,800),random(2000,18),
                    new Coordinate(random(0,40),random(0,40),random(0,40)),
                    random(4000,9000),
                    random(100,800)
            );
            case 2: return new CShip(
                    modelsShips[random(0,6)],
                    0,
                    random(40,300),
                    random(2000,18),
                    new Coordinate(random(0,40),random(0,40),0),
                    ports[random(0,6)],
                    random(500,3000)
            );
            case 3: return new Batmobile(
                    "Batmobile",
                    200000,
                    750,
                    2017,
                    new Coordinate(random(0,40),random(0,40),random(0,40)),
                    "Bruce Wayne "
            );

            case 4: return new AmphibiousCar(
                    "AmphibiousCar",
                    30000,
                    200,
                    1970,
                    new Coordinate(random(0,40),random(0,40),0)
            );
            default: return null;
        }
    }
    /** Генерирует псевдорандомное число, типа int
     * @param min минимальное значение
     * @param max максимальное значение (не включительно)
     */
    private static int random(int min, int max) {
        return min + (int) (Math.random() * max);
    }

}
