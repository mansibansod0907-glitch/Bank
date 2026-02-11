package com.main;

import java.util.Scanner;
import com.bankapp.Account;
import com.bankapp.CurrentAccount;
import com.bankapp.SavingsAccount;
import com.services.BankService;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while (true) {
            try {
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
                        int sAccNo = sc.nextInt();
                        String sName = sc.next();
                        double sBal = sc.nextDouble();
                        bank.addAccount(new SavingsAccount(sAccNo, sName, sBal));
                        break;

                    case 2:
                        System.out.print("Enter Acc No, Name, Balance: ");
                        int cAccNo = sc.nextInt();
                        String cName = sc.next();
                        double cBal = sc.nextDouble();
                        bank.addAccount(new CurrentAccount(cAccNo, cName, cBal));
                        break;

                    case 3:
                        System.out.print("Enter Acc No & Amount: ");
                        int dAccNo = sc.nextInt();
                        double dAmt = sc.nextDouble();

                        Account acc1 = bank.findAccount(dAccNo);
                        if (acc1 != null) {
                            acc1.deposit(dAmt);
                            bank.updateBalance(acc1);
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Acc No & Amount: ");
                        int wAccNo = sc.nextInt();
                        double wAmt = sc.nextDouble();

                        Account acc2 = bank.findAccount(wAccNo);
                        if (acc2 != null) {
                            acc2.withdraw(wAmt);
                            bank.updateBalance(acc2);
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 5:
                        bank.showAllAccounts();
                        break;

                    case 6:
                        System.out.println("Thank you!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Invalid input or system error. Try again.");
                sc.nextLine(); // clear wrong input
            }
        }
    }
}