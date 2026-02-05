package com.example.rules;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.example.currency.Currency;
import com.example.currency.Denomination;

/**
 * Special rule that generates random change when
 * the change amount is divisible by a configured divisor.
 * This is thread safe for production environments.
 */
public final class RandomDivisorRule implements ChangeRule {

    private final int divisor;

    /**
     * @param divisor value that determines when randomness applies
     */
    public RandomDivisorRule(int divisor) {
        if (divisor <= 0) {
            throw new IllegalArgumentException("Divisor must be positive");
        }
        this.divisor = divisor;
    }

    /**
     * Rule applies only when divisible by divisor.
     */
    @Override
    public boolean applies(int changeInCents) {
        return changeInCents % divisor == 0;
    }

    /**
     * Randomly selects denominations.
     *
     * ThreadLocalRandom for multi threaded environment.
     */
    @Override
    public Map<String, Integer> makeChange(int cents, Currency currency) {
        Map<String, Integer> result = new LinkedHashMap<>();
        int remaining = cents;

        var denominations = currency.denominations();

        while (remaining > 0) {
            // Random denomination.
            Denomination d = denominations.get(
                    ThreadLocalRandom.current().nextInt(denominations.size())
            );

            if (d.valueInCents() <= remaining) {
                result.merge(d.name(), 1, Integer::sum);
                remaining -= d.valueInCents();
            }
        }
        return result;
    }
}