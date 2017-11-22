package task4.figures;

public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        if (red >= 0 && red <= 255) {
            this.red = red;
        }
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        if (green >= 0 && green <= 255) {
            this.green = green;
        }
    }


    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        if (blue >= 0 && blue <= 255) {
            this.blue = blue;
        }
    }

    @Override
    public String toString() {
        return "Color[" +
                " red: " + red +
                ", green: " + green +
                ", blue: " + blue +
                ']';
    }


}
