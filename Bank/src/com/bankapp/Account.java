package com.bankapp;

public abstract class Account {

	 private int accountNumber;
	    private String holderName;
	    protected double balance;

	    public Account(int accountNumber, String holderName, double balance) {
	        this.accountNumber = accountNumber;
	        this.holderName = holderName;
	        this.balance = balance;
	    }

	    public int getAccountNumber() {
	        return accountNumber;
	    }

	    public String getHolderName() {
	        return holderName;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    // Common method
	    public void deposit(double amount) {
	        balance += amount;
	        System.out.println("Deposited: " + amount);
	    }

	    
	    public abstract void withdraw(double amount);

	    public void display() {
	        System.out.println("Account No: " + accountNumber);
	        System.out.println("Holder Name: " + holderName);
	        System.out.println("Balance: " + balance);
	    }
}
