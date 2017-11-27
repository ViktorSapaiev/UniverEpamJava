package task5.displays;

import task5.weatherdata.Subject;

public class CurrentConditionalDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private float maxTemp;
    private float minTemp;
    private Subject weatherData;

    public  CurrentConditionalDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure, float maxTemp, float minTemp) {
        this.temperature = temp;//fahrenheitToCelsius(temp);
        this.humidity = humidity;
        this.pressure = pressure;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        display();
    }

    public void unsubscribe(){
        weatherData.removeObserver(this);
        weatherData = null;
    }

    public void display() {
        System.out.println("Weather in Kiev:\n" +
                "\ttemperature: " + temperature  + "C degrees\n" +
                "\tmaxTemp: " + maxTemp  + "C degrees\n" +
                "\tmin: " + temperature  + "C degrees\n" +
                "\thumidity: "+ humidity + "%\n" +
                "\tpressure: "+ pressure + "hpa"
        );
    }

}
