package task6.util;

public abstract class RandomNumber {

    /**
     * Генерирует псевдорандомное число, типа int
     *
     * @param min минимальное значение
     * @param max максимальное значение (не включительно)
     */
    public static int r(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public static double r(double min, double max) {
        return  (Math.random() * (max - min)) + min;
    }
}
