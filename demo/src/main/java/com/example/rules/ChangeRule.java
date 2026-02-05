package com.example.rules;
import java.util.Map;

import com.example.currency.Currency;

/**
 * Change Rules Interface
 */
public interface ChangeRule {

    /**
     * Determines whether this rule should be applied.
     */
    boolean applies(int changeInCents);

    /**
     * Denomination breakdown for the given amount.
     */
    Map<String, Integer> makeChange(int cents, Currency currency);
}
