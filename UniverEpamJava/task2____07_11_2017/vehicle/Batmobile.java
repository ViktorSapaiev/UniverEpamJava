package UniverEpamJava.task2____07_11_2017.vehicle;
import UniverEpamJava.task2____07_11_2017.until.Coordinate;
import UniverEpamJava.task2____07_11_2017.vehicle.motion.*;

public class Batmobile extends CCar implements MoveAble, FlyAble, SwimAble {
    private String owner = "Batman";

    public Batmobile(String model, int price, int maxSpeed, int yearModel, Coordinate coordinate, String owner) {
        super(model, price, maxSpeed, yearModel, coordinate);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void swim() {
        int x = super.getCoordinate().getX();
        int y = super.getCoordinate().getY();
        x++;
        super.setCoordinate(x, y, 0);

    }
    public void fly() {
        int x = super.getCoordinate().getX();
        int y = super.getCoordinate().getY();
        int z = super.getCoordinate().getZ();
        x++;
        z++;
        super.setCoordinate(x, y,z);

    }
    @Override
    public String toString() {
        return "The Car " + super.getModel() + '\n'
                + "Owner: " + this.getOwner() + '\n'
                + "Price: " + super.getPrice() + '\n'
                + "Maximal speed: " + super.getMaxSpeed() + '\n'
                + "Year model: " + super.getYearModel() + '\n'
                + "Coordinate: " + "\n\t"
                + "X "+ super.getCoordinate().getX() + "\n\t"
                + "Y " + super.getCoordinate().getY()+ "\n\t"
                + "Z " + super.getCoordinate().getZ() ;
    }
}
