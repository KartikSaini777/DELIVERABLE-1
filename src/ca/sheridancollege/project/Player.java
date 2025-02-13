/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

public abstract class Player {

    private String name; // The unique name for this player
    private ArrayList<BlackjackCard> hand; // The player's hand (list of cards)

    /**
     * Constructor to initialize the player with a unique name.
     *
     * @param name the unique name to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * Gets the player's name.
     *
     * @return the player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the player's name.
     *
     * @param name the name to set for the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a card to the player's hand.
     *
     * @param card the card to add to the hand.
     */
    public void receiveCard(BlackjackCard card) {
        hand.add(card);
        System.out.println(name + " receives: " + card);  // Logs the card received
    }

    /**
     * Calculates the total value of the player's hand.
     * Aces are counted as 11 initially, and adjusted to 1 if the total value exceeds 21.
     *
     * @return the total value of the player's hand.
     */
    public int getHandValue() {
        int totalValue = 0;
        int aceCount = 0; // Track number of aces in the hand

        // Sum the values of the cards
        for (BlackjackCard card : hand) {
            totalValue += card.getValue();
            if (card.getRank().equals("A")) {
                aceCount++; // Increment ace count
            }
        }

        // Adjust for aces: if totalValue is greater than 21 and we have aces, make them worth 1 instead of 11
        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10; // Convert an Ace from 11 to 1
            aceCount--;
        }

        return totalValue;
    }

    /**
     * Displays the player's hand and the total value.
     */
    public void displayHand() {
        System.out.println(name + "'s cards:");
        for (BlackjackCard card : hand) {
            System.out.println(card); // Print each card
        }
        System.out.println("Hand value: " + getHandValue());
    }

    /**
     * Abstract method to be overridden by subclasses with the specific logic for playing the game.
     */
    public abstract void play();
}
