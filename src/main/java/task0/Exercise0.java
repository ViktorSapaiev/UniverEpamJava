package task0;
import task0.*;


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
        System.out.println();
        System.out.println();
        Rhombus rhombus = new Rhombus(5);
        rhombus.draw();

    }

}
