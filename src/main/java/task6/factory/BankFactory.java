package task6.factory;

import task6.bank.AllAbleBank;
import task6.bank.Bank;
import task6.bank.ERBank;
import task6.bank.ICLBank;
import task6.bank.bankPerform.creditPercent.CreditPercent;
import task6.bank.bankPerform.creditPercent.YearPercentOther;
import task6.bank.bankPerform.creditPercent.YearPercentOtp;
import task6.bank.bankPerform.creditPercent.YearPercentPrivatBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private static List<String> bankNames;

    public Bank[] bankFactory() throws IOException {
        bankNames = new ArrayList<>(Arrays.asList(txtParser()));
        Bank[] banks = new Bank[r(6, bankNames.size())];
        for (int i = 0; i < banks.length; i++) {
            if ("ПриватБанк".equals(bankNames.get(i))) {
                banks[i] = bankCreator(r(0, 4), i, new YearPercentPrivatBank());
            }
            if ("ОТП Банк".equals(bankNames.get(i))) {
                banks[i] = bankCreator(r(0, 4), i, new YearPercentOtp());
            } else {
                banks[i] = bankCreator(r(0, 4), i, new YearPercentOther());
            }
        }
        return banks;
    }

    public Bank bankCreator(int key, int name, CreditPercent type) {
        switch (key) {
            case 0: {
                return new Bank(
                        r(MIN_ID, MAX_ID),
                        bankNames.get(name),
                        r(MIN_BANKBALANCE, MAX_BANKBALANCE),
                        r(MIN_PERCENT, MAX_PERCENT),
                        type
                );
            }
            case 1: {
                return new ERBank(
                        r(MIN_ID, MAX_ID),
                        bankNames.get(name),
                        r(MIN_BANKBALANCE, MAX_BANKBALANCE),
                        r(MIN_PERCENT, MAX_PERCENT),
                        type
                );
            }
            case 2: {
                return new ICLBank(
                        r(MIN_ID, MAX_ID),
                        bankNames.get(name),
                        r(MIN_BANKBALANCE, MAX_BANKBALANCE),
                        r(MIN_PERCENT, MAX_PERCENT),
                        type
                );
            }
            case 3: {
                return new AllAbleBank(
                        r(MIN_ID, MAX_ID),
                        bankNames.get(name),
                        r(MIN_BANKBALANCE, MAX_BANKBALANCE),
                        r(MIN_PERCENT, MAX_PERCENT),
                        type
                );
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    private String[] txtParser() throws IOException {
        InputStream is = BankFactory.class.getResourceAsStream("bankNames.txt");
        System.out.println();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String currentStr;
        String names = "";
        while ((currentStr = reader.readLine()) != null) {
            names += currentStr + ",";
        }
        return names.split(",");
    }
}
