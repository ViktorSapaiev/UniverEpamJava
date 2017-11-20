package univerEpamJava.task5;

public class WetherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionalDisplay currentDisplay = new CurrentConditionalDisplay(weatherData);

        weatherData.setMeasurements(20,70,30.4f);
    }

}
