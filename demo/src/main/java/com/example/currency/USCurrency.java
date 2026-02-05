package com.example.currency;

import java.util.List;

/**
 * US currency implementation.
 */
public final class USCurrency implements Currency {

    /**
     * List of US denominations in descending value.
     * Order is important for greedy algorithm.
     */
    private static final List<Denomination> DENOMINATIONS = List.of(
            new Denomination("dollar", 100),
            new Denomination("quarter", 25),
            new Denomination("dime", 10),
            new Denomination("nickel", 5),
            new Denomination("penny", 1)
    );

    @Override
    public List<Denomination> denominations() {
        return DENOMINATIONS;
    }

    /**
     * Formating of US denomiation
     */
    @Override
    public String formatName(String baseName, int count) {
        // for penny to pennies 
        if(baseName.equals("penny")) {
            return count == 1 ? baseName : baseName.substring(0,baseName.length()-1) + "ies";
            // all others.
        } else  {
            return count == 1 ? baseName : baseName + "s";
        }
        
    }
}
