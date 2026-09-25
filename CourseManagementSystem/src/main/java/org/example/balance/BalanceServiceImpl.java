package org.example.balance;

import org.example.model.User;

public class BalanceServiceImpl implements BalanceService {

    @Override
    public void showBalance(User user) {
        System.out.println(
                "Your balance: " + user.getBalance() + " AZN"
        );
    }

    @Override
    public void addBalance(User user, double amount) {

        if (amount <= 0) {
            System.out.println(
                    "The amount must be greater than 0!"
            );
            return;
        }

        user.addBalance(amount);

        System.out.println(
                amount + " AZN has been added to your balance."
        );
    }
}