package task1;
import static task1.UtilArray.*;
import java.util.Arrays;
/*
    Задача: Упорядочить столбцы по убыванию среднего значения.
 */

public class Exercise4 {
    public static void main(String[] args) {
        int[][] matrix  = new int[5][8];
        addContent(matrix);
        System.out.println('\n' + "Заданная матрица:");
        showMatrix(matrix);
        System.out.println('\n' + "Средние значения:" + '\n' + Arrays.toString(calcAverage(matrix)));
        System.out.println('\n' + "Результат:");
        sort(matrix);
        showMatrix(matrix);
        System.out.println('\n' + "Средние значения:" + '\n' + Arrays.toString(calcAverage(matrix)));


    }

    private static float[] calcAverage(int[][] arr) {
        float[] average = new float[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                average[j] += (float)arr[i][j];
                if (i + 1 == arr.length) {
                    average[j] /= arr.length;
                }
            }
        }
        return average;
    }

    public static void sort(int[][] arr) {
        float[] average = calcAverage(arr);
        float[] copyAverage = new float [average.length];
        for (int i = 0; i < arr.length; i++) {
            copyArray(average,copyAverage);
            for (int j = 0; j < arr[i].length - 1; j++) {
                for (int k = j+1; k < arr[i].length; k++) {
                    if (copyAverage[j] < copyAverage[k]) {
                        swap(arr[i], j, k);
                        swap(copyAverage, j, k);
                    }
                }
            }
        }

    }
}
