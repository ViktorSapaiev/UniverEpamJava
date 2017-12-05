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
import java.net.URL;
import java.text.ParseException;
import java.util.List;

import static task6.Menu.showMenu;
import static task6.bank.credit.CreditRequest.proposeCreateCredit;
import static task6.util.BankSort.sort;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Bank[] banks = BankFactory.bankFactory();
    private static int userID = 0;
    private static List<Client> clients;
    private static Client currentClient;
    private URL url = getClass().getResource("task6/clients.xml");

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ParseException {
        ClientParser clientParser = new ClientParser(Main.class.getResourceAsStream("clients.xml"));
        clients = clientParser.parseClient();
        currentClient = clients.get(userID);
        sayHello();
        showMenu();
        sort(banks);
    }

    public static Client getCurrentClient() {
        return currentClient;
    }

    public static void setCurrentClient(Client currentClient) {
        Main.currentClient = currentClient;
    }

    public static void sayHello() {
        System.out.println("\nДобро пожаловать " + currentClient.getFullName());
    }

    public static void showCurrentClient() {
        System.out.println(currentClient.getProfile() + "\n");
    }

    public static void showClients() throws IOException {
        System.out.println("######### Список Пользователей #########");
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            System.out.println((i + 1) + ". " + client.getFullName() + client.getProfile() + "\n");
        }
        changeClient();
    }

    private static void changeClient() throws IOException {
        int userAnswer;
        System.out.print("Выберите пользователя (" + 1 + "-" + clients.size() + "): ");
        try{
            userAnswer = Integer.parseInt(reader.readLine());
            userID = userAnswer - 1;
            setCurrentClient(clients.get(userID));
        } catch (IndexOutOfBoundsException e) {
            System.err.print("Пользователя с таким индификатором не существует.");
            changeClient();
        } catch (IllegalArgumentException e) {
            System.err.print("Ошибка ввода. Введите пожалуйста число от 1 до " + clients.size());
            changeClient();
        }
    }

    public static void printPropose() throws IOException {
        System.out.println("\n######### Доступные кредитные предложения #########");
        sort(banks);
        for (int i = 0; i < banks.length; i++) {
            System.out.println(i + 1 + ". " + banks[i].printCreditInformation() + "\n");
        }
        proposeCreateCredit(currentClient, banks);
    }

}
