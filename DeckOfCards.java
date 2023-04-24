//Java program to initialize deck of cards and distribute them between players


package demo;


import java.util.*;


public class DeckOfCards {

    private String[] deck; // array to hold the deck of cards

    

    // Constructor to initialize the deck of cards

    public DeckOfCards() {

        deck = new String[52]; // creating an array with 52 elements

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"}; // array of suits

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; // array of ranks


        int count = 0;

        // looping through each suit and rank to create the deck of cards

        for (int i = 0; i < suits.length; i++) {

            for (int j = 0; j < ranks.length; j++) {

            	// creating card and add to deck array

                deck[count] = ranks[j] + " of " + suits[i]; 

                count++; // incrementing the counter

            }

        }

    }


    // Method to shuffle the deck of cards

    public void shuffle() {

        Random random = new Random(); // creating a new Random object

        for (int i = 0; i < deck.length; i++) {

        	// generating a random index to swap with

            int j = random.nextInt(deck.length); 

         // storing the current card in a temporary variable

            String temp = deck[i];

         // swapping the current card with the randomly selected card

            deck[i] = deck[j]; 

// storing the original current card in the randomly selected card's position

            deck[j] = temp; 

        }

    }


    // Method to deal the cards to four players

    public String[][] deal() {

    	// creating a 2D array to hold the players' cards

        String[][] players = new String[4][9]; 

        for (int i = 0; i < 4; i++) { // looping through each player

            for (int j = 0; j < 9; j++) { // looping through each card to deal

            	// dealing a card to the current player

                players[i][j] = deck[i*9 + j]; 

            }

        }

        return players; // returning the 2D array of players' cards

    }


    // Method to print the cards held by each player

    public void print(String[][] players) {

        for (int i = 0; i < 4; i++) { // looping through each player

            System.out.println("Player " + (i+1) + ":"); // printing the player number

            for (int j = 0; j < 9; j++) { // looping through each card held by the player

                System.out.println(players[i][j]); // printing the card

            }

            System.out.println(); // printing a blank line to separate each player's cards

        }

    }


    // Main method to run the program

    public static void main(String[] args) {

    	// creating a new DeckOfCards object

        DeckOfCards deck = new DeckOfCards(); 

        deck.shuffle(); // shuffling the deck

        String[][] players = deck.deal(); // dealing the cards to four players

        deck.print(players); // printing the cards held by each player

    }


	public String[] getDeck() {

		// TODO Auto-generated method stub

		return deck;

	}

}

