package UniverEpamJava.task2____07_11_2017.until;

/**Используется для хранения координат */
public class Coordinate {
    /**Свойство координата Х */
    private double x;
    /**Свойство координата Y */
    private double y;
    /** Метод возвращающий литерал X*/
    public double getX() {
        return x;
    }
    /** Метод возвращающий литерал Y*/
    public double getY() {
        return y;
    }

    /**Инициализирует поля (@link Coordinate#x), (@link Coordinate#y) */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
