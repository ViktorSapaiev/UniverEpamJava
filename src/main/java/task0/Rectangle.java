package task0;
public class Rectangle implements ShowAble {
    private int rows;
    private int columns;

    Rectangle(int width, int hight) {
        this.rows = hight;
        this.columns = width;
    }

    public void draw() {
        int x = 1; //счетчик строк
        while (x <= rows) {
            int y = 1; //счетчик колонок
            System.out.print('\n');
            while (y <= columns) {
                if ((x == 1 || x == rows) && y <= columns) {
                    System.out.print("* ");
                } else if ((y == 1 || y == columns) && x > 1) {
                    System.out.print("* ");
                } else if (x != 1 && y != 1) {
                    System.out.print("  ");
                }
                y++;
            }
            x++;
        }
    }

}
