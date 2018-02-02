/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;
/**
 *
 * @author bharg
 */
public class DeckOfCards {
    
    public static void main(String[] args) {
    String[] type = {"C", "D", "H", "S"};
    String[] cardValues = { "1","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    int size = 52;
    Vector<String> deck = new Vector<>(size);
    LinkedList<String> shuffledDeck = new LinkedList<>();
    Random randomCard = new Random();                        

   
    for(String s : type) {
      for(String cardValue : cardValues) {
        deck.add(cardValue + s);
      }
  }

    
    int selection = 0;                                               
    for(int i = 0 ; i < size ; ++i) {
      selection = randomCard.nextInt(deck.size());
      shuffledDeck.add(deck.remove(selection));
    }

    
    StringBuffer[] hands = { new StringBuffer("Hand 1:"), new StringBuffer("Hand 2:"),new StringBuffer("Hand 3:"), new StringBuffer("Hand 4:")};
    ListIterator<String> cards = shuffledDeck.listIterator();

    while(cards.hasNext()) {
      for(StringBuffer hand : hands) {
        hand.append(' ').append(cards.next());
      }
    }

    for(StringBuffer hand : hands) {
      System.out.println(hand);
    }
  }
    
    
}
