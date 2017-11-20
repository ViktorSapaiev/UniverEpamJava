package univerEpamJava.task1;

import static univerEpamJava.task1.ArrayUtil.*;

/*
Дана квадратная матрица A порядка M (M — нечетное число). Начи-
ная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее эле-
менты по спирали: первая строка, последний столбец, последняя строка в
обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  эле-
менты второй строки и т. д.; последним выводится центральный элемент
матрицы.
*/

/**
 * Класс содержит необходимые методы для вывода на экран значений из квадратной матрицы <b>A</b>
 * порядка <b>M</b> (<b>M</b> - не четное число), по часовой стрелке, по спирали.
 * @author Sapaiev Viktor
 * @version 1.0
 *
 * */
public class Exercise5 {

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        fillMatrix(matrix, 9);
        printMatrix(matrix);
        System.out.println();
        printSpiraly(matrix);

    }

    /**
     * Метод выводит в строку все элементы матрицы, соверщая ее обход по спирали
     * @param matrix матрица
     */
    public static void printSpiraly(int[][] matrix) {
        /** Свойство - вверхняя граница */
        int upBorder = 0;
        /** Свойство - вверхняя граница */
        int downBorder = matrix.length - 1;
        int leftBorder = 0;
        int rightBorder = matrix[0].length - 1;
        int x;
        int y;
        y = moveRight(matrix[0], leftBorder, rightBorder);
        upBorder++;
        x = moveDown(matrix, upBorder, y, downBorder);
        rightBorder--;

        while (upBorder < matrix.length - 1) {
            y = moveLeft(matrix[x], rightBorder, leftBorder);
            downBorder--;

            x = moveUp(matrix, downBorder, y, upBorder);
            leftBorder++;

            y = moveRight(matrix[x], leftBorder, rightBorder);
            upBorder++;

            x = moveDown(matrix, upBorder, y, downBorder);
            rightBorder--;
        }
    }

    /** Выводит на экран элементы массива в заданном диапозоне, слева на право.
     @param arr переданный массив
     @param y начальная точка
     @param stop конечная точка
     */
    private static int moveRight(int[] arr, int y, int stop) {
        while (y <= stop) {
            System.out.print("[" + arr[y] + "]");
            y++;
        }
        return y - 1;
    }
    /** Выводит на экран элементы массива в заданном диапозоне, справа на лево.
     @param arr массив
     @param y начальная точка
     @param stop конечная точка
     */
    private static int moveLeft(int[] arr, int y, int stop) {
        while (y >= stop) {
            System.out.print("[" + arr[y] + "]");
            y--;
        }
        return y + 1;
    }

    /** Выводит на экран заданный столбец матрицы, сверху вниз.
     @param matrix матрица
     @param x координата первой строки
     @param y координа столбца элементы которого нужно отобразить
     @param stop координата поледней строки
     */
    private static int moveDown(int[][] matrix, int x, int y, int stop) {
        while (x <= stop) {
            System.out.print("[" + matrix[x][y] + "]");
            x++;
        }
        return x - 1;
    }
    /** Выводит на экран заданный столбец матрицы, снизу вверх.
     @param matrix матрица
     @param x координата первой строки
     @param y координа столбца элементы которого нужно отобразить
     @param stop координата поледней строки
     */
    private static int moveUp(int[][] matrix, int x, int y, int stop) {
        while (x >= stop) {
            System.out.print("[" + matrix[x][y] + "]");
            x--;
        }
        return x + 1;
    }


}
