/**
 * Currency interface.
 * Any type of currency such as US or Euros can implement this interface.
 */
package com.example.currency;
import java.util.List;

public interface Currency {

    /**
     * List of Denominations 
     * @return denominations in descending order of value.
     * Order matters for greedy algorithms.
     */
    List<Denomination> denominations();

    /**
     * Used for formating the data.
     * @param baseName name of the currency note such as quarter, penny, dollar
     * @param count number of notes of each baseName
     * @return format as String
     */
    String formatName(String baseName, int count);
}
