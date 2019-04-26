package com.appl.atm.view;

public class Screen {
   private static Screen screen = null;
   // display a message without a carriage return
   public void displayMessage(String message) {
      System.out.print(message); 
   } 

   // display a message with a carriage return
   public void displayMessageLine(String message) {
      System.out.println(message);   
   } 

   // displays a dollar amount
   public void displayDollarAmount(double amount) {
      System.out.printf("$%,.2f", amount);   
   }
   
   private Screen(){
       
   }
   
   public static Screen getInstance(){
       if(screen == null)
           screen = new Screen();
       
       return screen;
   }
} 