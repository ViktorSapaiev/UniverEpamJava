package task6.bank;

import org.junit.Test;
import org.mockito.Mockito;
import task6.bank.bankPerform.creditPercent.YearPercentOther;
import task6.bank.credit.Credit;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void testCreateCreditOffer() {
        Bank sut  = new Bank(1, "x", 1000, 20, new YearPercentOther());
        Credit collaborator = Mockito.mock(Credit.class);

        sut.createCreditOffer(collaborator);

        Mockito.verify(collaborator).getCreditShortInfo();
    }
}