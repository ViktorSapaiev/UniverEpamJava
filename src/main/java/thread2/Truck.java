package thread2;

import java.util.ArrayList;
import java.util.List;

public class Truck {
    private List<Weapon> trailer;
    private int numPlace = 60;
    private int numProducts;
    private int calcProducts;
    private int price;
    private boolean valueSet = false;

    public Truck() {
        this.trailer = new ArrayList<>();
    }

    synchronized public void putProduct(Weapon[] box) {
        while (valueSet) {
            try {
                System.out.println("Петров: Кто тебя считать учил! давай быстрее!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Петров: Погрузил!");
        if(numProducts < numPlace) {
            for (Weapon aBox : box) {
                if(numProducts < numPlace) {
                    trailer.add(aBox);
                    numProducts++;
                }
            }
            valueSet = true;
            notify();
        }
    }

    synchronized public void calcPrice() {
        while (!valueSet){
            try {
                System.out.println("Нечепорчук: где носит Петрова?!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Нечепорчук: Считаю!");
        for (int i = calcProducts; i < trailer.size() ; i++) {
            price += trailer.get(i).getPrice();
        }
        calcProducts = numProducts;
        valueSet  = false;
        notify();
    }

    public int getNumPlace() {
        return numPlace;
    }


     public int getNumProducts() {
        return numProducts;
    }

    public int getPrice() {
        return price;
    }
}
