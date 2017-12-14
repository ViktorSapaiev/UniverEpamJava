package thread2;

import java.util.ArrayList;
import java.util.List;

import static task6.util.RandomNumber.r;

/*
       Темной-темной ночью прапорщики Иванов, Петров и Нечепорчук занимаются хищением военного имущества со склада родной военной части.
       Будучи умными людьми и отличниками боевой и строевой подготовки, прапорщики ввели разделение труда:
       Иванов выносит имущество со склада,
       Петров грузит его в грузовик,
       а Нечепорчук подсчитывает рыночную стоимость добычи.
       Требуется составить многопоточное приложение, моделирующее деятельность прапорщиков.
       При решении использовать парадигму «производитель-потребитель» с активным ожиданием.
 */

public class main {
    public static void main(String[] args) {
        MilitaryWarehouse mw = new MilitaryWarehouse(productFactory());
        Street street = new Street();
        Thread ivanov = new Thread(new Ivanov(mw,street));
        Thread petrov = new Thread(new Petrov(street));
        Thread necheporchuk = new Thread(new Necheporchuk(street));

        ivanov.start();
        petrov.start();
        necheporchuk.start();
    }

    private static List<Weapon> productFactory() {
        List<Weapon> weapons = new ArrayList<>();
        String[] arms = {"Патроны","Автомат","Граната","Пистолет","Снайперская винтовка","Пулемет","Обойма","Глушитель","Ракета","Гранатомет","Амуниция","Боевая экипировка"};
        int randomSize = r(200,1000);
        for (int i = 0; i < randomSize; i++) {
            weapons.add(new Weapon(arms[r(0,arms.length)],r(0,20000)));
        }

        return weapons;
    }
}
