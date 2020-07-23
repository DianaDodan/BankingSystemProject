package com.banksystem;

import java.util.Scanner;

public class AccountMenu {
    private String accountNumber;

    public AccountMenu(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    static Scanner scanner = new Scanner(System.in);

    public void accessBalanceOrDeleteAccountMenu() {
        System.out.println("You successfully logged in. Choose one from the following options: ");
        System.out.println("1. See your balance.");
        System.out.println("2. Delete your account.");
        System.out.println("3. Log out of the account.");
        System.out.println("4. Add money in the account");

        int userInput = scanner.nextInt();

        switch (userInput){
            case 1:
                BalanceService.seeBalance();
                accessBalanceOrDeleteAccountMenu();
                break;
            case 2:
                AccountService.deleteAccount(accountNumber);
                System.out.println("Thank you for choosing us and hopefully you will come back.");
                break;
            case 3:
                MainMenu.displayMainMenu();
                break;
            case 4:
                BalanceService.updateExistingBalance();
                accessBalanceOrDeleteAccountMenu();
                break;

        }
    }
}
