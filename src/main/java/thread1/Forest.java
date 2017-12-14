package thread1;

import static task6.util.RandomNumber.r;

public class Forest {
    private String[][] forest;
    private boolean isBear = false;

    Forest(String[][] forest) {
        this.forest = forest;
    }

    public String[][] getForest() {
        return forest;
    }

    public boolean isBear() {
        return isBear;
    }

    public void setBear(boolean bear) {
        isBear = bear;
    }

    public void putBear(){
        int i = forest.length;
        int j = forest[0].length;
        forest[r(30,i)][r(30,j)] = "Медведь";
    }

}
