package thread2;

import java.util.List;

public class MilitaryWarehouse {
    private List<Weapon> stock;

    public MilitaryWarehouse(List<Weapon> stock) {
        this.stock = stock;
    }

    public List<Weapon> getStock() {
        return stock;
    }
}
