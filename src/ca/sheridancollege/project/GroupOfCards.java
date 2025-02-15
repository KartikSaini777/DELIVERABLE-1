/**
 * Blackjack Game Implementation
 * Created by: Kartik Saini, Jaskaran, Shahzaib Hassan
 * Date: February 14, 2025
 * Course: SYST 17796
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCards {

    private List<BlackjackCard> cards; // List of Blackjack cards in the hand
    private int maxSize; // Maximum number of cards allowed in the hand

    // Constructor to initialize the list of cards with a max size
    public GroupOfCards(int maxSize) {
        this.cards = new ArrayList<>();
        this.maxSize = maxSize;
    }

    // Method to receive a new card
    public void receiveCard(BlackjackCard card) {
        if (cards.size() < maxSize) {
            cards.add(card); // Add card to hand if under max size
            
        } else {
            System.out.println("Cannot receive more cards. Hand is full.");
        }
    }

    // Get the list of cards
    public List<BlackjackCard> getCards() {
        return cards;
    }

    // Custom toString to format the hand for easier reading
    @Override
    public String toString() {
        if (cards.isEmpty()) {
            return "No cards in hand."; // Return message if the hand is empty
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i).toString());
            if (i < cards.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    // Method to calculate the total value of the hand
    public int calculateHandValue() {
        int totalValue = 0;
        int numAces = 0;

        // Sum up the values of each card
        for (BlackjackCard card : cards) {
            totalValue += card.getValue();

            // Count the aces to handle their special case later
            if (card.getRank().equals("Ace")) {
                numAces++;
            }
        }

        // Adjust the value of Aces (Ace can be 1 or 11)
        while (numAces > 0 && totalValue <= 11) {
            totalValue += 10; // Treat Ace as 11
            numAces--;
        }

        return totalValue;
    }

    // Optionally, add a method to clear the hand if needed
    public void clearHand() {
        cards.clear();
        System.out.println("Hand cleared.");
    }

    // Optionally, check if the hand is full
    public boolean isFull() {
        return cards.size() >= maxSize;
    }

    // Optionally, get the current number of cards in the hand
    public int getCardCount() {
        return cards.size();
    }
}
