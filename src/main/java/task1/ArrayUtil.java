package task1;

public class ArrayUtil {
    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) - 50;
        }
    }

    public static void fillMatrix(int[][] matrix, int maxNumer) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * maxNumer);
            }
        }
    }

    public static void copyArray(float[] arr, float[] arrCp) {
        for (int i = 0; i < arr.length; i++) {
            arrCp[i] = arr[i];
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void swap(int[] arr, int elem1, int elem2) {
        int swap = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = swap;
    }

    public static void swap(float[] arr, int elem1, int elem2) {
        float swap = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = swap;
    }


}
