package UniverEpamJava.task4____14_11_2017.figures;

import java.util.ArrayList;

public class ColorPolygon extends Polygon implements Figure, isColor {
    private Color color;

    public void show() {
        //заглушка
    }

    public ColorPolygon(ArrayList<Point> points, Color color) {
        super(points);
        this.color = color;
    }

    public ColorPolygon(Point[] points, Color color) {
        super(points);
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorPolygon [" + color +
                " Apexes " + getPoints() +
                " numApexes: " + getNumApexes() +
                ']';
    }
}
