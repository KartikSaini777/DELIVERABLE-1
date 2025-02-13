/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public abstract class Card {

    private String suit;  // The suit of the card (e.g., Hearts, Spades, etc.)
    private String rank;  // The rank of the card (e.g., 2, 3, J, A, etc.)

    /**
     * Constructor to initialize the suit and rank of the card.
     * 
     * @param suit The suit of the card.
     * @param rank The rank of the card.
     */
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * @return The suit of the card.
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @return The rank of the card.
     */
    public String getRank() {
        return rank;
    }

    /**
     * Abstract method to get the value of the card, which must be implemented in child classes.
     * 
     * @return The value of the card.
     */
    public abstract int getValue();

    /**
     * Abstract method to return a string representation of the card.
     * 
     * @return The string representation of the card.
     */
    @Override
    public abstract String toString();
}
