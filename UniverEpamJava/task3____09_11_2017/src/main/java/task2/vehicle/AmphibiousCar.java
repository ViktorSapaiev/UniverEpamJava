package UniverEpamJava.task2____07_11_2017.vehicle;
import UniverEpamJava.task2____07_11_2017.until.Coordinate;
import UniverEpamJava.task2____07_11_2017.vehicle.motion.*;

public class AmphibiousCar extends CCar implements SwimAble {

    public AmphibiousCar(String model,int price, int maxSpeed, int yearModel, Coordinate coordinate) {
        super(model, price,maxSpeed, yearModel, coordinate);
    }

    public void swim() {
        int x = super.getCoordinate().getX();
        int y = super.getCoordinate().getY();
        x++;
        super.setCoordinate(x, y,0);

    }
}
