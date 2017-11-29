package task6.credit;

import task6.client.Client;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Credit {
    private static int startID = 10000;
    private int creditID;
    private Client client;
    private String clientFullName;
    private double value;
    private double firstPayment;
    private Calendar startDate;
    private Calendar finishDate;
    private String currency = "Гривна";
    private float yearPercent;
    private int numPayments; //количество платежей
    private Goals goal;

    public Credit() {
        this.creditID = startID++;
    }

    public Credit(Client client, double value, double firstPayment, float yearPercent, int numPayments, Goals goal) {
        this.creditID = startID++;
        this.client = client;
        this.value = value;
        this.firstPayment = firstPayment;
        this.yearPercent = yearPercent;
        this.numPayments = numPayments;
        this.goal = goal;
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

    public double getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(double firstPayment) {
        this.firstPayment = firstPayment;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Calendar finishDate) {
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

    public void printCreditInformation() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        System.out.println(
                "\tНомер договора: " + creditID + '\n' +
                        "\tФИО получателя: " + clientFullName + '\n' +
                        "\tСумма кредита (грн.): " + value + '\n' +
                        "\tДата начала: " + dateFormat.format(startDate.getTime()) + '\n' +
                        "\tДата окончания: " + dateFormat.format(finishDate.getTime()) + '\n' +
                        "\tСтавка: " + yearPercent + '\n' +
                        "\tПервый взнос (грн.): " + firstPayment + '\n' +
                        "\tКоличество платежей: " + numPayments
        );
    }

    @Override
    public String toString() {
        return "Credit{" +
                "creditID=" + creditID +
                ", clientFullName='" + clientFullName + '\'' +
                ", value=" + value +
                ", firstPayment=" + firstPayment +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", currency='" + currency + '\'' +
                ", yearPercent=" + yearPercent +
                ", numPayments=" + numPayments +
                ", goal='" + goal + '\'' +
                '}';
    }
}
