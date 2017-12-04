package task6.bank;

import task6.bank.bankPerform.creditPercent.CreditPercent;

public class ICLBank extends Bank implements IncreaseCreditLine {
    public ICLBank(int bankID, String name, double balance, float minYearPercent, CreditPercent creditPercent) {
        super(bankID, name, balance, minYearPercent, creditPercent);
        super.setIncreaseCreditLine(true);
    }

    public void increaseCreditLine() {

    }
}
