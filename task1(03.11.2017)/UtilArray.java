package task1;

public class UtilArray {
    protected static void addContent(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100) - 50;
        }
    }

    protected static void addContent(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public static void copyArray(float[] arr, float[] arrCp) {
        for(int i = 0; i< arr.length; i++){
            arrCp[i] = arr[i];
        }
    }

    public static void showMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("[" + arr[i][j] + "]");
            }
            System.out.println();
        }
    }

    protected  static  void swap (int[] arr, int elem1, int elem2) {
        int swap = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = swap;
    }

    protected static  void swap (float[] arr, int elem1, int elem2) {
        float swap = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = swap;
    }



}
