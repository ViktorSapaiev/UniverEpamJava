package task2.vehicle;
import task2.until.*;
import task2.vehicle.motion.*;

public class CPlane extends CVehicle implements MoveAble, FlyAble {
    private int flightAltitude;
    private int numPassengers;

    public int getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(int flightAltitude) {
        this.flightAltitude = flightAltitude;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public void fly() {
        int x = super.getCoordinate().getX();
        int y = super.getCoordinate().getY();
        int z = super.getCoordinate().getZ();
        x++;
        z++;
        super.setCoordinate(x, y,z);

    }
    public void move() {
        int x = super.getCoordinate().getX();
        int y = super.getCoordinate().getY();
        x++;
        super.setCoordinate(x, y,0);

    }

    public CPlane(String model, int price, int maxSpeed, int yearModel, Coordinate coordinate, int flightAltitude, int numPassengers) {
        super(model, price, maxSpeed, yearModel, coordinate);
        this.flightAltitude = flightAltitude;
        this.numPassengers = numPassengers;
    }

    @Override
    public String toString() {
        return "The Plane " + super.getModel() + '\n'
                + "Price: " + super.getPrice() + '\n'
                + "Maximal speed: " + super.getMaxSpeed() + '\n'
                + "Year Model: " + super.getYearModel() + '\n'
                + "Coordinate: " + "\n\t"
                + "X "+ super.getCoordinate().getX() + "\n\t"
                + "Y " + super.getCoordinate().getY() + "\n\t"
                + "Z " + super.getCoordinate().getZ() + '\n'
                + "Flight Altitude: "+ this.getFlightAltitude()+ '\n'
                + "Number of passenger: "+ this.getNumPassengers();
    }
}
