package task6.bank.credit;

import task6.bank.Bank;
import task6.client.Client;

public class CreditRequest {
    private Bank bank;
    private Client client;
    private String clientFullName;
    private double value;
    private double firstPaymentValue;
    private int numPayments;
    private Status status;
    private Goals goal;

    public CreditRequest(Bank bank, Client client, String clientFullName, double value, double firstPaymentValue, int numPayments, Status status, Goals goal) {
        this.bank = bank;
        this.client = client;
        this.clientFullName = clientFullName;
        this.value = value;
        this.firstPaymentValue = firstPaymentValue;
        this.numPayments = numPayments;
        this.status = status;
        this.goal = goal;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
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

    public int getNumPayments() {
        return numPayments;
    }

    public void setNumPayments(int numPayments) {
        this.numPayments = numPayments;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Goals getGoal() {
        return goal;
    }

    public void setGoal(Goals goal) {
        this.goal = goal;
    }
}
