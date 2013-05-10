/**
 * 
 */
package org.kallaher.war;

import org.kallaher.war.model.PlayingDeck;

/**
 * @author jay
 *
 */
public class War
{

    /**
     * @param args
     */
    public static void main ( String[] args )
    {
        // Create a deck to deal cards to the players from.
    	PlayingDeck playCards = new PlayingDeck ( );
    	
    	System.out.println ( playCards );

    }

}
