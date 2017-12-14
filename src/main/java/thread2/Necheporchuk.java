package thread2;

import java.util.List;

public class Necheporchuk implements Runnable {
    private Street street;
    private Truck truck;

    public Necheporchuk (Street street) {
        this.street = street;
        this.truck = street.getTruck();
    }

    public void run() {
        System.out.println("Нечепорчук: Я на месте!");
        while (truck.getNumPlace() != truck.getNumProducts()) {
            truck.calcPrice();
            if(truck.getNumPlace() == truck.getNumProducts()) {
                {
                    System.out.println("Нечепорчук: Посчитано! Сейчас тут: " + truck.getNumProducts() + " товаров на cумму " + truck.getPrice() + "$. Поехали!");
                }
            }
        }
    }
}
