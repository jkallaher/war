/**
 * 
 */
package org.kallaher.war.model;

import java.util.ArrayList;
import java.util.Vector;

/**
 * A <code>Deck</code> is a collection of <code>Card</code>s.  There are 13
 * <code>Card</code>s (2 -10, Jack, Queen, King, and Ace) of each of the four 
 * <code>Suit</code>s (Club, Diamond, Heart, and Spade).
 * 
 * @author jay
 *
 */
public class Deck
{
    public Deck ( ) { }
    
    public boolean add ( Card card )
    {
        return cards.add ( card );
    }
    
    public boolean addCards ( ArrayList<Card> someCards )
    {
        return this.cards.addAll ( someCards );
    }
    
    /**
     * @return the number of <code>Card</code>s that are in the deck.
     */
    public int count ( )
    {
        return cards.size ( );
    }
    
    /**
     * Deals the top card of the deck.
     * 
     * @return the first <code>Card</code> in the deck.
     */
    public Card dealCard ( )
    {
        if (!cards.isEmpty ( ))
            return cards.remove ( 0 );
        
        return null;
    }
    
    /**
     * @return TRUE if the <code>Deck</code> has no more cards, FALSE if it has
     *         cards.
     */
    public boolean isEmpty ( )
    {
        return cards.isEmpty ( );
    }

    public void shuffle ( )
    {
        
    }
    
    protected Vector<Card> cards = new Vector<Card> ( );
}
