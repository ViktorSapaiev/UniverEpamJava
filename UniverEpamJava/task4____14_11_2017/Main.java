package UniverEpamJava.task4____14_11_2017;

import UniverEpamJava.task4____14_11_2017.figures.*;

import static UniverEpamJava.task4____14_11_2017.util.FigureUtil.*;


public class Main {
    public static void main(String[] args) {
        Figure[] myArr = autoFill(40);
        System.out.println("Массив фигур: ");
        printArray(myArr);
        System.out.println("Массив треугольников: ");
        Figure[] triangles = getFigures(myArr,"Triangle");
        printArray(triangles);
        System.out.println("Массив цветных треугольников: ");
        Figure[] colorTriangles = getFigures(myArr,"ColorTriangle");
        printArray(colorTriangles);
        System.out.println("Массив точек: ");
        Figure[] points = getFigures(myArr,"Point");
        printArray(points);
        System.out.println("Массив цветных точек: ");
        Figure[] colorPoints = getFigures(myArr,"ColorPoint");
        printArray(colorPoints);
        System.out.println("Массив линий: ");
        Figure[] lines = getFigures(myArr,"Line");
        printArray(lines);
        System.out.println("Массив цветных линий: ");
        Figure[] colorLines = getFigures(myArr,"ColorLine");
        printArray(colorLines);
        System.out.println("Массив многоугольников: ");
        Figure[] polygons = getFigures(myArr,"Polygon");
        printArray(polygons);
        System.out.println("Массив цветных многоугольников: ");
        Figure[] colorPolygons = getFigures(myArr,"ColorPolygon");
        printArray(colorPolygons);

    }


}
