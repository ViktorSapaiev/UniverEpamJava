package task2.vehicle;
import task2.until.*;
import task2.vehicle.motion.*;

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
        int x = super.getCoordinate().getX();
        int y = super.getCoordinate().getY();
        x++;
        super.setCoordinate(x, y,0);

    }

    public CShip(String model,int price, int maxSpeed, int yearModel, Coordinate coordinate, String port, int numPassengers) {
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

