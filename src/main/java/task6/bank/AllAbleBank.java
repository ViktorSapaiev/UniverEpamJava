package task6.bank;

import task6.bank.bankPerform.creditPercent.CreditPercent;

public class AllAbleBank extends ERBank implements IncreaseCreditLineAble {

    public AllAbleBank(int bankID, String name, double balance, float minYearPercent, CreditPercent creditPercent) {
        super(bankID, name, balance, minYearPercent, creditPercent);
        super.setEarlyRepayment(true);
        super.setIncreaseCreditLine(true);
    }

    public void increaseCreditLine() {

    }
}
