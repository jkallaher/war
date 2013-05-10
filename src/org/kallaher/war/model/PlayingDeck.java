/**
 * 
 */
package org.kallaher.war.model;

import java.util.Vector;

/**
 * A <code>PlayingDeck</code> is a collection of 52 <code>Card</code>s.  There 
 * are 13 <code>Card</code>s (2 -10, Jack, Queen, King, and Ace) of each of the 
 * four <code>Suit</code>s (Club, Diamond, Heart, and Spade).
 * 
 * @author jay
 *
 */
public class PlayingDeck extends Deck
{
    /**
     * Default constructor.
     */
    public PlayingDeck ( )
    {
        super ( );
        
        // Create the 52 card deck then shuffle them.
        for (Suit s : Suit.values())
        {
        	for (int i=2; i<15; i++)
        	{
        		cards.add ( new Card ( i, s ) );
        	}
        }
        
        shuffle ( 104 );
    }
}
