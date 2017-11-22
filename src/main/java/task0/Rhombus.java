package task0;

public class Rhombus implements ShowAble {
    private int edgeSize;

    public Rhombus(int edgeSize) {
        this.edgeSize = edgeSize;
    }

    public void draw(){
        for(int i = edgeSize; i > 0; i--) {
            shiftOutside(i-1);
            System.out.print("* ");
            if(i < edgeSize) {
                shiftInside(edgeSize - i - 1);
                System.out.print("* ");
            }
            System.out.print('\n');
        }
        for(int i = 2; i <= edgeSize; i++) {
            shiftOutside(i-1);
            System.out.print("* ");
            if(i == edgeSize) {
                break;
            }
            shiftInside(edgeSize - i - 1);
            System.out.print("* ");
            System.out.print('\n');
        }
    }

    private void shiftOutside(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(" ");
        }
    }

    private void shiftInside(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("  ");
        }
    }
}
