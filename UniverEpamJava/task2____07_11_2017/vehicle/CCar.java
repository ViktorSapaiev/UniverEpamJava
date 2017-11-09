package UniverEpamJava.task2____07_11_2017.vehicle;
import UniverEpamJava.task2____07_11_2017.until.*;

public class CCar extends CVehicle implements MoveAble {
    public CCar(String model, int price, int maxSpeed, int yearModel, Coordinate coordinate) {
        super(model, price, maxSpeed, yearModel, coordinate);
    }

    public void move() {
        double x = super.getCoordinate().getX();
        double y = super.getCoordinate().getY();
        super.setCoordinate(x++, y--);

    }

    @Override
    public String toString() {
        return "The Car " + super.getModel() + '\n'
                + "Price: " + super.getPrice() + '\n'
                + "Maximal speed: " + super.getMaxSpeed() + '\n'
                + "Year model: " + super.getYearModel() + '\n'
                + "Coordinate: " + "\n\t"
                + "X "+ super.getCoordinate().getX() + "\n\t"
                + "Y " + super.getCoordinate().getY();
    }
}
