package task6.bank.credit;

import task6.bank.Bank;
import task6.client.Client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Credit {
    private static int startID = 10000;
    private int creditID;
    private String bankName;
    private Bank bank;
    private Client client;
    private String clientFullName;
    private double value;
    private double firstPaymentValue;
    private double clientPaid;
    private double sumPercents;
    private LocalDate startDate;
    private LocalDate finishDate;
    private String currency = "Гривна";
    private float yearPercent;
    private int numPayments;
    private Status status;
    private Goals goal;

    public Credit() {
        this.creditID = startID++;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getClientPaid() {
        return clientPaid;
    }

    public void setClientPaid(double clientPaid) {
        this.clientPaid = clientPaid;
    }

    public double getSumPercents() {
        return sumPercents;
    }

    public void setSumPercents(double sumPercents) {
        this.sumPercents = sumPercents;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getFirstPaymentValue() {
        return firstPaymentValue;
    }

    public void setFirstPaymentValue(double firstPaymentValue) {
        this.firstPaymentValue = firstPaymentValue;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public float getYearPercent() {
        return yearPercent;
    }

    public void setYearPercent(float yearPercent) {
        this.yearPercent = yearPercent;
    }

    public int getNumPayments() {
        return numPayments;
    }

    public void setNumPayments(int numPayments) {
        this.numPayments = numPayments;
    }

    public Goals getGoal() {
        return goal;
    }

    public void setGoal(Goals goal) {
        this.goal = goal;
    }

    public void getCreditShortInfo() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d.MM.yyyy");
        String earlyRepaymentAble = (bank.isEarlyRepayment()) ? "Есть" : "Нет";
        System.out.println(
                "\n\tНомер договора: " + creditID + '\n' +
                "\tСостояние: " + status.getStatus() + '\n' +
                "\tНаименование банка: " + bankName + '\n' +
                "\tФИО получателя: " + clientFullName + '\n' +
                "\tСумма кредита (грн.): " + value + '\n' +
                "\tДата начала: " + format.format(startDate) + '\n' +
                "\tДата окончания: " + format.format(finishDate) + '\n' +
                "\tСтавка: " + yearPercent + '\n' +
                "\tПервый взнос (грн.): " + firstPaymentValue + '\n' +
                "\tКоличество платежей: " + numPayments + '\n' +
                "\tВозможность дострочного погашения: " + earlyRepaymentAble
        );
    }

    public void getCreditFullInfo() {
        getCreditShortInfo();
        System.out.println(
                "\tЗаплачено: " + clientPaid + '\n' +
                "\tЗадолжность с процентов: " + sumPercents + '\n'
        );


    }

    @Override
    public String toString() {
        return "Credit{" +
                "creditID=" + creditID +
                ", bankName='" + bankName + '\'' +
                ", clientFullName='" + clientFullName + '\'' +
                ", value=" + value +
                ", firstPaymentValue=" + firstPaymentValue +
                ", clientPaid=" + clientPaid +
                ", sumPercents=" + sumPercents +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", currency='" + currency + '\'' +
                ", yearPercent=" + yearPercent +
                ", numPayments=" + numPayments +
                ", status=" + status +
                ", goal=" + goal.getGoal() +
                '}';
    }
}
