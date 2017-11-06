package task0;

/*
Используя циклы и метод:
System.out.print("* "), System.out.print("  "),
System.out.print("\n")
(для перехода на новую строку).
Выведите на экран:
    · прямоугольник
    · прямоугольный треугольник
    · равносторонний треугольник
    · ромб
 */

public class Exercise0 {
   public interface drawFigure {
       public void draw();
   }
   public static void main(String[] args) {
       Rectangle rect = new Rectangle(6, 8);
       rect.draw();
       System.out.println();
       System.out.println();
       RightTriangle t = new RightTriangle(6, 6);
       t.draw();
       System.out.println();
       System.out.println();
       Triangle t1 = new Triangle(6);
       t1.draw();
   }

   public static class Rectangle implements drawFigure {
       private int rows;
       private int columns;

       Rectangle (int width, int hight) {
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
   public static class RightTriangle implements drawFigure {
       private int a;
       private int b;

       RightTriangle (int a, int b) {
           this.a = a;
           this.b = b;
       }

       public  void draw() {
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
   public static class Triangle implements drawFigure {
        private int edgeSize;

        Triangle (int edgeSize) {
            this.edgeSize = edgeSize;
        }

        public void draw() {
            int size = edgeSize;
            while (size > 0) {
                for (int i = 0; i < size - 1; i++ ) {
                    System.out.print(" ");
                }
                if (size == edgeSize) {
                    System.out.print("* ");
                } else if (size < edgeSize && size > 1) {
                    System.out.print("* ");
                    for(int i = 0; i < edgeSize - size -1; i++){
                        if(size != edgeSize - 1) {
                            System.out.print("  ");
                        }
                    }
                    System.out.print("* ");
                } else if (size == 1) {
                    for (int i = 0; i < edgeSize; i++) {
                        System.out.print("* ");
                    }
                }
                System.out.print("\n");
                size--;
            }
        }
    }
   public static class Rhombus {

   }
}
