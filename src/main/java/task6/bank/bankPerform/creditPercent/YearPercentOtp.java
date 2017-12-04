package task6.bank.bankPerform.creditPercent;

import task6.bank.credit.Credit;

public class YearPercentOtp implements CreditPercent {
    public void calcYearPercent(Credit credit, float minYearPercent) {
        float fistPaymentPercent = (float) (credit.getFirstPayment() / credit.getValue()) * 100;
        int numPayment = credit.getNumPayments();

        if (fistPaymentPercent < 10.0f && numPayment > 24) {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 12);
        } else if (fistPaymentPercent > 20.0f && numPayment < 24) {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 3);
        } else if (fistPaymentPercent > 20.0f && numPayment > 24) {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 5);
        } else {
            credit.setYearPercent(minYearPercent + credit.getGoal().getPercent() + 6);
        }
    }
}
