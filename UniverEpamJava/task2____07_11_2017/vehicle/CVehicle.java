package UniverEpamJava.task2____07_11_2017.vehicle;
import UniverEpamJava.task2____07_11_2017.until.*;

/**Интерфейс отвечающий за перемещение по земле*/
interface MoveAble {
  public void move();
}
/**Интерфейс отвечающий за перемещение по воздуху*/
interface FlyAble {
    public void fly();
}
/**Интерфейс отвечающий за перемещение по воде*/
interface SwimAble {
    public void swim();
}
/**Абстрактный класс содержащий основные параметры и методы для транспортых средств*/
public abstract class CVehicle {
    /*** Свойство - модель*/
    private String model;
    /**Свойство - цена*/
    private int price;
    /**Свойство - максимальная скорость передвижения*/
    private int maxSpeed;
    /**Свойство - год выпуска*/
    private int yearModel;
    /**Свойство - Координаты */
    private Coordinate coordinate;
    /**Инициализирует поля (@link CVehicle#model), (@link CVehicle#price),(@link CVehicle#maxSpeed), (@link CVehicle#yearModel), (@link CVehicle#cooedinate) */
    CVehicle(String model, int price, int maxSpeed, int yearModel, Coordinate coordinate) {
        this.model = model;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.yearModel = yearModel;
        this.coordinate = coordinate;
    }
    /** Метод возвращающий литерал цены*/
    public int getPrice() {
        return price;
    }
    /** Метод изменяющий литерал цены*/
    public void setPrice(int price) {
        this.price = price;
    }
    /** Метод возвращающий литерал максимальной скорости*/
    public int getMaxSpeed() {
        return maxSpeed;
    }
    /** Метод изменяющий литерал максимальной скорости*/
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    /** Метод возвращающий литерал года выпуска*/
    public int getYearModel() {
        return yearModel;
    }
    /** Метод изменяющий литерал года выпуска*/
    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }
    /** Метод возвращающий литерал модели*/
    public String getModel() {

        return model;
    }
    /** Метод изменяющий литерал модели*/
    public void setModel(String model) {
        this.model = model;
    }
    /** Метод возвращающий литерал модели(адресс)*/
    public Coordinate getCoordinate() {
        return this.coordinate;
    }
    /** Метод изменяющий литерал модели*/
    public void setCoordinate(double x, double y) {
        this.coordinate = new Coordinate(x,y);
    }

}
