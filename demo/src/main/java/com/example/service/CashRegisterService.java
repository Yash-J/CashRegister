/**
 * CashRegisterService for calculating change and formatting the output 
 */
package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.currency.Currency;
import com.example.currency.Denomination;
import com.example.rules.ChangeRule;

@Service
public class CashRegisterService {

    private final Currency currency;
    private final List<ChangeRule> rules;

    public CashRegisterService(Currency currency, List<ChangeRule> rules) {
        this.currency = currency;
        this.rules = rules;
    }

    /**
     * Calculating the change.
     * @param owed input
     * @param paid input
     * @return formatted string
     */
    public String calculateChange(int owed, int paid) {
        int change = paid - owed;
        if (change <= 0) return "Owed is more than or equal to paid";

        for (ChangeRule rule : rules) {
            if (rule.applies(change)) {
                return format(rule.makeChange(change, currency));
            }
        }
        return "Cannot make change with available denominations";
    }

    /**
     * Formatted string
     * @param map denomination
     * @return formatted string
     */
    private String format(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Denomination d : currency.denominations()) {
            Integer count = map.get(d.name());
            if (count != null && count > 0) {
                if (!first) sb.append(",");
                sb.append(count).append(" ").append(currency.formatName(d.name(), count));
                first = false;
            }
        }
        return sb.toString();
    }
}
