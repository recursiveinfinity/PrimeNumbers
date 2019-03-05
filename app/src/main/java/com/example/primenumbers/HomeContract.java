package com.example.primenumbers;

import java.util.List;

public interface HomeContract {
    interface View {
        void showPrimeNumbers(List<Integer> primeNumbers);
        void showError(String message);
    }

    interface Presenter {
        void getPrimeNumbersInRange(String value);
    }
}
