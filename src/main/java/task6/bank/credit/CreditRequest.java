package task6.bank.credit;

import task6.bank.Bank;
import task6.client.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static task6.Menu.showMenu;

public class CreditRequest {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int bankID;
    private static int goalID;


    public static void proposeCreateCredit(Client client, Bank[] banks) throws IOException {
        System.out.print("Получить кредит? (y/n): ");
        String userAnswer = reader.readLine().toUpperCase();
        if ("Y".equals(userAnswer)) {
            createCreditRequest(client, banks);
        } else if ("N".equals(userAnswer)){
            showMenu();
        } else {
            proposeCreateCredit(client,banks);
        }
    }

    private static void createCreditRequest(Client client, Bank[] banks) throws IOException {
        Credit creditRequest = new Credit();
        creditRequest.setClient(client);

        setBank(banks, creditRequest);
        creditRequest.setBankName(banks[bankID].getName());
        showGoals();

        setGoal(creditRequest);

        Double creditValue = getCreditValue();
        creditRequest.setValue(creditValue);

        Double fistPayment = getFirstPaymentValue();
        creditRequest.setFirstPaymentValue(fistPayment);

        int numPayments = getNumPayments();
        creditRequest.setNumPayments(numPayments);

        banks[bankID].createCreditOffer(creditRequest);
    }



    private static void setBank(Bank[] banks, Credit creditRequest) throws IOException {
        setBankID(banks);
        try {
            creditRequest.setBank(banks[bankID]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(
                    "Банк с индетификатором " + bankID + " еще не создан. " +
                    "Введите пожалуйста число от 1 до " + banks.length
            );
            setBank(banks,creditRequest);
         }
    }

    private static void setBankID(Bank[] banks) throws IOException {
        try {
            System.out.print("Введите номер банка в котором желаете запросить кредит(1" + "-" + banks.length + "): ");
            bankID = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка ввода. Введите пожалуйста число от 1 до " + banks.length);
            setBankID(banks);
        }
    }

    private static void showGoals() {
        System.out.println("\n######### Цель получения кредита #########");

        for (Goals dir : Goals.values()) {
            System.out.println("#" + dir.getId() + " " + dir.getGoal());
        }
    }

    private static void setGoal(Credit creditRequest) throws IOException {
        setGoalID();
        try {
            creditRequest.setGoal(Goals.getById(goalID));
        } catch (IllegalArgumentException e) {
            System.err.println(
                    "Цель с индетификатором " + goalID + " еще не создана. " +
                    "Введите пожалуйста число от 1 до " + Goals.values().length
            );
            setGoal(creditRequest);
        }
    }

    private static void setGoalID() throws IOException {
        try {
            System.out.print("Выберите номер соответствующий вашей цели получения кредита(1" + "-" + Goals.values().length + "): ");
            goalID = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка ввода. Введите пожалуйста число от 1 до " + Goals.values().length);
            setGoalID();
        }
    }

    private static Double getCreditValue() throws IOException {
        try {
            System.out.print("Введите необходимую сумму (грн.): ");
            return Double.parseDouble(reader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Принимаемый аргумент должен быть числом");
            getCreditValue();
        }
        return 0.0;
    }

    private static Double getFirstPaymentValue() throws IOException {
        try {
            System.out.print("Введите сумму первого взноса (грн.): ");
            return Double.parseDouble(reader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Принимаемый аргумент должен быть числом");
            getFirstPaymentValue();
        }
        return 0.0;
    }

    private static int getNumPayments() throws IOException {
        try {
            System.out.print("Срок возврата (количество месяцев): ");
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Принимаемый аргумент должен быть числом");
            getNumPayments();
        }
        return 0;
    }

}
