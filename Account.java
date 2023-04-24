//Java program for debit-credit


package demo;


public class Account {

    private double balance; // account balance


    public Account(double initialBalance) {

    	// initializing account balance with given initial balance

        balance = initialBalance; 

    }


    public void credit(double amount) {

        balance += amount; // adding given amount to account balance

    }


    public void debit(double amount) {

    	// if debit amount is greater than account balance

        if (amount > balance) { 

        	// printing error message

            System.out.println("Debit amount exceeded account balance."); 

        } else {

            balance -= amount; // subtracting given amount from account balance

        }

    }


    public double getBalance() {

        return balance; // returning account balance

    }

}

