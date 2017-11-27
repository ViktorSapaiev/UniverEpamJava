package task5;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import task5.displays.CurrentConditionalDisplay;
import task5.displays.ForecastDisplay;
import task5.weather.Weather;
import task5.weatherdata.WeatherData;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;



public class WeatherStation {
    private static final String MAIN_WEATHER_KEY = "main";
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionalDisplay currentDisplay = new CurrentConditionalDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        Weather weather = getWeather();
        if (weather != null) {
            weatherData.setMeasurements(weather.getTemp(), weather.getHumidity(), weather.getPressure(),weather.getTemp_max(),weather.getTemp_min());
        }

    }

       public static Weather getWeather() {
           try {
               URL addr = new URL("http://api.openweathermap.org/data/2.5/weather?q=London&units=metric&APPID=a4eda7dc36f771d248d4bcf9fa367527\n");
               HttpURLConnection connection = (HttpURLConnection) addr.openConnection();
               connection.connect();
               InputStream inputStream = connection.getInputStream();
               BufferedInputStream reader = new BufferedInputStream(inputStream);
               String weather = "";
               int i;
               while ((i = reader.read()) != -1) {
                   weather += (char) i;
               }
               inputStream.close();
               connection.disconnect();
               return jsonWeatherParser(weather);
           } catch (IOException ex) {
               System.out.println(ex.toString());
               return null;
           }
       }

       private  static Weather jsonWeatherParser(String weather){
           JsonObject jSon = new Gson().fromJson(weather,JsonObject.class);
           return  new Gson().fromJson(jSon.getAsJsonObject(MAIN_WEATHER_KEY), Weather.class);
       }

}


