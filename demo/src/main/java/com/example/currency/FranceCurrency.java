package com.example.currency;

import java.util.List;

/**
 * France currency implementation.
 */
public final class FranceCurrency implements Currency {

    /**
     * Euro denominations commonly used in France.
     */
    private static final List<Denomination> DENOMINATIONS = List.of(
            new Denomination("2 euros", 200),
            new Denomination("1 euro", 100),
            new Denomination("50 centimes", 50),
            new Denomination("20 centimes", 20),
            new Denomination("10 centimes", 10),
            new Denomination("5 centimes", 5),
            new Denomination("2 centimes", 2),
            new Denomination("1 centime", 1)
    );

    @Override
    public List<Denomination> denominations() {
        return DENOMINATIONS;
    }

    /**
     * French denomination names.
     * No format necessary
     */
    @Override
    public String formatName(String baseName, int count) {
        return baseName;
    }
}
