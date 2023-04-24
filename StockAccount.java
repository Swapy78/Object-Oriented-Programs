// This code defines a class StockAccount for managing a stock portfolio

// and performing buy and sell operations, with support for saving and loading data.



package demo; 


import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.HashMap;

import java.util.Map;

import java.util.Scanner;


public class StockAccount {

// Define private instance variables to store the balance and the map of stocks.

private double balance;

private Map<String, Integer> stocks;

//Define a constructor that loads data from a file and initializes the instance variables.

public StockAccount(String filename) {

 stocks = new HashMap<>();

 try (Scanner scanner = new Scanner(new File(filename))) {

     balance = scanner.nextDouble();

     while (scanner.hasNext()) {

         String symbol = scanner.next();

         int shares = scanner.nextInt();

         stocks.put(symbol, shares);

     }

 } catch (FileNotFoundException e) {

     System.out.println("File not found: " + filename);

 }

}


//Define a method to calculate the total value of the account, including the balance and the value of all stocks.

public double valueOf() {

 double total = balance;

 for (Map.Entry<String, Integer> entry : stocks.entrySet()) {

     String symbol = entry.getKey();

     int shares = entry.getValue();

     double price = getPrice(symbol);

     total += shares * price;

 }

 return total;

}


//Define a method to buy a specified number of shares of a given stock, updating the balance and the stock map.

public void buy(int amount, String symbol) {

 double price = getPrice(symbol);

 double cost = amount * price;

 if (cost <= balance) {

     balance -= cost;

     int shares = stocks.getOrDefault(symbol, 0);

     shares += amount;

     stocks.put(symbol, shares);

     System.out.printf("Bought %d shares of %s at $%.2f each/n", amount, symbol, price);

 } else {

     System.out.println("Not enough balance to buy");

 }

}


//Define a method to sell a specified number of shares of a given stock, updating the balance and the stock map.

public void sell(int amount, String symbol) {

 double price = getPrice(symbol);

 int shares = stocks.getOrDefault(symbol, 0);

 if (shares >= amount) {

     shares -= amount;

     stocks.put(symbol, shares);

     double sale = amount * price;

     balance += sale;

     System.out.printf("Sold %d shares of %s at $%.2f each/n", amount, symbol, price);

 } else {

     System.out.println("Not enough shares to sell");

 }

}


//Define a method to print a report of the account, including the balance, total value, and the value of each stock.

public void printReport() {

 System.out.println("-------------------");

 System.out.printf("%-20s $%-9.2f/n", "Balance:", balance);

 System.out.printf("%-20s $%-9.2f/n", "Total value:", valueOf());

 System.out.println("-------------------");

 System.out.printf("%-10s %-10s %-10s %-10s/n", "Symbol", "Shares", "Price", "Value");

 for (Map.Entry<String, Integer> entry : stocks.entrySet()) {

     String symbol = entry.getKey();

     int shares = entry.getValue();

     double price = getPrice(symbol);

     double value = shares * price;

     System.out.printf("%-10s %-10d $%-9.2f $%-9.2f/n", symbol, shares, price, value);

 }}

    		 

    		// This method saves the current state of the account to a file

    		// It takes a filename as a parameter and writes the balance and stock information to the file

    		// If there is an error while writing to the file, it prints an error message to the console

    		public void save(String filename) {

    		try (PrintWriter writer = new PrintWriter(filename)) {

    		writer.println(balance);

    		for (Map.Entry<String, Integer> entry : stocks.entrySet()) {

    		writer.printf("%s %d/n", entry.getKey(), entry.getValue());

    		}

    		} catch (IOException e) {

    		System.out.println("Failed to save account to file: " + filename);

    		}

    		}


    		// This private method gets the current price of the stock with the given symbol

    		// It is used in the buy and sell methods to calculate the cost or sale value of the transaction

    		// In this implementation, it always returns a fixed value of 10.0

    		// This should be replaced with a real implementation that gets the current price from a stock market API or similar source

    		private double getPrice(String symbol) {

    		// assume this method gets the current price of the stock with the given symbol

    		return 10.0; // replace with real implementation

    		}

 }

