package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.*;

import com.bankapp.*;

public class BankService {
	
	public void addAccount(Account acc) {
	    try {
	        Connection con = ConnectionDb.getConnection();

	        String sql = "INSERT INTO accounts VALUES (?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, acc.getAccountNumber());
	        ps.setString(2, acc.getHolderName());
	        ps.setDouble(3, acc.getBalance());

	        if (acc instanceof SavingsAccount)
	            ps.setString(4, "SAVINGS");
	        else
	            ps.setString(4, "CURRENT");

	        ps.executeUpdate();
	        System.out.println("Account saved to DB!");

	        con.close();
	    } catch (Exception e) {
	        System.out.println("Error while adding account");
	        e.printStackTrace();
	    }
	}
	
	public Account findAccount(int accNo) {
	    Account acc = null;

	    try {
	        Connection con = ConnectionDb.getConnection();

	        String sql = "SELECT * FROM accounts WHERE account_number=?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, accNo);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            String name = rs.getString("holder_name");
	            double bal = rs.getDouble("balance");
	            String type = rs.getString("account_type");

	            if (type.equals("SAVINGS"))
	                acc = new SavingsAccount(accNo, name, bal);
	            else
	                acc = new CurrentAccount(accNo, name, bal);
	        }

	        con.close();

	    } catch (Exception e) {
	        System.out.println("Error finding account");
	        e.printStackTrace();
	    }

	    return acc;
	}
    
	public void updateBalance(Account acc) {
	    try {
	        Connection con = ConnectionDb.getConnection();

	        String sql = "UPDATE accounts SET balance=? WHERE account_number=?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setDouble(1, acc.getBalance());
	        ps.setInt(2, acc.getAccountNumber());

	        ps.executeUpdate();
	        con.close();

	    } catch (Exception e) {
	        System.out.println("Error updating balance");
	        e.printStackTrace();
	    }
	}

	public void showAllAccounts() {
	    try {
	        Connection con = ConnectionDb.getConnection();

	        String sql = "SELECT * FROM accounts";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            System.out.println("---------------------");
	            System.out.println("Acc No: " + rs.getInt("account_number"));
	            System.out.println("Name: " + rs.getString("holder_name"));
	            System.out.println("Balance: " + rs.getDouble("balance"));
	            System.out.println("Type: " + rs.getString("account_type"));
	        }

	        con.close();

	    } catch (Exception e) {
	        System.out.println("Error displaying accounts");
	        e.printStackTrace();
	    }
	}
}
