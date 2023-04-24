//Main class for Player.java


package demo;


public class Main2{


public static void main(String[] args) {

    DeckOfCards deck = new DeckOfCards(); // creating a new DeckOfCards object

    deck.shuffle(); // shuffling the deck

    Player player = new Player(deck); // creating a new Player object

    player.sortByRank(); // sorting the cards by rank

    player.dealCards(); // dealing the cards to four players in a queue

    player.print(); // printing the cards held by each player

}

}
