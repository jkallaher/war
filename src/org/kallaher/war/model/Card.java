/**
 * This file defines the <code>Card<?code> class.
 */
package org.kallaher.war.model;

import java.util.HashMap;
import java.util.Map;

/**
 * A <code>Card</code> represents a single card in a deck of cards.
 *  
 * @author jay
 *
 */
public class Card implements Comparable
{
    public Card ( )
    {
        value = 1;
        suit  = Suit.CLUB;
    }
    
    public Card ( final int val, final Suit aSuit )
    {
        value = val;
        suit = aSuit;
    }

    /**
     * For the game of War, we only need to compare value.
     */
    @Override
    public int compareTo ( Object arg0 )
    {
        int result;
        Card c;
        
        if (arg0 instanceof Card)
        {
            c = (Card)arg0;
            if (this.equals ( c ))
                result = 0;
            else
            {
                if (value < c.value)
                    result = -1;
                else
                    result = 1;
            }
        }
        else result = -1;

        return result;
    }

    /**
     * For the game of War, the only thing we need to for equality is the card value.
     * 
     * @param obj
     * @return
     */
    public boolean equals ( final Card obj )
    {
        return (value == obj.value);
    }
    
    public Suit getSuit ( ) { return suit; }
    public int getValue ( ) { return value; }
    
    public String toString ( )
    {
        String result = "";
        
        result = cardValues.get ( new Integer ( value ) ) + " of " + suit + "s";
        return result;
    }
    
    private int value;
    private Suit suit;
    
    private static Map<Integer, String> cardValues = new HashMap<Integer,String> ( );
    static
    {
        cardValues.put ( new Integer(2), "Two" );
        cardValues.put ( new Integer(3), "Three" );
        cardValues.put ( new Integer(4), "Four" );
        cardValues.put ( new Integer(5), "Five" );
        cardValues.put ( new Integer(6), "Six" );
        cardValues.put ( new Integer(7), "Seven" );
        cardValues.put ( new Integer(8), "Eight" );
        cardValues.put ( new Integer(9), "Nine" );
        cardValues.put ( new Integer(10), "Ten" );
        cardValues.put ( new Integer(11), "Jack" );
        cardValues.put ( new Integer(12), "Queen" );
        cardValues.put ( new Integer(13), "King" );
        cardValues.put ( new Integer(14), "Ace" );
    }
}
