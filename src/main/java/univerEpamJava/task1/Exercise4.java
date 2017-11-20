package univerEpamJava.task1;

import java.util.Arrays;

import static univerEpamJava.task1.ArrayUtil.*;

/*
    Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
*/

public class Exercise4 {

    public static void main(String[] args) {
        int[][] matrix = new int[5][10];
        fillMatrix(matrix, 3);

        System.out.println('\n' + "Заданная матрица:");
        printMatrix(matrix);
        System.out.println('\n' + "Максимальная длинна последовательностей в строках:" + '\n' + Arrays.toString(countRepetitive(matrix)));

        sort(matrix);
        System.out.println('\n' + "Результат:");
        printMatrix(matrix);
        System.out.println('\n' + "Максимальная длинна последовательностей в строках:" + '\n' + Arrays.toString(countRepetitive(matrix)));
    }


    private static int[] countRepetitive(int[][] matrix) {
        int[] repetitive = new int[matrix.length];
        int line = 1;
        int maxLine = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    line++;
                    if (line > maxLine) {
                        maxLine = line;
                    }
                } else {
                    line = 1;
                }
            }
            repetitive[i] = maxLine;
            line = 1;
            maxLine = 1;
        }
        return repetitive;
    }

    public static void sort(int[][] matrix) {
        int[] repetitive = countRepetitive(matrix);
        for (int i = 0; i < repetitive.length - 1; i++) {
            for (int j = i + 1; j < repetitive.length; j++) {
                if (repetitive[i] > repetitive[j]) {
                    int[] temp = matrix[j];
                    matrix[j] = matrix[i];
                    matrix[i] = temp;
                    swap(repetitive, i, j);
                }
            }
        }
    }
}
