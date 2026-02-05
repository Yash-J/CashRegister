/**
 * Configuration for Cash Register application
 * Factory Pattern is used to create a Currency object.
 */
package com.example.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.currency.Currency;
import com.example.currency.CurrencyFactory;
import com.example.rules.ChangeRule;
import com.example.rules.MinimumChangeRule;
import com.example.rules.RandomDivisorRule;
import com.example.service.CashRegisterService;

@Configuration
public class CashRegisterConfig {

    private final CashRegisterProperties props;
    private final CurrencyFactory currencyFactory;

    public CashRegisterConfig(CashRegisterProperties props, CurrencyFactory currencyFactory) {
        this.props = props;
        this.currencyFactory = currencyFactory;
    }

    @Bean
    public Currency currency() {
        return currencyFactory.getCurrency(props.getCurrency());
    }

    @Bean
    public List<ChangeRule> changeRules() {
        return List.of(
                new RandomDivisorRule(props.getRandomDivisor()),
                new MinimumChangeRule()
        );
    }

    @Bean
    public CashRegisterService cashRegisterService(Currency currency, List<ChangeRule> rules) {
        return new CashRegisterService(currency, rules);
    }
}
