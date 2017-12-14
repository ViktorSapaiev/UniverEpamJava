package thread2;

public class Weapon {
    private String name;
    private int price;

    public Weapon(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "(" + price + "$)";
    }
}
