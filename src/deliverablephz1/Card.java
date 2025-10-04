/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverablephz1;

/*
 * Purpose: Hold enums of cards
 * Date: September 4, 2025
 * @author Phat Hoang & Zubayr
 */
public class Card {
    public enum Suit{HEARTS, DIAMONDS, CLUBS, SPADES}
    public enum Rank{
    ACE(1), TWO(2), THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9)
    ,TEN(10),JACK(10),QUEEN(10),KING(10);
    
    //To get the value from rank J,Q,K = 10
    private final int value;
    Rank (int value) 
    {this.value = value;}
    public int getValue()
    {return this.value;}
    }//end enum
    
    private Rank rank;
    private Suit suit;
    
    //constructor
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    //getter
    public Rank getRank(){return this.rank;}
    public Suit getSuit(){return this.suit;}
       
}
