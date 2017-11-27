package task4.figures;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test(expected = IllegalArgumentException.class)
    public void AllPointOnOneLine() {
        Triangle tr = new Triangle(new Point(1,1),new Point(1,3), new Point(1,3));
    }

}