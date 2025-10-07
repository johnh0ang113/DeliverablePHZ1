/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverablephz1;
import java.util.*;

/*
 * Purpose: Have Player hands from 2 cards
 * Date: September 4, 2025
 * @author Phat Hoang & Zubayr & Alan
 */
public class Hand {
    private List<Card> cards;
    
    public Hand(){
        cards = new ArrayList<>();
    }
    
    //add and getters
    public void addCard(Card card){
        cards.add(card);
    }
    public List<Card> getCards(){
        return cards;
    }
    
    //calculate for total Value
    public int getValue(){
        int total = 0;
        
        for (Card c : cards){
            total += c.getRank().getValue();
        }
        return total;
    }
}
