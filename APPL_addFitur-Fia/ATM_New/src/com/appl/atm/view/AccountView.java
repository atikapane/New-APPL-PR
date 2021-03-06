/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.view;

/**
 *
 * @author ACER
 */
public class AccountView {

    private Screen screen = new Screen(); // ATM's screen
    private Keypad keypad = new Keypad();

    public int displayMainMenu() {
        screen.displayMessageLine("\nMain menu:");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Transfer");
        screen.displayMessageLine("5 - Change PIN");
        screen.displayMessageLine("6 - Bank Statement");
        screen.displayMessageLine("0 - Exit\n");
        screen.displayMessage("Enter a choice: ");

        return keypad.getInput(); // return user's selection
    }

    public int displayWithdrawalMenu(int amounts[]) {
        screen.displayMessageLine("\nWithdrawal Menu:");
        for (int i = 0; i < amounts.length - 1; i++) {
            screen.displayMessageLine((i + 1) + " - $" + amounts[i + 1]);
        }
        screen.displayMessageLine(amounts.length + " - Another amount");
        screen.displayMessageLine((amounts.length + 1) + " - Cancel transaction");
        screen.displayMessage("\nChoose a withdrawal amount: ");

        return keypad.getInput(); // get user input through keypad   
    }

    public int displayTransferMenu(int amounts[]) {
        screen.displayMessageLine("\nTransfer Menu:");
        for (int i = 0; i < amounts.length - 1; i++) {
            screen.displayMessageLine((i + 1) + " - $" + amounts[i + 1]);
        }
        screen.displayMessageLine(amounts.length + " - Another amount");
        screen.displayMessageLine((amounts.length + 1) + " - Cancel transaction");
        screen.displayMessage("\nChoose a transfer amount: ");

        return keypad.getInput(); // get user input through keypad   
    }
    
    public int transferAskReceiverAccount() {
        screen.displayMessage("\nEnter the destination number: ");

        return keypad.getInput();
    }
}
