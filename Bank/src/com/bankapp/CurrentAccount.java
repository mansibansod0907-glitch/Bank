package com.bankapp;

public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 1000;

    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + OVERDRAFT_LIMIT >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful from Current Account");
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}
