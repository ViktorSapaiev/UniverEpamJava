package UniverEpamJava.task4____14_11_2017.figures;

public class Line implements Figure {
    private Point beg;
    private Point end;

    public Line(Point beg, Point end) {
        super();
        this.beg = beg;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        super();
        this.beg = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public void show() {
        //заглушка
    }

    public Point getBeg() {
        //return new Point(beg);
        return beg;
    }

    public void setBeg(Point beg) {
        this.beg = beg;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line [" +
                " beg: "  + beg +
                ", end: " + end +
                ']';
    }
}