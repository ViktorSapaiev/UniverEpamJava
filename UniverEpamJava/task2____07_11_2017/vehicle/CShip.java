package UniverEpamJava.task2____07_11_2017.vehicle;
import UniverEpamJava.task2____07_11_2017.until.*;

public class CShip extends CVehicle implements SwimAble{

    private String port;
    private int numPassengers;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public void swim() {
        double x = super.getCoordinate().getX();
        double y = super.getCoordinate().getY();
        super.setCoordinate(x++, y--);

    }

    public CShip(String model, int price, int maxSpeed, int yearModel, Coordinate coordinate, String port, int numPassengers) {
        super(model, price, maxSpeed, yearModel, coordinate);
        this.port = port;
        this.numPassengers = numPassengers;
    }
    @Override
    public String toString() {
        return  "The Ship " + super.getModel() + '\n'
                + "Price: " + super.getPrice() + '\n'
                + "Maximal speed: " + super.getMaxSpeed() + '\n'
                + "Year Model: " + super.getYearModel() + '\n'
                + "Coordinate: " + "\n\t"
                + "X "+ super.getCoordinate().getX() + "\n\t"
                + "Y " + super.getCoordinate().getY() + '\n'
                + "Port: "+ this.getPort()+ '\n'
                + "Number of Passengers: "+ this.getNumPassengers();
    }
}

