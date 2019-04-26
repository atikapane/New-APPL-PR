package com.appl.atm.view;

import java.util.Scanner;

public class Keypad {
   private static Keypad keypad = null;
   private Scanner input; // reads data from the command line
                         
   private Keypad() {
      input = new Scanner(System.in);    
   } 

   public int getInput() {
      return input.nextInt(); // user enters an integer
   } 
   
   public static Keypad getInstance(){
       if(keypad == null)
            keypad = new Keypad();
       
       return keypad;
   }
   
} 