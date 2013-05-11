/**
 * 
 */
package org.kallaher.war.model;

import java.util.ArrayList;

/**
 * <code>Player</code> represents a player in the game of War.  The <code>Player</code>
 * maintains a dealt hand of <code>Card</code>s and set of won <code>Card</code>s.
 * 
 * @author jay
 *
 */
public class Player
{
    /**
     * Default constructor.
     */
    public Player ( ) { }
    
    public Player ( final String aName )
    {
    	name = aName;
    }
    
    /**
     * Adds a <code>Card</code> to the playing hand.
     * 
     * @param card  The <code>Card</code> dealt to the player.
     */
    public void addCard ( Card card )
    {
        playingHand.add ( card );
    }
    
    /**
     * Adds the list of <code>Card</code>s to the win pile.
     * 
     * @param cards  The <code>Card</code>s from the pile.
     */
    public void addWinnings ( ArrayList<Card> cards )
    {
        winPile.addCards ( cards );
    }
    
    /**
     * @return the number of <code>Card</code>s the player has, this includes
     *         both the playing hand and the win pile.
     */
    public int cardCount ( )
    {
        return playingHand.count () + winPile.count ( );
    }
    
    /**
     * @return the name of the player.
     */
    public String getName ( ) { return name; }
    
    /**
     * Plays the top card of the <code>Player</code>'s playing hand.  If the
     * playing hand becomes empty, the winning pile is transferred to the playing
     * hand and it is shuffled.
     * 
     *  @return the top card from the playing hand.
     */
    public Card playCard ( )
    {
        Card card = playingHand.dealCard ( );
        
        if (playingHand.isEmpty())
        {
            if (!winPile.isEmpty ( ))
            {
                while (!winPile.isEmpty ( ))
                {
                    playingHand.add ( winPile.dealCard ( ) );
                }
                
                playingHand.shuffle ( 15 );
            }
        }
        
        return card;
    }
    
    public String toString ( )
    {
    	String s = name + "'s cards: \n" + playingHand.toString();
    	
    	return s;
    }
    
    private String name;
    private Deck playingHand = new Deck ( );
    private Deck winPile = new Deck ( );
}
