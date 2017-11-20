package UniverEpamJava.task4____14_11_2017.figures;

public class ColorLine extends Line implements Figure, isColor {
    private Color color;

    public ColorLine(Point beg, Point end, Color color) {
        super(beg, end);
        this.color = color;
    }

    public void show() {
        //заглушка
    }
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "ColorLine [ " + color + ", Beg: " + getBeg() + ", End: " + getEnd() + "]";
    }

}