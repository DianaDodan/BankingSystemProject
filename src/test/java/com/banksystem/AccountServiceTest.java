package com.banksystem;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    // creates a correct sequence of 4 digits, saves the name and password
    @Test
    public void createAccount_whenValidVariablesPassedIn_thenStoreInTheMap() {
        String input = "Password1" + System.getProperty("line.separator") + "Ben Diliberto";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        AccountService.createAccount();
        assertFalse(AccountService.accountNumberToAccountPasswordMap.isEmpty());
    }


}