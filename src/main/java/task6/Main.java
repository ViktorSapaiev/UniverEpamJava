package task6;

import org.xml.sax.SAXException;
import task6.bank.Bank;
import task6.client.Client;
import task6.client.clientParser.ClientParser;
import task6.factory.BankFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

import static task6.bank.credit.CreditRequest.proposeCreateCredit;
import static task6.util.BankSort.sort;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Bank[] banks = BankFactory.bankFactory();
    private static int userID = 1;
    private static List<Client> clients;

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ParseException {
        ClientParser clientParser = new ClientParser("E:\\EpamJava\\src\\resources\\task6\\clients.xml");
        clients = clientParser.parseClient();
        sayHello();
        showMenu();
        sort(banks);
    }

    public static void sayHello() {
        System.out.println("\nДобро пожаловать " + clients.get(userID).getFullName());
    }

    public static void showMenu() throws IOException {
        System.out.println("\n######### Главное меню #########");
        System.out.println("1. Показать кредитные предложения");
        System.out.println("2. Просмотреть профиль");
        System.out.println("3. Сменить пользователя");
        System.out.println("4. Выйти");
        System.out.print("Выберите действие: ");
        int userAnswer = Integer.parseInt(reader.readLine());
        if (userAnswer == 1) {
            printPropose(banks);
            proposeCreateCredit(clients.get(userID), banks);
        } else if (userAnswer == 2) {
            System.out.println(clients.get(userID).getProfile() + "\n");
            showMenu();
        } else if (userAnswer == 3) {
            System.out.println("######### Список Пользователей #########");
            for (int i = 0; i < clients.size(); i++) {
                Client client = clients.get(i);
                System.out.println((i + 1) + ". " + client.getFullName() + client.getProfile() + "\n");
            }
            System.out.print("Выберите пользователя (" + 1 + "-" + clients.size() + "): ");
            userAnswer = Integer.parseInt(reader.readLine());
            userID = userAnswer - 1;
            sayHello();
            showMenu();
        } else if (userAnswer == 4) {
            return;
        }
    }

    private static void printPropose(Bank[] banks) {
        System.out.println("\n######### Информация о кредитах #########");
        sort(banks);
        for (int i = 0; i < banks.length; i++) {
            System.out.println(i + 1 + ". " + banks[i].printCreditInformation() + "\n");
        }
    }

}
