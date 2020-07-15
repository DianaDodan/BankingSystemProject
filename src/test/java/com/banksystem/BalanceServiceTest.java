package com.banksystem;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class BalanceServiceTest {

    //when created a new account, the balance should be 0 no matter what
    @Test
    public void balance_whenCreatingANewAccount_thenCompareWithMappedValue() {
        Account account = new Account("1234","Pumapassword1", "Diana Dodan");
        String accountNumber = account.getAccountNumber();
        String input = accountNumber + System.getProperty("line.separator") + "Pumapassword1" + System.getProperty("line.separator") + "Diana Dodan";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AccountService.createAccount();
        double realBalance = BalanceService.seeBalance();
        assertEquals(0.00, realBalance);
    }
}