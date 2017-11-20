package UniverEpamJava.task4____14_11_2017.figures;

public class ColorPoint extends Point implements Figure, isColor {
    private Color color;



    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    public ColorPoint(Point p, Color color) {
        super(p);
        this.color = color;
    }

    public void show() {
        //заглушка
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorPoint [ " + color + ", X: " + getX() + ", Y: " + getY() + "]";
    }
}