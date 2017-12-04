package task6.util;

import task6.bank.Bank;

public abstract class BankSort {

    public static void sort(Bank[] banks) {
        for (int i = 0; i < banks.length - 1; i++) {
            for (int j = i + 1; j < banks.length; j++) {
                float fPercent = banks[i].getMinYearPercent();
                float sPercent = banks[j].getMinYearPercent();
                boolean fErlRepayment = banks[i].isEarlyRepayment();
                boolean sErlRepayment = banks[j].isEarlyRepayment();
                boolean fIncCreditLn = banks[i].isIncreaseCreditLine();
                boolean sIncCreditLn = banks[j].isIncreaseCreditLine();
                if (fPercent > sPercent) {
                    swap(banks, i, j);
                } else if (fPercent == sPercent) {
                    if ((!fErlRepayment && !fIncCreditLn) && (sErlRepayment && sIncCreditLn)) {
                        swap(banks, i, j);
                    } else if (!fErlRepayment && sErlRepayment) {
                        swap(banks, i, j);
                    } else if (!fIncCreditLn && sIncCreditLn) {
                        swap(banks, i, j);
                    }
                }
            }
        }
    }

    private static void swap(Object[] arr, int elem1, int elem2) {
        Object swap = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = swap;
    }

}
