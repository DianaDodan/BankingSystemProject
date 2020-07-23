package com.banksystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    public void accountConstructor_whenPassingInValues_thenCompareWithGetters() {
        Account account = new Account("1234", "Pumapassword1", "Diana Dodan");
        String checkingNumber = account.getAccountNumber();
        assertEquals("1234", checkingNumber);
    }

    @Test
    public void accountEqualsMethod_whenCreating2ExactObjects_thenReturnTrue() {
        Account account = new Account("5678", "Pumapassword1", "Ben Diliberto");
        Account account2 = new Account("5678", "Pumapassword1", "Ben Diliberto");
        boolean similarity = account.equals(account2);
        assertEquals(true, similarity);

    }
}
