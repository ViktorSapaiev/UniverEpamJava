package thread2;

import java.util.Arrays;

public class Street {
    private Weapon[] box;
    private boolean valueSet = true;
    private Truck truck;

    public Street() {
        this.truck = new Truck();
    }

    synchronized public Weapon[] getHeap() {
        while (valueSet) {
            try {
                System.out.println("Петров: Ничего нет нужно подождать!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Петров: Взял " + Arrays.toString(box));
        valueSet = true;
        notify();
        return box;
    }

    synchronized  public void putProduct(Weapon[] box){
        while (!valueSet) {
            try {
                System.out.println("Иванов: Петров тормозишь! забирай давай!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Иванов: Принес со склада!" + Arrays.toString(box));
        this.box = box;
        valueSet = false;
        notify();
    }

    public Truck getTruck() {
        return truck;
    }
}
