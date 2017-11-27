package task5.displays;

public interface Observer {
    public void  update(float temp, float humidity, float pressure, float maxTemp, float minTemp);
}
