package com.example.primenumbers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HomePresenter implements HomeContract.Presenter {

    private final HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }


    @Override
    public void getPrimeNumbersInRange(String value) {
        if (value.isEmpty()) {
            view.showError("The value cannot be empty");
            return;
        }

        int max = Integer.parseInt(value);
        view.showPrimeNumbers(getPrimeNumbers(max));
    }

    private List<Integer> getPrimeNumbers(int maxValue) {
        boolean prime[] = new boolean[maxValue + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= maxValue; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= maxValue; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= maxValue; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
