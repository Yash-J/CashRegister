/**
 * Factory design pattern is used.
 */
package com.example.currency;

import org.springframework.stereotype.Component;

@Component
public class CurrencyFactory {
    public Currency getCurrency(String code) {
        return switch (code.toUpperCase()) {
            case "FRANCE" -> new FranceCurrency();
            case "US" -> new USCurrency();
            default -> throw new IllegalArgumentException("Unsupported currency: " + code);
        };
    }
}
