package univer.task1;

import static univer.task1.ArrayUtil.*;

import java.util.Arrays;

/*
    Упорядочить одномерный масиве вначале отрицательные повозрастанию
    затем положительные по убыванию.
*/

public class Exercise1 {

    public static void main(String[] args) {
        int[] arr = new int[25];
        fillArray(arr);

        System.out.println('\n' + "Заданный массив:");
        System.out.println(Arrays.toString(arr));

        sort1(arr);
        System.out.println('\n' + "Результат:");
        System.out.println(Arrays.toString(arr));
    }

    private static void sortType(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] >= 0 && arr[j] < 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void sort1(int[] arr) {
        sortType(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] >= 0 && arr[j] >= 0) {
                    if (arr[i] < arr[j]) {
                        swap(arr, i, j);
                    }
                } else if (arr[i] < 0 && arr[j] < 0) {
                    if (arr[i] < arr[j]) {
                        swap(arr, i, j);
                    }
                }
            }
        }
    }
}
