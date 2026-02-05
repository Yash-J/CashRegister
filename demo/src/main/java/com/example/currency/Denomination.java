package com.example.currency;

/**
 * Denomiation of the currency
 * Example:
 *  quarter, 25
 *  1 euro, 100
 */
public record Denomination(String name, int valueInCents) {}
