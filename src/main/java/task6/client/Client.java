package task6.client;

import task6.credit.Credit;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private String fullName;
    private Calendar birthday;
    private String address;
    private String job;
    private String position;
    private double salary;
    private Map credits = new HashMap<String,Credit>();

    public Client(String fullName, double salary) {
        this.fullName = fullName;
        this.salary = salary;
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

    public void setCredits(Map credits) {
        this.credits = credits;
    }
}
