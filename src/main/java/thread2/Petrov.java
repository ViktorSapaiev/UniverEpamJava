package thread2;

public class Petrov implements  Runnable{
    private Street street;
    private Truck truck;

    public Petrov(Street street) {
        this.street = street;
        this.truck = street.getTruck();
    }

    public void run() {
        System.out.println("Петров: Занял позицию!");
        while (truck.getNumPlace() != truck.getNumProducts()) {
            Weapon[] weapon = street.getHeap();
            truck.putProduct(weapon);
            if(truck.getNumPlace() == truck.getNumProducts()) {
                {
                    System.out.println("Грузовик полон!");
                }
            }
        }
    }
}
