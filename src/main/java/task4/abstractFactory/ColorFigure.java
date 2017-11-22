package task4.abstractFactory;

import task4.figures.*;

import static task4.util.RandomNumber.r;

public class ColorFigure extends  Creator{
    public Figure getFigure(int key) {
        switch (key) {
            case 1: return new ColorPoint(r(0,50),r(0,50),randomColor());
            case 2: return new ColorTriangle(new Point(r(0,50),r(0,50)),new Point(r(0,50),r(0,50)),new Point(r(0,50),r(0,50)),randomColor());
            case 3: return new ColorLine(new Point(r(0,50),r(0,50)),new Point(r(0,50),r(0,50)),randomColor());
            case 4: return new ColorPolygon(randomArrayPoints(),randomColor());
            default: throw new IllegalArgumentException();
        }
    }
}
