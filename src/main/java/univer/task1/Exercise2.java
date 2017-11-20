package univer.task1;

import java.util.Arrays;

import static univer.task1.ArrayUtil.*;

/*
    В одномерном массиве сначала положительные потом отрицательные за О(n).
*/

public class Exercise2 {

    public static void main(String[] args) {
        int[] arr = new int[25];
        fillArray(arr);
        System.out.println('\n' + "Заданный массив:");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println('\n' + "Результат:");
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int cnt[][] = new int[4][];
        int b[];
        int i, j;
        int a_len = arr.length;

        if (a_len < 2) {
            return;
        }

        for (j = 0; j < 4; j++) {
            cnt[j] = new int[257];
            for (i = 0; i < 257; i++){
                cnt[j][i] = 0;
            }
        }

        b = new int[a_len];

        for (i = 0; i < a_len; i++) {
            for (j = 0; j < 4; j++) {
                cnt[j][1 + ((arr[i] >>> (8 * j)) & 0xff)]++;
            }
        }

        for (j = 0; j < 4; j++) {
            for (i = 1; i < 256; i++) {
                cnt[j][i] += cnt[j][i - 1];
            }
            for (i = 0; i < a_len; i++) {
                b[cnt[j][(arr[i] >>> (8 * j)) & 0xff]++] = arr[i];
            }
            for (i = 0; i < a_len; i++) {
                arr[i] = b[i];
            }
        }
    }
}
