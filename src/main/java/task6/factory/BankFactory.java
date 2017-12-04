package task6.factory;

import task6.bank.Bank;
import task6.bank.ERBank;
import task6.bank.FullBank;
import task6.bank.ICLBank;
import task6.bank.bankPerform.creditPercent.CreditPercent;
import task6.bank.bankPerform.creditPercent.YearPercentOther;
import task6.bank.bankPerform.creditPercent.YearPercentOtp;
import task6.bank.bankPerform.creditPercent.YearPercentPrivatBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static task6.util.RandomNumber.r;

public class BankFactory {
    private static final double MIN_BANKBALANCE = 30000000.0;
    private static final double MAX_BANKBALANCE = 4000000000.0;
    private static final int MIN_PERCENT = 8;
    private static final int MAX_PERCENT = 16;
    private static final int MIN_ID = 300;
    private static final int MAX_ID = 900;
    private static List<String> bankNames = new ArrayList<>(Arrays.asList(
            "Приватбанк", "Otp", "Ощадбанк", "УкрСиббанк", "Пумб", "Unicredits",
            "Райффайзен Банк Аваль", "НашБанк", "ТвойБанк", "КлиентБанк",
            "ЛюбимыйБанк", "Сбербанк", "НоунеймБанк", "ЧейТоБанк", "МайскийБанк",
            "ДушевныйБанк", "МамаМылаБанк", "БанкНеБанк", "КредитБанк", "ГосБанк",
            "НародныйБанк", "БанкСпираль", "ДенегНетБанк", "БанкОчередь"));

    public static Bank[] bankFactory() {
        Bank[] banks = new Bank[r(6, 23)];
        int id = 100;
        for (int i = 0; i < banks.length; i++) {
            if (i == 0) {
                bankCreator(banks, i, 0, new YearPercentPrivatBank());
            }
            if (i == 1) {
                bankCreator(banks, i, 1, new YearPercentOtp());
            } else {
                bankCreator(banks, i, i, new YearPercentOther());
            }
        }
        return banks;
    }

    private static void bankCreator(Bank[] banks, int i, int name, CreditPercent type) {
        switch (r(0, 4)) {
            case 0: {
                banks[i] = new Bank(
                        r(MIN_ID, MAX_ID),
                        bankNames.get(name),
                        r(MIN_BANKBALANCE, MAX_BANKBALANCE),
                        r(MIN_PERCENT, MAX_PERCENT),
                        type
                );
            }
            break;
            case 1: {
                banks[i] = new ERBank(
                        r(MIN_ID, MAX_ID),
                        bankNames.get(name),
                        r(MIN_BANKBALANCE, MAX_BANKBALANCE),
                        r(MIN_PERCENT, MAX_PERCENT),
                        type
                );
            }
            break;
            case 2: {
                banks[i] = new ICLBank(
                        r(MIN_ID, MAX_ID),
                        bankNames.get(name),
                        r(MIN_BANKBALANCE, MAX_BANKBALANCE),
                        r(MIN_PERCENT, MAX_PERCENT),
                        type
                );
            }
            break;
            case 3: {
                banks[i] = new FullBank(
                        r(MIN_ID, MAX_ID),
                        bankNames.get(name),
                        r(MIN_BANKBALANCE, MAX_BANKBALANCE),
                        r(MIN_PERCENT, MAX_PERCENT),
                        type
                );
            }
            break;
        }
    }

}
