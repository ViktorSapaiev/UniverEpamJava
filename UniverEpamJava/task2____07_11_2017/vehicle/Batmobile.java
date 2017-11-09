package UniverEpamJava.task2____07_11_2017.vehicle;

import UniverEpamJava.task2____07_11_2017.until.Coordinate;

public class Batmobile extends CCar implements FlyAble, SwimAble {
    private String owner = "Batman";

    public Batmobile(String model, int price, int maxSpeed, int yearModel, Coordinate coordinate) {
        super(model, price, maxSpeed, yearModel, coordinate);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void swim() {
        double x = super.getCoordinate().getX();
        double y = super.getCoordinate().getY();
        super.setCoordinate(x++, y--);

    }
    public void fly() {
        double x = super.getCoordinate().getX();
        double y = super.getCoordinate().getY();
        super.setCoordinate(x++, y--);

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
                + "Y " + super.getCoordinate().getY();
    }
}
