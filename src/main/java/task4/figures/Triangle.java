package task4.figures;

public class Triangle implements Figure {
    private Point apexA, apexB, apexC;
    private Line sideAB, sideBC, sideAC;

    public Triangle(Point apexA, Point apexB, Point apexC) {
        try {
            checkPosition(apexA, apexB, apexC);
            this.apexA = apexA;
            this.apexB = apexB;
            this.apexC = apexC;
        } catch (Exception e) {
            System.err.println(" Error initialization. All apexes will be on one line");
            e.printStackTrace();
        }
    }

    public void show() {
        //заглушка
    }

    public Point getApexA() {
        return apexA;
    }

    public Point getApexB() {
        return apexB;
    }

    public Point getApexC() {
        return apexC;
    }

    public Line getSideAB() {
        if (sideAB == null) sideAB = new Line(apexA, apexB);
        return sideAB;
    }

    public Line getSideAC() {
        if (sideAC == null) sideAC = new Line(apexA, apexC);
        return sideAC;
    }

    public Line getSideBC() {
        if (sideBC == null) sideBC = new Line(apexB, apexC);
        return sideBC;
    }

    public void setApexA(Point p) {
        try {
            checkPosition(p, apexB, apexC);
            apexA = p;
            sideAB = null;
            sideAC = null;
        } catch (Exception e) {
            System.err.println("Error change of apexA. All apexes will be on one line");
            e.printStackTrace();
        }

    }

    public void setApexB(Point p) {
        try {
            checkPosition(apexA, p, apexC);
            apexB = p;
            sideAB = null;
            sideBC = null;
        } catch (Exception e) {
            System.err.println("Error change of apexB. All apexes will be on one line");
            e.printStackTrace();
        }

    }

    public void setApexC(Point p) {
        try {
            checkPosition(apexA, apexB, p);
            apexC = p;
            sideBC = null;
            sideAC = null;
        } catch (Exception e) {
            System.err.println(e + "Error change of apexC. All apexes will be on one line");
            e.printStackTrace();
        }

    }

    public void checkPosition(Point apexA, Point apexB, Point apexC) throws Exception {
        if (apexA.getX() == apexB.getX() && apexA.getX() == apexC.getX()) {
            throw new Exception();
        }
        if (apexA.getY() == apexB.getY() && apexA.getY() == apexC.getY()) {
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return "Triangle [" +
                " apexA: " + apexA +
                ", apexB: " + apexB +
                ", apexC: " + apexC +
                ']';
    }
}
