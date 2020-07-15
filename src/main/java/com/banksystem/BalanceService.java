package com.banksystem;

import java.util.HashMap;
import java.util.Map;

public class BalanceService {
        static Map<String, Double> accountNumberToBalanceMap = new HashMap<>();

        public static double seeBalance() {
              double balance = accountNumberToBalanceMap.get(LogInService.compareUserInputsWithExistingData());
              System.out.println(balance);
              return balance;
        }
}
