package com.robert.springaop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * Created by rhutto@ on 2/22/15.
 */
@Configuration
@ComponentScan
@EnableSpringConfigured
public class ApplicationConfig {

//    @Bean
//    @Scope(value = "prototype")
//    public Account account() {
//        Account account = new Account();
//        account.setAccountNumber(String.valueOf(Math.random()));
//        return account;
//    }

    @Bean
    public String accountNumber() {
        return String.valueOf(Math.random());
    }
}


