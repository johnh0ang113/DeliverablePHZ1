/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverablephz1;

/*
 * Purpose: Hold information on players, thier name, hands, and score
 * Date: September 4, 2025
 * @author Phat Hoang & Zubayr & Alan
 */
public class Player {
    private String pName = "";
    private int pScore = 0;
    private Hand hand;
    
    public Player(String pName){
    this.pName = pName;
    this.pScore = 0;
    this.hand = new Hand();
    }
    
    //getter
    public String getName(){ return pName;}
    public Hand getHand(){ return hand;}
    public int getScore() {return pScore;}
    
    //add cards & points for player
    public void addCard(Card card){
        hand.addCard(card);
    }
    public void addScore(int score){
        this.pScore += score;
    }
    
    //functions to clear hand etc
    public void clearHand() {
    this.hand = new Hand();  
    }
    
    

}
