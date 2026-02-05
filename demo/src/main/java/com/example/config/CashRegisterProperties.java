/**
 * Define the properties used in Cash Register.
 * 
 */
package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @implNote Refer application.yaml for further details. 
 * Currency is used for entering the USD or Euros as Currency
 * randomDivisor is used for entering the random number at which if the amount is divisble  such as 3, 
 * the app should randomly generate the change denominations
 * inputFile is the file which is used for testing.
 * 
 */
@ConfigurationProperties(prefix = "cash-register")
public class CashRegisterProperties {

    private String currency;
    private int randomDivisor;
    private String inputFile;

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public int getRandomDivisor() { return randomDivisor; }
    public void setRandomDivisor(int randomDivisor) { this.randomDivisor = randomDivisor; }

    public String getInputFile() { return inputFile; }
    public void setInputFile(String inputFile) { this.inputFile = inputFile; }
}
