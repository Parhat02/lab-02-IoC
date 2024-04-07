package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {

    @Bean
    public Currency currencyBean(){
        return new Currency("USD", "Dollar");
    }
    @Bean
    public Current currentBean(Currency currency){
        Current current = new Current();
        current.setAmount(new BigDecimal(200));
        current.setAccountId(UUID.randomUUID());
        current.setCurrency(currency);

        return current;
    }

    @Bean
    public Saving savingBean(){
        Saving saving = new Saving();
        saving.setAmount(new BigDecimal(500));
        saving.setAccountId(UUID.randomUUID());

        saving.setCurrency(currencyBean());
        return saving;
    }
}
