package task4.abstractfactory;

import task4.figures.*;

import static task4.util.RandomNumber.r;

public class ColorlessFigure extends  Creator{
    public Figure getFigure(int key) {
        switch (key) {
            case 1: return new Point(r(0,50),r(0,50));
            case 2: return new Triangle(new Point(r(0,50),r(0,50)),new Point(r(0,50),r(0,50)),new Point(r(0,50),r(0,50)));
            case 3: return new Line(new Point(r(0,50),r(0,50)),new Point(r(0,50),r(0,50)));
            case 4: return new Polygon(randomArrayPoints());
            default: throw new IllegalArgumentException();
        }
    }
}
