//Main class for Account.java


package demo;


public class Main {

    public static void main(String[] args) {

    	// creating a new account with an initial balance of 100.0

        Account account = new Account(100.0); 

        account.credit(50.0); // credited 50.0 to the account

        account.debit(25.0); // debited 25.0 from the account

     // printing the current balance of the account

        System.out.println("Current balance: " + account.getBalance()); 

    }

}

