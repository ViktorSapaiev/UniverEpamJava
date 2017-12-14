package thread1;

public class Bees implements Runnable {
    private Forest forest;
    private int begin;
    private int end;

    public Bees(Forest forest, Coordinate coordinate) {
        this.forest = forest;
        this.begin = coordinate.getBegin();
        this.end = coordinate.getEnd();
    }

    public void run() {
        String[][] field = forest.getForest();
        for (int i = begin; i <= end ; i++) {
            if(!forest.isBear()) {
                for (int j = 0; j < field[0].length; j++) {
                    if ("Медведь".equals(field[i][j])) {
                        System.out.println("Отряд " + Thread.currentThread().getName() + " нашел медведя!");
                        System.out.println("Координаты [ x: " + i + " y: " + j + " ]");
                        forest.setBear(true);
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }
}
