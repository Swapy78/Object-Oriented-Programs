//Main class for StockAccount.java


// Import necessary libraries

package demo;

import java.io.FileNotFoundException;

import java.util.*;


// Class containing the main method

public class Main1 {

	

	// Main method

	public static void main(String[] args) throws FileNotFoundException {

	    

	    // Create a Scanner object for user input

	    Scanner scanner = new Scanner(System.in);

	    

	    // Prompt user to enter file name to load account

	    System.out.print("Enter file name to load account: ");

	    String filename = scanner.nextLine();

	    

	    // Create a new StockAccount object using the specified file name

	    StockAccount account = new StockAccount(filename);

	    

	    // Loop until the user chooses to exit

	    boolean done = false;

	    while (!done) {

	        

	        // Display menu options

	        System.out.println();

	        System.out.println("1. Buy shares");

	        System.out.println("2. Sell shares");

	        System.out.println("3. Print report");

	        System.out.println("4. Save account to file");

	        System.out.println("5. Exit");

	        System.out.print("Enter choice: ");

	        

	        // Get user choice

	        int choice = scanner.nextInt();

	        scanner.nextLine(); // consume newline

	        

	        // Process user choice

	        switch (choice) {

	            

	            // Buy shares

	            case 1:

	                System.out.print("Enter amount to buy: ");

	                int amount = scanner.nextInt();

	                scanner.nextLine(); // consume newline

	                System.out.print("Enter stock symbol: ");

	                String symbol = scanner.nextLine();

	                account.buy(amount, symbol);

	                break;

	            

	            // Sell shares

	            case 2:

	                System.out.print("Enter amount to sell: ");

	                amount = scanner.nextInt();

	                scanner.nextLine(); // consume newline

	                System.out.print("Enter stock symbol: ");

	                symbol = scanner.nextLine();

	                account.sell(amount, symbol);

	                break;

	            

	            // Print report

	            case 3:

	                account.printReport();

	                break;

	            

	            // Save account to file

	            case 4:

	                System.out.print("Enter file name to save account: ");

	                filename = scanner.nextLine();

	                account.save(filename);

	                break;

	            

	            // Exit

	            case 5:

	                done = true;

	                break;

	            

	            // Invalid choice

	            default:

	                System.out.println("Invalid choice");

	                break;

	        }

	    }

	    

	    // Close the Scanner object

	    scanner.close();

	}


}
