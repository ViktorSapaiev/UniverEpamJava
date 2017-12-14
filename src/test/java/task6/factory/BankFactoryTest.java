package task6.factory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task6.bank.Bank;
import task6.bank.bankPerform.creditPercent.*;

import static org.junit.Assert.*;

public class BankFactoryTest {
    private BankFactory bF;

    @Before
    public void setUp() {
        bF = new BankFactory();
    }

    @After
    public void terDown() {
        bF = null;
    }

    @Test
    public void BanksIsNotEmpty() throws Exception {
        Bank[] banks = bF.bankFactory();
        int length = banks.length;
        assertTrue(length > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void IlligalArgumentInBankCreator() {
        Bank bank = bF.bankCreator(4,0, new YearPercentOther());
    }



}