package com.banksystem;

import java.util.Scanner;

public class MainMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            System.out.println("Welcome to Puma Bank! What would you like to do today?");
            System.out.println("1. Create a new account.");
            System.out.println("2. Log in into an existing account.");
            System.out.println("3. Exit.");

            int optionSelectedByUser = scanner.nextInt();

            switch (optionSelectedByUser) {
                case 1:
                    AccountService.createAccount();
                    break;
                case 2:
                    LogInService.compareUserInputsWithExistingData();
                    break;
                case 3:
                    System.out.println("Thank you for using the Puma Bank!");
                    return;
            }
        }
    }


}
