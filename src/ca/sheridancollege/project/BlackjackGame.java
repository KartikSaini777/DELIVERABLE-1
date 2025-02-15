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
import java.util.Scanner;

public class BlackjackGame extends Game {

    private BlackjackDeck deck;  // Blackjack deck with 52 cards
    private Dealer dealer;

    public BlackjackGame(String name) {
        super(name);
        deck = new BlackjackDeck(); // Initialize deck with 52 cards
        dealer = new Dealer("Dealer");
    }

    @Override
    public void play() {
        System.out.println("Starting the game of Blackjack!\n");

        // Get number of players with input validation
        Scanner scanner = new Scanner(System.in);
        int numPlayers = -1;
        while (numPlayers <= 0) {
            System.out.print("Enter number of players: ");
            try {
                numPlayers = Integer.parseInt(scanner.nextLine());
                if (numPlayers <= 0) {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Create players dynamically and pass the deck
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String playerName = scanner.nextLine();
            Player player = new BlackjackPlayer(playerName, deck);  // Pass the deck to the player
            players.add(player);
            getPlayers().add(player);
        }

        // Shuffle and deal cards to players
        deck.shuffle();
        dealInitialCards();

        // Display initial hands for players and dealer
        for (Player player : getPlayers()) {
            player.displayHand();
        }
        System.out.println("Dealer's visible card: " + dealer.getCards().get(0));

        // Player's turn
        for (Player player : getPlayers()) {
            player.play();
        }

        // Dealer's turn
        dealerPlay();

        // Declare winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
        int dealerScore = dealer.getHandValue();
        System.out.println("Dealer's hand value: " + dealerScore);

        // Dealer bust check - dealer busts, all players win (unless busted)
        if (dealerScore > 21) {
            System.out.println("Dealer busts!");
            for (Player player : getPlayers()) {
                int playerScore = player.getHandValue();
                if (playerScore <= 21) {
                    System.out.println(player.getName() + " wins!");
                } else {
                    System.out.println(player.getName() + " busts!");
                }
            }
            return; // End game as dealer busts
        }

        // Dealer didn't bust, so compare with each player's score
        for (Player player : getPlayers()) {
            int playerScore = player.getHandValue();
            System.out.println(player.getName() + "'s hand value: " + playerScore);

            if (playerScore > 21) {
                System.out.println(player.getName() + " busts!");
            } else if (playerScore > dealerScore) {
                System.out.println(player.getName() + " wins!");
            } else if (playerScore < dealerScore) {
                System.out.println("Dealer wins!");
            } else {
                System.out.println("It's a tie!");
            }
        }
    }

    // Method to deal the initial two cards to players and dealer
    private void dealInitialCards() {
        // Deal cards to each player
        for (Player player : getPlayers()) {
            player.receiveCard(deck.dealCard()); // Deal first card
            player.receiveCard(deck.dealCard()); // Deal second card
        }

        // Deal cards to the dealer
        dealer.receiveCard(deck.dealCard()); // Dealer's first card (face down)
        BlackjackCard secondDealerCard = deck.dealCard(); // Dealer's second card
        dealer.receiveCard(secondDealerCard);
    }

    // Method to simulate the dealer's play
    private void dealerPlay() {
        System.out.println("Dealer's turn:");

        // Dealer must hit until reaching a hand value of 17 or higher
        while (dealer.getHandValue() < 17) {
            System.out.println("Dealer hits.");
            dealer.receiveCard(deck.dealCard());
            System.out.println("Dealer's hand value: " + dealer.getHandValue());
        }

        if (dealer.getHandValue() > 21) {
            System.out.println("Dealer busts!");
        } else {
            System.out.println("Dealer stands.");
        }
    }
}
