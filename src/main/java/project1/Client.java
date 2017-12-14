package project1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private int id;
    private String fullName;
    private double balance;
    private LocalDate birthday;
    private String address;
    private String job;
    private String position;
    private double salary;

    public Client(int id, String fullName, double balance, LocalDate birthday, String address, String job, String position, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.balance = balance;
        this.birthday = birthday;
        this.address = address;
        this.job = job;
        this.position = position;
        this.salary = salary;
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
                "Кредитная история: " + "Введите \"1\" что бы просмотреть";
    }
}
