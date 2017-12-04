package task6.bank;

import task6.bank.bankPerform.creditPercent.CreditPercent;
import task6.bank.credit.Credit;

public class ERBank extends Bank implements EarlyRepayment {

    public ERBank(int bankID, String name, double balance, float minYearPercent, CreditPercent creditPercent) {
        super(bankID, name, balance, minYearPercent, creditPercent);
        super.setEarlyRepayment(true);
    }

    public double earlyRepayment(Credit credit) {
        return (credit.getValue() - credit.getClientPaid()) + credit.getSumPercents();
    }
}