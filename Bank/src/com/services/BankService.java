package com.services;

import java.util.ArrayList;

import com.bankapp.Account;

public class BankService {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account acc) {
        accounts.add(acc);
        System.out.println("Account added successfully!");
    }

    public Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }

    public void showAllAccounts() {
        for (Account acc : accounts) {
            System.out.println("-------------------");
            acc.display();
        }
    }
}
