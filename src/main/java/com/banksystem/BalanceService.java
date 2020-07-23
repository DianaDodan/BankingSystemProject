package com.banksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalanceService {
        static Map<String, Double> accountNumberToBalanceMap = new HashMap<>();
        static Scanner scanner = new Scanner(System.in);

        public static void seeBalance() {
            double balance = accountNumberToBalanceMap.get(LogInService.accountNumber);
            System.out.println(balance);
        }

        public static void updateExistingBalance() {
            double startingBalance = accountNumberToBalanceMap.get(LogInService.accountNumber);
            System.out.println("How much money would you like to add in your account?");
            double moneyAddedToAccount = scanner.nextDouble();
            double updatedBalance = startingBalance + moneyAddedToAccount;
            accountNumberToBalanceMap.put(LogInService.accountNumber, updatedBalance);
            System.out.println("This is your new balance: " + updatedBalance);
        }
}
