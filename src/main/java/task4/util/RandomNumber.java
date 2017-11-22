package task4.util;

public abstract class RandomNumber {

    /** Генерирует псевдорандомное число, типа int
     * @param min минимальное значение
     * @param max максимальное значение (не включительно)
     */
    public static int r(int min, int max) {
        return  (int)(Math.random() * (max - min)) +  min;
    }
}
