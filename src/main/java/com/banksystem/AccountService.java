package com.banksystem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountService {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    static Map<String, Account> accountNumberToAccountPasswordMap = new HashMap<>();


    private static String createAccountNumber() {
        String accountNumber = String.format("%s%s%s%s", getRandomIntString(), getRandomIntString(), getRandomIntString(), getRandomIntString());
        System.out.println("This is your account number: " + accountNumber);
        return accountNumber;
    }

    private static String getRandomIntString() {
        return String.valueOf(random.nextInt(10));
    }

    private static String createPassword() {
        System.out.println("Please create a password that contains a capital letter and at least a number: ");
        String inputtedPassword = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z[0-9]]{8,}$");
        Matcher matcher = pattern.matcher(inputtedPassword);
        if (matcher.matches()) {
            System.out.println("Your password matches the requirements.");
            return inputtedPassword;
        } else {
            System.out.println("Choose another password.");
            return createPassword();
        }
    }

    private static String enterName() {
        System.out.println("Please enter your name for verification: ");
        String enteredName = scanner.nextLine();
        if (!enteredName.isEmpty()) {
            return enteredName;
        } else {
            System.out.println("You didn't enter a real name.");
            return enterName();
        }
    }

    public static void createAccount() {
        String accountNumber = createAccountNumber();
        String password = createPassword();
        String name = enterName();
        Account account = new Account(accountNumber, password, name);
        accountNumberToAccountPasswordMap.put(account.getAccountNumber(), account);
        BalanceService.accountNumberToBalanceMap.put(account.getAccountNumber(), 0.00);
    }

    public static Optional<Account> getAccount(String accountNumber) {
        Account accessedAccountInMap = accountNumberToAccountPasswordMap.get(accountNumber);
        return Optional.ofNullable(accessedAccountInMap);
    }

    public static void deleteAccount(String accountNumber) {
        accountNumberToAccountPasswordMap.remove(accountNumber);
    }
}

