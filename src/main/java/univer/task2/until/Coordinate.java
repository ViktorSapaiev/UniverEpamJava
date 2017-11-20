package UniverEpamJava.task2____07_11_2017.until;

/**Используется для хранения координат */
public class Coordinate {
    /**Свойство координата Х */
    private int x;
    /**Свойство координата Y */
    private int y;
    /**Свойство координата Z */
    private int z;
    /** Метод возвращающий литерал X*/
    public int getX() {
        return x;
    }
    /** Метод возвращающий литерал Y*/
    public int getY() {
        return y;
    }
    /** Метод возвращающий литерал Z*/
    public int getZ() {
        return z;
    }

    /**Инициализирует поля (@link Coordinate#x), (@link Coordinate#y) */
    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
