package UniverEpamJava.task2____07_11_2017.vehicle;
import UniverEpamJava.task2____07_11_2017.until.*;

public class CPlane extends CVehicle implements FlyAble {
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
        double x = super.getCoordinate().getX();
        double y = super.getCoordinate().getY();
        super.setCoordinate(x++, y--);

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
                + "Y " + super.getCoordinate().getY() + '\n'
                + "Flight Altitude: "+ this.getFlightAltitude()+ '\n'
                + "Number of passenger: "+ this.getNumPassengers();
    }
}
