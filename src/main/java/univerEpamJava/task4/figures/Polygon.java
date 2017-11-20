package UniverEpamJava.task4____14_11_2017.figures;

import java.util.ArrayList;
import java.util.Collections;

public class Polygon implements Figure {
    private ArrayList<Point> points = new ArrayList<>();
    private int numApexes;

    public Polygon(ArrayList<Point> points) {
        try {
            checkSize(points.size());
            this.points = points;
            this.numApexes = points.size();
        } catch (Exception e) {
            System.err.println("The Polygon must have more than two points");
            e.printStackTrace();
        }
    }

    public Polygon(Point[] points) {
        try {
            checkSize(points.length - 1);
            Collections.addAll(this.points, points);
            this.numApexes = this.points.size();
        } catch (Exception e) {
            System.err.print("The Polygon must have more than two points");
            e.printStackTrace();
        }

    }

    public void show() {
        //заглушка
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public int getNumApexes() {
        return numApexes;
    }

    public void addApex(Point apex) {
        points.add(apex);
        numApexes = points.size();
    }

    public void removeApex(int index) {
        try {
            checkSize(numApexes - 1);
            points.remove(index);
            numApexes = points.size();
        } catch (Exception e) {
            System.err.println("The Polygon must have more than two points");
            e.printStackTrace();
        }
    }

    private void checkSize(int numApexes) throws Exception {
        if (numApexes < 3) {
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return "Polygon [" +
                " points: " + points +
                ", numApexes: " + numApexes +
                ']';
    }
}
