package com.example.rules;

import java.util.LinkedHashMap;
import java.util.Map;

import com.example.currency.Currency;
import com.example.currency.Denomination;

/**
 * Default rule that produces the minimum number of physical units.
 *
 * Used greedy algorithm
 */
public final class MinimumChangeRule implements ChangeRule {

    /**
     * It applied always
     */
    @Override
    public boolean applies(int changeInCents) {
        return true;
    }

    /**
     * Greedy algorithm is used.
     */
    @Override
    public Map<String, Integer> makeChange(int cents, Currency currency) {
        Map<String, Integer> result = new LinkedHashMap<>();
        int remaining = cents;

        for (Denomination d : currency.denominations()) {
            int count = remaining / d.valueInCents();
            if (count > 0) {
                result.put(d.name(), count);
                remaining %= d.valueInCents();
            }
        }
        return result;
    }
}