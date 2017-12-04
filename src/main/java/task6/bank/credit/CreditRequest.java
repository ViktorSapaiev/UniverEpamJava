package task6.bank.credit;

import task6.bank.Bank;
import task6.client.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreditRequest {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void proposeCreateCredit(Client client, Bank[] banks) throws IOException {
        System.out.print("Желаете запросить кредит? (y/n): ");
        String confirmCredit = reader.readLine().toUpperCase();
        if ("Y".equals(confirmCredit)) {
            createCreditRequest(client, banks);
        } else {
            System.out.println("Спасибо, что воспользовались нашей программой!");
        }
    }

    private static void createCreditRequest(Client client, Bank[] banks) throws IOException {
        System.out.print("Введите номер банка в котором желаете запросить кредит: ");
        int bankID = Integer.parseInt(reader.readLine());
        Credit creditRequest = new Credit();
        creditRequest.setClient(client);
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
        banks[bankID].createCreditOffer(creditRequest);
    }
}
