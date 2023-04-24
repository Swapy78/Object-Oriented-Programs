/*

 * Java program to create a Player Object having Deck of Cards, and

 *having ability to Sort by Rank and maintain the cards in a Queue implemented

  using Linked List.

  */


package demo;


import java.util.ArrayList;

import java.util.LinkedList;

import java.util.List;

import java.util.Queue;


public class Player {

    private DeckOfCards deck;

    private String[] cards;

    private List<Queue<String>> players;


    public Player(DeckOfCards deck) {

        this.deck = deck;

        this.cards = this.deck.getDeck();

    }


    // Method to sort the cards by rank

    public void sortByRank() {

        for (int i = 0; i < cards.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < cards.length; j++) {

                if (compareCards(cards[j], cards[minIndex]) < 0) {

                    minIndex = j;

                }

            }

            String temp = cards[i];

            cards[i] = cards[minIndex];

            cards[minIndex] = temp;

        }

    }


    // Method to deal the cards to four players in a queue

    public void dealCards() {

        players = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            players.add(new LinkedList<>());

        }

        int count = 0;

        for (int i = 0; i < 4; i++) {

            Queue<String> player = players.get(i);

            for (int j = 0; j < 9; j++) {

                player.add(cards[count]);

                count++;

            }

        }

    }


    // Method to print the cards received by each player

    public void print() {

        for (int i = 0; i < players.size(); i++) {

            System.out.println("Player " + (i+1) + ":");

            Queue<String> player = players.get(i);

            for (String card : player) {

                System.out.println(card);

            }

            System.out.println();

        }

    }


    // Method to compare two cards based on their rank

    private int compareCards(String card1, String card2) {

        String rank1 = card1.split(" ")[0];

        String rank2 = card2.split(" ")[0];

        if (rank1.equals("Ace")) {

            return 1;

        } else if (rank2.equals("Ace")) {

            return -1;

        } else {

            return Integer.compare(getRankValue(rank1), getRankValue(rank2));

        }

    }


    // Method to get the value of a card's rank

    private int getRankValue(String rank) {

        switch (rank) {

            case "2":

                return 2;

            case "3":

                return 3;

            case "4":

                return 4;

            case "5":

                return 5;

            case "6":

                return 6;

            case "7":

                return 7;

            case "8":

                return 8;

            case "9":

                return 9;

            default:

                return 10;

        }

    }

}

