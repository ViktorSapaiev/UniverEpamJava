package task6.factory;

import task6.bank.Bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static task6.util.RandomNumber.r;

public class BankFactory {
    private static List<String> bankNames = new ArrayList<>(Arrays.asList(
            "Ощадбанк",
            "Приватбанк",
            "Укрсиббанк",
            "Пумб",
            "Otp",
            "Unicredits",
            "Райффайзен Банк Аваль"));

    public static Bank[] bankFactory() {
        Bank[] banks = new Bank[bankNames.size()];
        for (int i = 0; i < bankNames.size(); i++) {
            banks[i] = new Bank(bankNames.get(i),r(1000000000.0d,99999999999.0d),r(10, 20), r(8, 17), r(0, 2) == 1, r(0, 2) == 1);
        }
        return banks;
    }

    public static void addBankName(String bankName){
        bankNames.add(bankName);
    }
}
