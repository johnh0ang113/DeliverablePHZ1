/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverablephz1;
import java.util.*;

/*
 * Purpose: Create a deck of 52 cards, deal hand
 * Date: September 4, 2025
 * @author Phat Hoang & Zubayr  & Alan
 */
public class Deck {
    private List<Card> cards;
    private Random random = new Random();
    
    public Deck(){
        cards = new ArrayList<>();
        
        //build 52 cards
        for (Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values()){
                cards.add(new Card(rank,suit));
            }
        }
        //shuffle the deck
        shuffle();
    }
    
    public void shuffle(){
        //Using collections util to randomly reorder the array
        Collections.shuffle(cards, random);
    }
    public Card dealCard(){
        //take top card
        return cards.remove(0);
    }
    
}
