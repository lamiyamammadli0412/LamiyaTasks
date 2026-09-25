package org.example.balance;

import org.example.model.User;

public interface BalanceService {

    void showBalance(User user);

    void addBalance(User user, double amount);
}