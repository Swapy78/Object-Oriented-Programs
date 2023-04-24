//Java program to read in Stock Names, Number of Share, Share Price.


package demo;


//Import Scanner class to read input from user

import java.util.Scanner;


//Define Stock class to store stock data

	class Stock {

		private String name; // Declare private field for stock name

		private int numShares; // Declare private field for number of shares

		private double sharePrice; // Declare private field for share price


//Constructor for Stock class to set stock data

		public Stock(String name, int numShares, double sharePrice) {

			this.name = name; // Set stock name

			this.numShares = numShares; // Set number of shares

			this.sharePrice = sharePrice; // Set share price

}


//Method to calculate the total value of the stock

		public double calculateValue() {

			return numShares * sharePrice; // Return total value of the stock

}


//Getter method to get the name of the stock

		public String getName() {

			return name; // Return the name of the stock

}


//Getter method to get the number of shares of the stock

		public int getNumShares() {

			return numShares; // Return the number of shares of the stock

}


//Getter method to get the share price of the stock

		public double getSharePrice() {

			return sharePrice; // Return the share price of the stock

}


}

//Define StockPortfolio class to store an array of stocks

class StockPortfolio {

	private Stock[] stocks; // Declare private field for an array of stocks


//Constructor for StockPortfolio class to set array of stocks

public StockPortfolio(Stock[] stocks) {

	this.stocks = stocks; // Set array of stocks

}


//Method to calculate the total value of all the stocks in the portfolio

public double calculateTotalValue() {

	double totalValue = 0; // Declare and initialize total value to zero

	for (int i = 0; i < stocks.length; i++) { // Loop through each stock in the portfolio

     Stock stock = stocks[i]; // Get current stock

     // Calculate total value of current stock and add to total value of portfolio

     totalValue += stock.calculateValue();

 }

 return totalValue; // Return total value of portfolio

}


//Method to print the stock report

public void printReport() {

 System.out.println("Stock Report"); // Print header for stock report

 System.out.println("------------"); // Print separator for header


 for (Stock stock : stocks) { // Loop through each stock in the portfolio

     System.out.println("Name: " + stock.getName()); // Print stock name

     System.out.println("Number of Shares: " + stock.getNumShares()); // Print number of shares of the stock

     System.out.println("Share Price: " + stock.getSharePrice()); // Print share price of the stock

     System.out.println("Total Value: " + stock.calculateValue()); // Print total value of the stock

     System.out.println(); // Print blank line for readability

 }


 System.out.println("Total Portfolio Value: " + calculateTotalValue()); // Print total value of the portfolio

}


}


//Define main class for stock account management

public class StockAccountManagement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // Create a Scanner object to read input from user


		System.out.print("Enter the number of stocks: "); // Prompt user to enter the number of stocks

		int numStocks = sc.nextInt(); // Read number of stocks from user


		Stock[] stocks = new Stock[numStocks]; // Create an array of stocks with given number of stocks


//Loops through the array of stocks, prompting the user to enter information about each stock

        for (int i = 0; i < numStocks; i++) {

            System.out.print("Enter the name of stock " + (i + 1) + ": ");

            String name = sc.next();


            System.out.print("Enter the number of shares: ");

            int numShares = sc.nextInt();


            System.out.print("Enter the share price: ");

            double sharePrice = sc.nextDouble();

         // Creates a new Stock object based on the user input and adds it to the array of stocks

            stocks[i] = new Stock(name, numShares, sharePrice);

        }

     // Creates a new StockPortfolio object based on the array of stocks and prints a report

        StockPortfolio portfolio = new StockPortfolio(stocks);

        portfolio.printReport();


        // Closes the Scanner object

        sc.close();

}

}

