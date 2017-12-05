package task6.bank;

import task6.bank.bankPerform.creditPercent.CreditPercent;
import task6.bank.credit.Credit;
import task6.bank.credit.Status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static task6.Menu.showMenu;

public class Bank {
    private int bankID;
    private String name;
    private double balance;
    private Map<Integer, List<Credit>> credits = new HashMap<>();
    private float minYearPercent;
    private CreditPercent creditPercent;
    private boolean earlyRepayment = false;
    private boolean increaseCreditLine = false;

    public Bank(int bankID, String name, double balance, float minYearPercent, CreditPercent creditPercent) {
        this.bankID = bankID;
        this.name = name;
        this.balance = balance;
        this.minYearPercent = minYearPercent;
        this.creditPercent = creditPercent;
    }

    public Map getCredits() {
        return credits;
    }

    public void setCredits(Integer id, List<Credit> credit) {
        this.credits.put(id, credit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public float getMinYearPercent() {

        return minYearPercent;
    }

    public void setMinYearPercent(float minYearPercent) {
        this.minYearPercent = minYearPercent;
    }

    public boolean isEarlyRepayment() {
        return earlyRepayment;
    }

    public void setEarlyRepayment(boolean earlyRepayment) {
        this.earlyRepayment = earlyRepayment;
    }

    public boolean isIncreaseCreditLine() {
        return increaseCreditLine;
    }

    public void setIncreaseCreditLine(boolean increaseCreditLine) {
        this.increaseCreditLine = increaseCreditLine;
    }

    public void setCreditPercent(CreditPercent creditPercent) {
        this.creditPercent = creditPercent;
    }

    public String printCreditInformation() {
        String earlyRepaymentAble = (earlyRepayment) ? "Есть" : "Нет";
        String increaseCreditLineAble = (increaseCreditLine) ? "Есть" : "Нет";
        return name + '\n'
                + "\tМинимальная процентная ставка: " + minYearPercent + "% годовых\n"
                + "\tВозможность дострочного погашения: " + earlyRepaymentAble + '\n'
                + "\tВозможность увеличения кредитной линии: " + increaseCreditLineAble;
    }

    public void createCreditOffer(Credit credit) {
        String earlyRepaymentAble = (earlyRepayment) ? "Есть" : "Нет";
        fillCreditInform(credit);
        System.out.println("\nБанк \"" + name + "\" готов одобрить ваш кредит на следующих условиях:");
        System.out.println("\n######### Кредитное предложение #########");
        credit.getCreditShortInfo();
        System.out.println("\n#########################################\n");
        try {
            creditConfirm(credit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillCreditInform(Credit credit) {
        credit.setClientFullName(credit.getClient().getFullName());
        credit.setStartDate(LocalDate.now());
        credit.setFinishDate(credit.getStartDate().plusMonths(credit.getNumPayments()));
        credit.setClientPaid(credit.getFirstPaymentValue());
        calcYearPercent(credit);
        credit.setSumPercents(((credit.getValue() - credit.getClientPaid()) * (credit.getYearPercent() / 12)) / 100);
        credit.setStatus(Status.OFFER);
    }

    private void creditConfirm(Credit credit) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Подтвердить кредит?(y/n)");
        String userAnswer = reader.readLine().toUpperCase();
        if ("Y".equals(userAnswer)) {
            int clientID = credit.getClient().getId();
            if (credits.get(clientID) == null) {
                credits.put(clientID, new ArrayList<>());
                credits.get(clientID).add(credit);
            } else {
                credits.get(clientID).add(credit);
            }
            credit.getClient().setCredits(bankID, credit);
            credit.setStatus(Status.ACTIVE);
            System.out.println("Кредит получен!");
            showMenu();
        } else if ("N".equals(userAnswer)){
            showMenu();
        } else {
            creditConfirm(credit);
        }
    }

    public void calcYearPercent(Credit credit) {
        creditPercent.calcYearPercent(credit, minYearPercent);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", minYearPercent=" + minYearPercent +
                ", earlyRepayment=" + earlyRepayment +
                ", increaseCreditLine=" + increaseCreditLine +
                '}';
    }
}
