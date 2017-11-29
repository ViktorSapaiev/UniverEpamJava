package task6;

import task6.bank.Bank;
import task6.client.Client;
import task6.credit.Credit;
import task6.credit.Goals;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static task6.factory.BankFactory.*;

import java.io.*;
import java.util.Calendar;


public class Main {
    private static Client client;

    public static void main(String[] args) {
        addBankName("ПроКредитБанк");
        Bank[] banks = bankFactory();
        sort(banks);
        printPropose(banks);
        try {
            requestCredit(banks);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void requestCredit(Bank[] banks) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Желаете запросить кредит? (Y\\N): ");
        String confirmCredit = reader.readLine().toUpperCase();

        if ("Y".equals(confirmCredit)) {
            System.out.print("Введите номер банка в котором желаете запросить кредит: ");
            int bankID = Integer.parseInt(reader.readLine());
            Credit creditRequest = createCreditRequest();
            banks[bankID].createCreditOffer(creditRequest);
        } else {
            System.out.println("Спасибо, что воспользовались нашей программой!");
        }
    }

    private static Credit createCreditRequest() throws IOException {
        Credit creditRequest = new Credit();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //creditRequest.setClient(createClient());
        System.out.println("\nЦель получения кредита: ");
        for (Goals dir : Goals.values()) {
            System.out.println("#" + dir.getId() + " " + dir.getGoal());
        }
        System.out.println("Выберите номер соответствующий вашей цели получения кредита: ");
        int goalID = Integer.parseInt(reader.readLine());
        creditRequest.setGoal(Goals.getById(goalID));

        System.out.print("Введите необходимую сумму (грн.): ");
        creditRequest.setValue(Double.parseDouble(reader.readLine()));

        System.out.print("Введите сумму первого взноса (грн.): ");
        creditRequest.setFirstPayment(Double.parseDouble(reader.readLine()));

        System.out.print("Срок возврата (количество месяцев): ");
        creditRequest.setNumPayments(Integer.parseInt(reader.readLine()));
        return creditRequest;
    }

   private static Client createClient() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите ваше ФИО: ");
        String name = reader.readLine();
        System.out.print("Введите вашу заработную плату: ");
        double salary = Double.parseDouble(reader.readLine());
        return new Client(name, salary);
    }


    private static void printPropose(Bank[] banks) {
        for (int i = 0; i < banks.length; i++) {
            System.out.println("#" + i + " " + banks[i].printCreditInformation() + "\n");
        }
    }

    private static void sort(Bank[] banks) {
        for (int i = 0; i < banks.length - 1; i++) {
            for (int j = i + 1; j < banks.length; j++) {
                float fPercent = banks[i].getMinYearPercent();
                float sPercent = banks[j].getMinYearPercent();
                boolean fErlRepayment = banks[i].isEarlyRepayment();
                boolean sErlRepayment = banks[j].isEarlyRepayment();
                boolean fIncCreditLn = banks[i].isIncreaseCreditLine();
                boolean sIncCreditLn = banks[j].isIncreaseCreditLine();
                if (fPercent > sPercent) {
                    swap(banks, i, j);
                } else if (fPercent == sPercent) {
                    if ((!fErlRepayment && !fIncCreditLn) && (sErlRepayment && sIncCreditLn)) {
                        swap(banks, i, j);
                    } else if (!fErlRepayment && sErlRepayment) {
                        swap(banks, i, j);
                    } else if (!fIncCreditLn && sIncCreditLn) {
                        swap(banks, i, j);
                    }
                }
            }
        }
    }

    public static void swap(Object[] arr, int elem1, int elem2) {
        Object swap = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = swap;
    }
}
