/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverablephz1;
import java.util.Scanner;

/*
 * Purpose: Hold the game logic, win/lose, add cards, add points
 * Date: September 4, 2025
 * @author Phat Hoang & Zubayr & Alan 
 */
public class GameLogic {
    //funtions to add points
    //Follows SRP
    public void updatePlayerScore(Player p, int points) {
    p.addScore(points);                  
}

    //functions to calculate values
    // Returns the total value of a player's hand
    //Follows SRP
    public int calculateHandValue(Player p) {
        return p.getHand().getValue();
    }
    // Returns true if the player has busted
    //Follows DRY
    public boolean isBusted(Player p) {
        return calculateHandValue(p) > 21;
    }
    // Returns true if the player has a BlackJack
    //Follows DRY
    public boolean isBlackJack(Player p) {
        return p.getHand().getValue() == 21 && p.getHand().getCards().size() == 2;
    }

    
    //function to game start => deal card to all players 2 times
    //                          gives player option to draw more cards?maybe
    public void gameStart() {
        
        Scanner sc = new Scanner(System.in);
        Deck deck = new Deck();

        Player player = new Player("Player");
        Player dealer = new Player("Dealer");

        System.out.println("Welcome to BlackJack");
        
        int rounds = 0;
        
        while(player.getScore() <= 2 && dealer.getScore() <= 2){
                rounds++;    
            
                System.out.println("ROUND " + rounds);
                // Deal 2 cards to player
                player.addCard(deck.dealCard());
                player.addCard(deck.dealCard());

                // Deal 2 cards to dealer
                dealer.addCard(deck.dealCard());
                dealer.addCard(deck.dealCard());
                   
                // Show hands (dealer second card hidden)
                System.out.println("\nPlayer's hand:");
                for (Card c : player.getHand().getCards()) {
                    System.out.println(c.getRank() + " of " + c.getSuit());
                }
                System.out.println("Total: " + player.getHand().getValue());

                System.out.println("\nDealer shows:");
                Card firstCard = dealer.getHand().getCards().get(0);
                System.out.println(firstCard.getRank() + " of " + firstCard.getSuit());
                System.out.println("Second card is hidden");

                // Player turn
                while (true) {
                    System.out.println("\nDo you want to hit or stand? (h/s)");
                    String choice = sc.nextLine().toLowerCase();

                    if (choice.equals("h")) {
                        Card newCard = deck.dealCard();
                        player.addCard(newCard);
                        System.out.println("You drew: " + newCard.getRank() + " of " + newCard.getSuit());
                        System.out.println("Total: " + player.getHand().getValue());

                        if (player.getHand().getValue() > 21) {
                            System.out.println("You busted!");
                            break;
                        }

                    } else if (choice.equals("s")) {
                        break;
                    } else {
                        System.out.println("Invalid input! Please type 'h' or 's'.");
                    }
                }

                // Dealer turn
                System.out.println("\nDealer's hand:");
                for (Card c : dealer.getHand().getCards()) {
                    System.out.println(c.getRank() + " of " + c.getSuit());
                }

                while (dealer.getHand().getValue() < 17) {
                    Card newCard = deck.dealCard();
                    dealer.addCard(newCard);
                    System.out.println("Dealer draws: " + newCard.getRank() + " of " + newCard.getSuit());
                }

                System.out.println("\nFinal Results:");
                System.out.println("Player total: " + player.getHand().getValue());
                System.out.println("Dealer total: " + dealer.getHand().getValue());

                // Determine winner
               if (isBusted(player)) {
                System.out.println("Dealer wins!");
                updatePlayerScore(dealer,1);
            } else if (isBusted(dealer) || calculateHandValue(player) > calculateHandValue(dealer)) {
                System.out.println("Player wins!");
                updatePlayerScore(player,1);
            } else if (calculateHandValue(player) < calculateHandValue(dealer)) {
                System.out.println("Dealer wins!");
                updatePlayerScore(dealer,1);
            } else {
                System.out.println("It's a tie!");
            }
               
            
               
            System.out.println("\nCURRENT SCORES ARE:\tPLAYER SCORE: " + player.getScore() + "\tDEALER SCORE: "+dealer.getScore() + 
                    "\nPress enter to Continue...");
            
            player.clearHand();
            dealer.clearHand();
            
            
            String choice = sc.nextLine().toLowerCase();
            
        }
        
        
    
    
    
    
   
   

}

}
