package task6.client;

import task6.bank.credit.Credit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    private int id;
    private String fullName;
    private double balance;
    private LocalDate birthday;
    private String address;
    private String job;
    private String position;
    private double salary;
    private Map<Integer, List<Credit>> credits = new HashMap<>();

    public Client() {

    }

    public Client(String fullName, double salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Map getCredits() {
        return credits;
    }

    public void setCredits(int bankID, Credit credit) {
        if (credits.get(bankID) == null) {
            credits.put(bankID, new ArrayList<>());
            credits.get(bankID).add(credit);
        } else {
            credits.get(bankID).add(credit);
        }
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfile() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d.MM.yyyy");
        return "\n######### Информация о пользователе #########" + '\n' +
                "Фамилия Имя Отчество: " + fullName + '\n' +
                "Дата рождения: " + format.format(birthday) + '\n' +
                "Адресс прописки: " + address + '\n' +
                "Место работы: " + job + '\n' +
                "Должность: " + position + '\n' +
                "Заработная плата (грн.): " + salary + '\n' +
                "Кредитная история: " + credits;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", credits=" + credits +
                '}';
    }
}
