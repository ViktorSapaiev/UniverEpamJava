package task1;

import java.util.Arrays;

import static task1.ArrayUtil.fillArray;
import static task1.ArrayUtil.swap;

/*
    В одномерном массиве сначала положительные потом отрицательные за О(n).
*/

public class Exercise2 {

    public static void main(String[] args) {
        int[] arr = new int[26];
        fillArray(arr);
        System.out.println('\n' + "Заданный массив:");
        System.out.println(Arrays.toString(arr));
        shiftNegativeToLeft(arr);
        System.out.println('\n' + "Результат:");
        System.out.println(Arrays.toString(arr));
    }

    public static void shiftNegativeToLeft(int[] data) {
        int beg = 0;
        int end = data.length - 1;
        while (beg < end) {
            if (data[beg] < 0) {
                while (end > beg) {
                    if(data[end] >= 0) {
                        swap(data, beg, end);
                        end--;
                        break;
                    }
                    end--;
                }
            }
            beg++;
        }
    }
}
