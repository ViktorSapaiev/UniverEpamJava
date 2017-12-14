package thread2;

import java.util.List;

import static task6.util.RandomNumber.r;

public class Ivanov implements Runnable {
    private List<Weapon> stock;
    private Street street;
    private Truck truck;

    public Ivanov(MilitaryWarehouse mw, Street street) {
        this.stock = mw.getStock();
        this.street = street;
        this.truck = street.getTruck();
    }

    public void run() {
        System.out.println("Иванов: Начнем!");
        int count = 0;
        while(count < truck.getNumPlace()) {
            Weapon[] box = new Weapon[r(1,5)];
            for (int j = 0; j < box.length ; j++) {
                int randomWeapon = r(0,stock.size());
                box[j] = stock.get(randomWeapon);
                count++;
                stock.remove(randomWeapon);
            }
            street.putProduct(box);
        }
    }
}
