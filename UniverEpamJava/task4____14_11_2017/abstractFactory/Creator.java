package UniverEpamJava.task4____14_11_2017.abstractFactory;

import UniverEpamJava.task4____14_11_2017.figures.Color;
import UniverEpamJava.task4____14_11_2017.figures.Figure;
import UniverEpamJava.task4____14_11_2017.figures.Point;

import static UniverEpamJava.task4____14_11_2017.util.RandomNumber.r;

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
