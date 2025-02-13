/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class BlackjackDeck {

    private ArrayList<BlackjackCard> cards;

    public BlackjackDeck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        // Value mapping for face cards
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};  // Value for 2-10, J, Q, K, and Ace
        
        // Add each card to the deck
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                // Determine the value based on the card's rank
                int value = values[i];
                // Pass suit, rank, and value to the BlackjackCard constructor
                cards.add(new BlackjackCard(suit, ranks[i], value));  // Now we pass suit, rank, and value
            }
        }
        shuffle();
    }

    // Getter to return the cards in the deck
    public ArrayList<BlackjackCard> getCards() {
        return cards;
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deal one card from the deck
    public BlackjackCard dealCard() {
        if (cards.isEmpty()) {
            return null;  // Return null if the deck is empty
        }
        return cards.remove(0); // Deals the top card
    }
}
