package task6.bank.bankPerform.creditPercent;

import task6.bank.credit.Credit;

public class YearPercentPrivatBank implements CreditPercent {
    public void calcYearPercent(Credit credit, float minYearPercent) {
        float fistPaymentPercent = (float) (credit.getFirstPaymentValue() / credit.getValue()) * 100;
        int numPayment = credit.getNumPayments();

        if (fistPaymentPercent < 10.0f && numPayment > 24) {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 10);
        } else if (fistPaymentPercent > 20.0f && numPayment < 24) {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 2);
        } else if (fistPaymentPercent > 20.0f && numPayment > 24) {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 4);
        } else {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 6);
        }
    }
}
