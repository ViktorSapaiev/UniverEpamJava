package task6.bank;

import task6.credit.Credit;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String name;
    private double balance;
    private float firstPayment;
    private Map<String, Credit> credits = new HashMap<>();
    private float minYearPercent;
    private boolean earlyRepayment;
    private boolean increaseCreditLine;

    public Bank(String name, double balance, float firstPayment, float minYearPercent, boolean earlyRepayment, boolean increaseCreditLine) {
        this.name = name;
        this.balance = balance;
        this.minYearPercent = minYearPercent;
        this.earlyRepayment = earlyRepayment;
        this.increaseCreditLine = increaseCreditLine;
    }

    public Map getCredits() {
        return credits;
    }

    public void setCredits(String fullName, Credit credit) {
        this.credits.put(fullName, credit);
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
        String increaseCreditLineAble = (increaseCreditLine) ? "Есть" : "Нет";
        credit.setStartDate(Calendar.getInstance());
        Calendar finishDate = Calendar.getInstance();
        finishDate.add(Calendar.MONTH, credit.getNumPayments());
        credit.setFinishDate(finishDate);
        credit.setClientFullName(credit.getClient().getFullName());
        calcYearPercent(credit);
        System.out.println("Банк \"" + name + "\" готов одобрить ваш кредит на следующих условиях:");
        credit.printCreditInformation();
        System.out.print("\tВозможность дострочного погашения: " + earlyRepaymentAble + '\n'
                + "\tВозможность увеличения кредитной линии: " + increaseCreditLineAble);
    }

    public void calcYearPercent(Credit credit) {
        float fistPaymentPercent = (float) (credit.getFirstPayment() / credit.getValue()) * 100;
        int numPayment = credit.getNumPayments();

        if (fistPaymentPercent < 10.0f && numPayment > 24) {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 10);
        } else if (fistPaymentPercent > 20.0f && numPayment < 24) {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 2);
        } else if (fistPaymentPercent > 20.0f && numPayment > 24) {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 4);
        } else {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 6);
        }
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
