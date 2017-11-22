package task0;

public class RightTriangle implements ShowAble {
    private int a;
    private int b;

    RightTriangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void draw() {
        int x = a;
        int y = b;
        while (x != 0) {
            if (x == a) {
                System.out.print("* ");
                System.out.print("\n");
            } else {
                System.out.print("* ");
                if (x == 1) {
                    while (y != 2) {
                        System.out.print("* ");
                        y--;
                    }
                } else {
                    for (int i = (a - 1) - x; i > 0; i--) {
                        System.out.print("  ");
                    }
                }
                System.out.print("* ");
                System.out.print("\n");
            }
            x--;
        }

    }
}
