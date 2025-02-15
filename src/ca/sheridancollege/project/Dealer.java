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

import java.util.ArrayList;

public class Dealer extends Player {

    private ArrayList<BlackjackCard> cards;  // List to store dealer's cards

    public Dealer(String name) {
        super(name);  // Call the constructor of the Player class
        cards = new ArrayList<>();  // Initialize the cards list
    }

    // Method to receive a card and add it to the dealer's hand
    public void receiveCard(BlackjackCard card) {
        cards.add(card);
    }

    // Method to get the cards in the dealer's hand
    public ArrayList<BlackjackCard> getCards() {
        return cards;
    }

    @Override
    public int getHandValue() {
        int totalValue = 0;
        int aces = 0;

        for (BlackjackCard card : cards) {
            totalValue += card.getValue();
            if (card.getRank() == "Ace") {
                aces++;
            }
        }

        // Adjust for aces being worth 11 instead of 1 if needed
        while (totalValue > 21 && aces > 0) {
            totalValue -= 10;
            aces--;
        }

        return totalValue;
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
