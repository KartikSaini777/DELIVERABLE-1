/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

public class BlackjackCard extends Card {
    private int value; // Value of the card (e.g., 10 for "10", "J", "Q", "K", 11 for "A")
    private boolean isAce;  // Flag to indicate if the card is an Ace

    // Constructor that takes suit, rank, and value
    public BlackjackCard(String suit, String rank, int value) {
        super(suit, rank);  // Call the parent Card constructor
        this.isAce = rank.equals("A");  // Check if the card is an Ace
        this.value = value;  // Set value based on the passed value
    }

    // Method to adjust Ace value if necessary (when the total hand value exceeds 21)
    public void adjustAceValueIfNeeded(int handValue) {
        if (isAce && handValue > 21) {
            this.value = 1;  // Adjust Ace value to 1 if the hand value exceeds 21
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit() + " (Value: " + value + ")";
    }
}
