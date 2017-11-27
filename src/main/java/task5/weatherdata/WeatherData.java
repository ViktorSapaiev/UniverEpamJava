package task5.weatherdata;

import task5.displays.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherData implements Subject {

    private static final String TEMPERATURE_KEY = "Temperature";
    private static final String HUMIDITY_KEY = "Humidity";
    private static final String PRESSURE_KEY = "Pressure";

    private float temperature;
    private float humidity;
    private float pressure;
    private float maxTemp;
    private float minTemp;
    private List<Observer> observers = new ArrayList<>();
    private Map<String, Float> lastNotify = new HashMap<>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this.temperature, this.humidity, this.pressure, this.minTemp, this.maxTemp);
        }
        saveNotify(this.temperature, this.humidity, this.pressure);
    }

    private boolean shouldNotify() {
        float tChange = lastNotify.get(TEMPERATURE_KEY) - this.temperature;
        float hChange = lastNotify.get(HUMIDITY_KEY) - this.humidity;
        float pChange = lastNotify.get(PRESSURE_KEY) - this.pressure;

        if (tChange >= 0.5 || tChange <= -0.5) {
            return true;
        } else if (hChange >= 1.0 || hChange <= -1.0) {
            return true;
        } else if (pChange >= 1.0 || pChange <= -1.0) {
            return true;
        }

        return false;
    }

    private void saveNotify(float temperature, float humidity, float pressure) {
        this.lastNotify.put(TEMPERATURE_KEY, temperature);
        this.lastNotify.put(HUMIDITY_KEY, humidity);
        this.lastNotify.put(PRESSURE_KEY, pressure);
    }

    public void setMeasurements(float temperature, float humidity, float pressure, float maxTemp, float minTemp) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        measurementsChanged();
    }

    private void measurementsChanged() {
        if (lastNotify.isEmpty() || shouldNotify()) {
            notifyObserver();
        }
    }
}
