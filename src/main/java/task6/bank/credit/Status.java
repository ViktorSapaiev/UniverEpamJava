package task6.bank.credit;

public enum Status {
    OFFER("Кредитное предложение"),
    ACTIVE("Активен"),
    CLOSE("Закрыт");

    String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
