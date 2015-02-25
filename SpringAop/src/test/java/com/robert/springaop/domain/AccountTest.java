package com.robert.springaop.domain;

import com.robert.springaop.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by rhutto@ on 2/22/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AccountTest {


    @Test
    public void testConfigurableAccount() {

//        System.out.println("Account 1: "+ account.getAccountNumber());
//        System.out.println("Account 2: "+ account2.getAccountNumber());

        Account account3 = new Account();
    }
}
