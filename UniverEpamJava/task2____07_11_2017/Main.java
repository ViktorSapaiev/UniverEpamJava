package UniverEpamJava.task2____07_11_2017;
import UniverEpamJava.task2____07_11_2017.vehicle.*;
import java.util.Calendar;
import static UniverEpamJava.task2____07_11_2017.until.FactoryVehicle.factoryVechicle;
/*
    - Создать абстарктый класс CVehicle. +
    - На его осове реализовать классы CPlane, CCar, CShip. +
    - Классы должны иметь возможность задавать и получать координаты,+
    - параметры средств передвижения (цена, скорость, год выпуска). +
    - Для самолета  должна быть определена высота, для корабля и самолет - количество пассажиров. +
    - Для коробля - порт припискию +
    - Написать программу создающую список объектов этих классов в динамической памяти +
    - Программа должна содержать меню позволяющие осуществить проверку всех методов +
    - Механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет +
    - Найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000 +
    - Найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane +
    - Добавить к данной иерархии машину-амфибию, и БетМобиль, создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble +\-

 */
public class Main {
    public static void main(String[] args) {
        CVehicle[] vehicles = new CVehicle[30];
        autoFill(vehicles);// Автонаполнение массива объектами
        //printArray(vehicles);// Напечатать все объекты массива
        //filter(vehicles); // механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет
        //filterPlane(vehicles, 5000,2000); // найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000
        filterMaxSpeed(vehicles,200,500); //найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane

    }

    public static void autoFill(CVehicle[] vehicle){
        for (int i = 0; i < vehicle.length; i++) {
            vehicle[i] = factoryVechicle();
        }
    }

    public static void printArray(CVehicle[] vehicle) {
        for (int i = 0; i < vehicle.length; i++) {
            System.out.print(vehicle[i]);
            System.out.println("\n");
        }
    }
    /** Находит механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет
     * @param vehicles массив механизмов*/
   public static void filter(CVehicle[] vehicles) {
        CVehicle minPrice = vehicles[0];
        CVehicle maxSpeed = vehicles[0];
        Calendar calendar = Calendar.getInstance();
        int year = calendar.getWeekYear();

        for (int i = 0; i < vehicles.length; i++) {
            if(minPrice.getPrice() > vehicles[i].getPrice() && (year - vehicles[i].getYearModel()) <= 5 ) {
                minPrice = vehicles[i];
            }
            if(maxSpeed.getMaxSpeed() < vehicles[i].getPrice() && (year - vehicles[i].getYearModel()) <= 5 ) {
                maxSpeed = vehicles[i];
            }
        }
       System.out.print("Результат поиска: " + '\n');
       System.out.println(minPrice);
       System.out.print('\n');
       System.out.println(maxSpeed);
   }

      /** Находит из механизмов, механизмы CPlane c с высотой полета выше minFlightAltitude с годом выпуска после minYearModel
       * @param vehicles массив механизмов
       * @param minFlightAltitude минимальная высота полета
       * @param minYearModel минимальный год выпуска*/
   public static void filterPlane(CVehicle[] vehicles, int minFlightAltitude, int minYearModel) {
       System.out.println("Результат поиска: ");
       for(int i = 0; i < vehicles.length;i++) {
           if (CPlane.class.equals(vehicles[i].getClass())) {
               CPlane plane = (CPlane)vehicles[i];
               if (plane.getFlightAltitude() > minFlightAltitude && plane.getYearModel() > minYearModel) {
                   System.out.println(plane);
                   System.out.println('\n');
               }
           }
       }
   }
    /** Находит из механизмов(кроме CPlane) c диапазоном скорости от minSpeed до maxSpeed
     * @param vehicles массив механизмов
     * @param minSpeed минимальная скорость
     * @param maxSpeed минимальный скорость*/
   public  static void filterMaxSpeed(CVehicle[] vehicles, int minSpeed,int maxSpeed) {
       System.out.println("Результат поиска: ");
       for(int i = 0; i < vehicles.length;i++) {
           if(!(CPlane.class.equals(vehicles[i].getClass()))){
               if (isMaxSpeedInRange(vehicles[i],minSpeed, maxSpeed)) {
                   System.out.println(vehicles[i]);
                   System.out.println('\n');
               }
           }
       }
   }
    /** Метод проверяет входит ли скорость механизма, в заданный диапазон
     * @param vehicle механизм
     * @param minSpeed минимальная скорость
     * @param maxSpeed минимальный скорость*/
    private static boolean isMaxSpeedInRange(CVehicle vehicle, int minSpeed, int maxSpeed) {
            return vehicle.getMaxSpeed() >= minSpeed && vehicle.getMaxSpeed() <= maxSpeed;
    }


}
