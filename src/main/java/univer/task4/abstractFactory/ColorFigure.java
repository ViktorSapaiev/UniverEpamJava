package UniverEpamJava.task4____14_11_2017.abstractFactory;

import UniverEpamJava.task4____14_11_2017.figures.*;

import static UniverEpamJava.task4____14_11_2017.util.RandomNumber.r;

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
