package task2.vehicle;
import task2.until.*;
import task2.vehicle.motion.*;

public class CCar extends CVehicle implements MoveAble {
    public CCar(String model, int price, int maxSpeed, int yearModel, Coordinate coordinate) {
        super(model, price, maxSpeed, yearModel, coordinate);
    }

    public void move() {
        int x = super.getCoordinate().getX();
        int y = super.getCoordinate().getY();
        x++;
        super.setCoordinate(x, y,0);

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
