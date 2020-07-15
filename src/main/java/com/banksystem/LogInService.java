package com.banksystem;

import java.util.Optional;
import java.util.Scanner;

public class LogInService {
    static Scanner scanner = new Scanner(System.in);

    public static void compareUserInputsWithExistingData() {
        System.out.println("Enter your account number: ");
        String inputAccountNumber = scanner.nextLine();
        System.out.println("Enter your password: ");
        String inputUserPassword = scanner.nextLine();

        Optional<Account> optionalAccount = AccountService.getAccount(inputAccountNumber);

        if (optionalAccount.isPresent()) {
            if (inputUserPassword.equals(optionalAccount.get().getPassword())) {
                AccountMenu accountMenu = new AccountMenu(inputAccountNumber);
                accountMenu.accessBalanceOrDeleteAccountMenu();
            } else {
                System.out.println("Your password or account number is incorrect, try again.");
                compareUserInputsWithExistingData();
            }
        } else {
            System.out.println("The account with this number does not match. You can create a new one.");
        }
    }
}
