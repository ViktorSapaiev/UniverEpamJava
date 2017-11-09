package UniverEpamJava.task2____07_11_2017.vehicle;

import UniverEpamJava.task2____07_11_2017.until.Coordinate;

public class AmphibiousCar extends CCar implements SwimAble {

    public AmphibiousCar(String model, int price, int maxSpeed, int yearModel, Coordinate coordinate) {
        super(model, price, maxSpeed, yearModel, coordinate);
    }

    public void swim() {
        double x = super.getCoordinate().getX();
        double y = super.getCoordinate().getY();
        super.setCoordinate(x++, y--);

    }
}
