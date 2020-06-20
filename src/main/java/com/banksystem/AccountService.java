package com.banksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountService {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    //create a map
    Map<Integer, Account> accountNumberToAccountPasswordMap = new HashMap<>();

    // make a create method for creating the account
    private static int createAccountNumber() {
        int accountNumber = random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
        System.out.println("This is your account number: " + accountNumber);
        return accountNumber;
    }

    private static String createPassword() {
        System.out.println("Please create a password that contains a capital letter and at least a number: ");
        String inputedPassword = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z[0-9]]{8,}$");
        Matcher matcher = pattern.matcher(inputedPassword);
        if (matcher.matches()) {
            System.out.println("Your password matches the requirements.");
            return inputedPassword;
        } else {
            System.out.println("Choose another password.");
            return createPassword();
        }
    }

    private static String enterName() {
        System.out.println("Please enter your name for verification: ");
        String enteredName = scanner.nextLine();
        return enteredName;
    }

    public static void createAccount() {
        createAccountNumber();
        createPassword();
        enterName();
    }

}
