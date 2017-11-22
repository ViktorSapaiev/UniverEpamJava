package task4.util;
import task4.abstractFactory.ColorFigure;
import task4.abstractFactory.ColorlessFigure;
import task4.abstractFactory.Creator;
import task4.figures.*;

import static task4.util.RandomNumber.r;


public abstract class FigureUtil {


    public static void printArray(Object[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            System.out.println("\n");
        }
    }

    public static void countFigures(Figure[] figures) {
        int points = 0, lines = 0, triangles = 0, polygons = 0;
        int cpoints = 0, clines = 0, ctriangles = 0, cpolygons = 0;
        for (int i = 0; i < figures.length ; i++) {
            String className = figures[i].getClass().getSimpleName();
            switch (className) {
                case "Point": points++; break;
                case "ColorPoint": cpoints++; break;
                case "Line": lines++; break;
                case "ColorLine": clines++; break;
                case "Triangle": triangles++; break;
                case "ColorTriangle": ctriangles++; break;
                case "Polygon": polygons++; break;
                case "ColorPolygon": cpolygons++; break;
                default: throw new IllegalArgumentException();
            }
        }
        System.out.println("Points: " + points + ", ColorPoints: " + cpoints +
                ", Lines: " + lines + ", ColorLines: " + clines +
                ", Triangles: " + triangles + ", ColorTriangles: " + ctriangles +
                ", Polygons: " + polygons + ", ColorPolygons: " + cpolygons);
    }

    public static int countFigures(Figure[] figures, String className) {
        int count = 0;
        for (int i = 0; i < figures.length ; i++) {
            if(className.equals(figures[i].getClass().getSimpleName())){
                count++;
            }
        }
        return count;
    }

    public static Figure[] getFigures(Figure[] figures, String className) {
        Figure[] selectedFigures = new Figure[countFigures(figures,className)];
        for (int i = 0, j = 0; i < figures.length ; i++) {
            if(className.equals(figures[i].getClass().getSimpleName())){
                selectedFigures[j] = figures[i];
                j++;
            }
        }
        return selectedFigures;
    }

    public static Figure[] autoFill(int sizeArray){
        Creator colorFactory = new ColorFigure();
        Creator colorlessFactory = new ColorlessFigure();
        Figure[] figures = new Figure[sizeArray];
        int i = 0;
        while (i < figures.length) {
            figures[i] = colorFactory.getFigure(r(1,5));
            i++;
            figures[i] = colorlessFactory.getFigure(r(1,5));
            i++;
        }
        return  figures;
    }
    public static Figure[] getColorFigures(Figure[] figures) {
        Figure[] colorFigures = new Figure[figures.length];
        for (int i = 0, j = 0; i < figures.length ; i++) {
            if (figures[i] instanceof isColor) {
                colorFigures[j] = figures[i];
                j++;
            }
        }
        return colorFigures;
    }

    public static Figure[] getColorlessFigures(Figure[] figures) {
        Figure[] colorlessFigures = new Figure[figures.length];
        for (int i = 0, j = 0; i < figures.length ; i++) {
            if (!(figures[i] instanceof isColor)) {
                colorlessFigures[j] = figures[i];
                j++;
            }
        }
        return colorlessFigures;
    }



}
