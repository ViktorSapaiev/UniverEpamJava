package task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static task6.OperationCenter.*;

public abstract class Menu {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void showMenu() throws IOException {
        System.out.println("\n######### Главное меню #########");
        System.out.println("1. Показать кредитные предложения");
        System.out.println("2. Просмотреть профиль");
        System.out.println("3. Сменить пользователя");
        System.out.println("4. Выйти");
        System.out.print("Выберите действие(1-4): ");
        try {
            int userAnswer = Integer.parseInt(reader.readLine());
            if (userAnswer == 1) {
                printPropose();
            } else if (userAnswer == 2) {
                showCurrentClient();
                showProfileMenu();
            } else if (userAnswer == 3) {
                showClients();
                sayHello();
                showMenu();
            } else if (userAnswer == 4) {
                return;
            } else {
                throw new IllegalArgumentException("Неверное заданное число. Повторите попытку");
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка ввода. Введите пожалуйста число от 1 до 4");
            showMenu();
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            showMenu();
        }

    }

    public static void showProfileMenu() throws IOException {
        System.out.println("\n######### Меню пользователя #########");
        System.out.println("1. Просмотреть кредитную историю");
        System.out.println("2. Вернуться в главное меню");
        System.out.print("Выберите действие (1-2): ");
        try {
            int userAnswer = Integer.parseInt(reader.readLine());
            if (userAnswer == 1) {
                getCurrentClient().showCredits();
                showProfileMenu();
            } else if(userAnswer == 2){
                showMenu();
            } else {
                throw new IllegalArgumentException("Неверное заданное число. Повторите попытку");
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка ввода. Введите пожалуйста число от 1 до 2");
            showProfileMenu();
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            showProfileMenu();
        }

    }
}
