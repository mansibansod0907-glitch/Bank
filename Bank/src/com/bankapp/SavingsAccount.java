package com.bankapp;

public class SavingsAccount extends Account {
	    private static final double MIN_BALANCE = 500;

	    public SavingsAccount(int accountNumber, String holderName, double balance) {
	        super(accountNumber, holderName, balance);
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (balance - amount >= MIN_BALANCE) {
	            balance -= amount;
	            System.out.println("Withdrawal successful from Savings Account");
	        } else {
	            System.out.println("Cannot withdraw. Minimum balance required: " + MIN_BALANCE);
	        }
	    }
	}

