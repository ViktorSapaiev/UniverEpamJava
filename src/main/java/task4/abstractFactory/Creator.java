package task4.abstractFactory;

import task4.figures.Color;
import task4.figures.Figure;
import task4.figures.Point;

import static task4.util.RandomNumber.r;

public abstract class Creator {
    public abstract Figure getFigure(int key);

    public Color randomColor() {
        return new Color(r(0,256), r(0,256),r(0,256));
    }

    public Point[] randomArrayPoints() {
        Point[] points = new Point[r(4,10)];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(r(0,256), r(0,256));
        }
        return points;
    }
}
