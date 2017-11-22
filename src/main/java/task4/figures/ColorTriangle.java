package task4.figures;

public class ColorTriangle extends Triangle implements Figure, isColor {
    private Color color;

    public ColorTriangle(Point apexA, Point apexB, Point apexC, Color color) {
        super(apexA, apexB, apexC);
        this.color = color;
    }

    public void show() {
        //заглушка
    }

    @Override
    public String toString() {
        return "ColorTriangle [" + color + ", apexA: " + getApexA() + ", apexB: " + getApexB() + ", apexC: " + getApexC() +
                ']';
    }
}
