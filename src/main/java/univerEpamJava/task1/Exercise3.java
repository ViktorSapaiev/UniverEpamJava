package univerEpamJava.task1;

import static univerEpamJava.task1.ArrayUtil.*;

import java.util.Arrays;
/*
    Задача: Упорядочить столбцы по убыванию среднего значения.
 */

public class Exercise3 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][8];
        fillMatrix(matrix, 9);
        System.out.println('\n' + "Заданная матрица:");

        printMatrix(matrix);
        System.out.println('\n' + "Средние значения в столбце:" + '\n' + Arrays.toString(calculateAverage(matrix)));
        System.out.println('\n' + "Результат:");

        sort(matrix);
        printMatrix(matrix);
        System.out.println('\n' + "Средние значения в столбце:" + '\n' + Arrays.toString(calculateAverage(matrix)));


    }

    private static float[] calculateAverage(int[][] arr) {
        float[] average = new float[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                average[j] += (float) arr[i][j];
                if (i + 1 == arr.length) {
                    average[j] /= arr.length;
                }
            }
        }
        return average;
    }

    public static void sort(int[][] arr) {
        float[] average = calculateAverage(arr);
        float[] copyAverage = new float[average.length];
        for (int i = 0; i < arr.length; i++) {
            copyArray(average, copyAverage);
            for (int j = 0; j < arr[i].length - 1; j++) {
                for (int k = j + 1; k < arr[i].length; k++) {
                    if (copyAverage[j] < copyAverage[k]) {
                        swap(arr[i], j, k);
                        swap(copyAverage, j, k);
                    }
                }
            }
        }

    }
}
