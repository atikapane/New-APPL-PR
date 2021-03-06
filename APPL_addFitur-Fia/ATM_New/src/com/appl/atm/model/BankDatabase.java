/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import java.util.ArrayList;

/**
 *
 * @author Annazar
 */
public class BankDatabase {

    private ArrayList<Account> accounts; // array of Accounts
    private ArrayList<Integer> accountBlocked;
    
    public BankDatabase() {
        accounts = new ArrayList<Account>();
        accountBlocked = new ArrayList<Integer>();
        
        accounts.add(new Admin(00000, 00000, 0.0, 0.0));
        accounts.add(new AccountBussiness(1234, 4321, 10000.0, 12000.0));
        accounts.add(new AccountStudent(8765, 5678, 200.0, 200.0));
        accounts.add(new AccountBussiness(6665, 1234, 111700.0, 111900.0));
        accounts.add(new AccountMasaDepan(6666, 1234, 1700.0, 1900.0));
    }

    public Account getAccount(int accountNumber) {
        int i;
        for (i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                return accounts.get(i);
            }
        }
        return null; // if no matching account was found, return null
    }

    public Account getSpecificAccount(int userAccountNumber, int userPIN) {
        Account userAccount = getAccount(userAccountNumber);

        if (userAccount != null && userAccount.validatePIN(userPIN) && !userAccount.isUserBlocked()) {
            return userAccount;
        } else {
            return null; // account number not found, so return false
        }
    }

    public boolean authenticateAdmin(int userAccountNumber, int userPIN) {
        // attempt to retrieve the account with the account number
        Account userAccount = getAccount(userAccountNumber);

//      if account exists, return result of Account method validatePIN
        if (userAccount != null) {
            return (userAccount.validatePIN(userPIN) && getAccount(userAccountNumber).getAccountType().equals("Admin"));
        } else {
            return false; // account number not found, so return false
        }
    }

    public boolean authenticateUser(int userAccountNumber, int userPIN) {
        // attempt to retrieve the account with the account number
        Account userAccount = getAccount(userAccountNumber);

//      if account exists, return result of Account method validatePIN
        if (userAccount != null && !userAccount.isUserBlocked()) {
            return userAccount.validatePIN(userPIN);
        } else {
            return false; // account number not found, so return false
        }
    }

    public boolean isUserExist(int userAccountNumber) {
        return getAccount(userAccountNumber) != null;
    }

    public boolean checkAvail(int accountNumber) {
        int ak;
        for (ak = 0; ak < accounts.size(); ak++) {
            if (accountNumber == accounts.get(ak).getAccountNumber()) {
                return false;
            }
        }
        return true;
    }

    public void incAccount(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance, int theAccountType) {
        switch (theAccountType) {
            case 1:
                accounts.add(new AccountBussiness(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance));
                break;
            case 2:
                accounts.add(new AccountStudent(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance));
                break;
            case 3:
                accounts.add(new AccountMasaDepan(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance));
                break;

        }
    }

    public void blockAccount(int noAkun) {
        getAccountBlocked().add(noAkun);

        for (int i = 0; i < (int) accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == noAkun) {
                accounts.get(i).blockUser();
                return;
            }
        }
    }
    
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public ArrayList<Integer> getAccountBlocked() {
        return accountBlocked;
    }
}
