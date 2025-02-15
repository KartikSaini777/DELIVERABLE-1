/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 */
/**
 * Blackjack Game Implementation
 * Created by: Kartik Saini, Jaskaran, Shahzaib Hassan
 * Date: February 14, 2025
 * Course: SYST 17796
 */

package ca.sheridancollege.project;

import java.util.Scanner;

public class BlackjackPlayer extends Player {

    private GroupOfCards hand;
    private BlackjackDeck deck; // Declare the deck variable

    public BlackjackPlayer(String name, BlackjackDeck deck) {
        super(name);
        this.deck = deck;  // Initialize deck from the game
        hand = new GroupOfCards(10); // Maximum 10 cards in hand
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);  // Initialize the scanner once
        boolean keepPlaying = true;

        System.out.println(getName() + "'s turn:");

        // Initial two cards dealt to the player
        for (int i = 0; i < 2; i++) {
            BlackjackCard card = (BlackjackCard) deck.dealCard(); // Dealing a card
            hand.receiveCard(card); 
        }

        // Display initial hand
        displayHand();
        System.out.println("Your hand value: " + getHandValue());

        while (keepPlaying) {
            System.out.print("Do you want to (h)it or (s)tand? ");
            String decision = scanner.nextLine().toLowerCase();

            if (decision.equals("h")) {
                // Player hits, receives another card
                BlackjackCard card = (BlackjackCard) deck.dealCard(); // Directly using BlackjackCard
                hand.receiveCard(card); 
                System.out.println(getName() + " drew: "  + card);
                displayHand();
                System.out.println(getName() + "'s hand value: " + getHandValue());

                if (getHandValue() > 21) {
                    System.out.println("You busted!");
                    break;
                }
            } else if (decision.equals("s")) {
                // Player stands
                System.out.println(getName() + " stands.");
                break;
            }
        }
    }

    // Method to calculate the value of the hand
    public int getHandValue() {
        int value = 0;
        for (BlackjackCard card : hand.getCards()) {
            value += card.getValue();  // Use BlackjackCard's getValue()
        }

        // Adjust Ace value if necessary (if total exceeds 21)
        for (BlackjackCard card : hand.getCards()) {
            card.adjustAceValueIfNeeded(value);  // Handle Ace adjustment inside card class
        }

        return value;
    }

    // Method to receive a card
    public void receiveCard(BlackjackCard card) {
        hand.receiveCard(card); // Add the card to the hand
    }

    // Method to display the hand's cards
    public void displayHand() {
        if (hand.getCards().isEmpty()) {
            System.out.println("Hand is empty.");
        } else {
            // Explicitly calling the toString method of GroupOfCards
            System.out.println(getName() + "'s cards: " + hand.toString()); // hand.toString() ensures proper display
        }
    }
}
