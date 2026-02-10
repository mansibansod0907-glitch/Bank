package com.main;

import java.util.Scanner;

import com.bankapp.Account;
import com.bankapp.CurrentAccount;
import com.bankapp.SavingsAccount;
import com.services.BankService;

public class BankApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while (true) {
            System.out.println("\n1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Acc No, Name, Balance: ");
                    bank.addAccount(new SavingsAccount(sc.nextInt(), sc.next(), sc.nextDouble()));
                    break;

                case 2:
                    System.out.print("Enter Acc No, Name, Balance: ");
                    bank.addAccount(new CurrentAccount(sc.nextInt(), sc.next(), sc.nextDouble()));
                    break;

                case 3:
                    System.out.print("Enter Acc No & Amount: ");
                    int dAccNo = sc.nextInt();
                    double dAmt = sc.nextDouble();

                    Account acc1 = bank.findAccount(dAccNo);
                    if (acc1 != null) {
                        acc1.deposit(dAmt);
                        bank.updateBalance(acc1);   // SAVE TO DB
                    } else System.out.println("Account not found!");
                    break;

                case 4:
                    System.out.print("Enter Acc No & Amount: ");
                    int wAccNo = sc.nextInt();
                    double wAmt = sc.nextDouble();

                    Account acc2 = bank.findAccount(wAccNo);
                    if (acc2 != null) {
                        acc2.withdraw(wAmt);        // polymorphism
                        bank.updateBalance(acc2);   // SAVE TO DB
                    } else System.out.println("Account not found!");
                    break;

                case 5:
                    bank.showAllAccounts();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }
}