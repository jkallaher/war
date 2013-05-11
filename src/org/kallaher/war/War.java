/**
 * 
 */
package org.kallaher.war;

import java.util.Vector;

import org.kallaher.war.model.BattleField;
import org.kallaher.war.model.Card;
import org.kallaher.war.model.Player;
import org.kallaher.war.model.PlayingDeck;

/**
 * @author jay
 *
 */
public class War
{
	/**
	 * Default constructor.
	 */
	public War ( )
	{
		this ( 2 );
	}
	
	/**
	 * Construct a new <code>War</code> game for the specified number of players.
	 * 
	 * @param num  The number of players.
	 */
	public War ( final int num )
	{
		numberOfPlayers = num;
		
		// Setup the player objects.
		for (int i=0; i<numberOfPlayers; i++)
		{
			Player aPlayer = new Player ( "Player" + (i+1) );
			players.add ( aPlayer );
		}
	}
	
	/**
	 * Deals the cards from the playing deck to the players.
	 */
	public void deal ( )
	{
        // Create a deck to deal cards to the players from.
    	PlayingDeck playCards = new PlayingDeck ( );
    	
    	// Deal out the cards to the players.
    	int dealingTo = 0;
    	while (!playCards.isEmpty())
    	{
    		players.get(dealingTo).addCard ( playCards.dealCard() );
    		dealingTo++;
    		if (dealingTo == numberOfPlayers) dealingTo = 0;
    	}
    	
	}

    /**
     * @param args
     */
    public static void main ( String[] args )
    {
    	// Create a new War game.
    	War war = new War ( );
    	
    	// Deal out the cards.
    	war.deal ( );
    	
    	// Now start the game.
    	war.start ( );
    }
    
    /**
     * Indicates if more than one player has cards to play.
     */
    public boolean moreThanOneHasCards ( )
    {
    	boolean result = false;
    	
    	int playersWithCards = 0;
    	for (Player p : players)
    	{
    		if (p.cardCount() > 0) playersWithCards++;
    	}
    	
    	result = (playersWithCards > 1);
    	
    	return result;
    }
    
    /**
     * A single round of card play..
     */
    protected void play ( )
    {
    	field.clear ( );
    	for (Player p : players)
    	{
    		field.playCard(p, p.playCard());
    	}
    	
		// Display the played cards.
		field.print ( );

		// Determine if a war situation exists.
    	if (field.isWar())
    	{
    		System.out.println ( "There is a war between " );
    	}
    }
    
    /**
     * Executes the <code>War</code> game engine.
     */
    public void start ( )
    {
    	while (moreThanOneHasCards())
    	{
    		play ( );
    	}
    }
    
    /** The playing field. */
    private BattleField field = new BattleField ( );
    
    /** The number of players in the game. */
    private int numberOfPlayers;  // Default to 2 players
    
    /** The currently played cards. */
    private Vector<Card> playedCards = new Vector<Card> ( );
    
    /** The list of players. */
    private Vector<Player> players = new Vector<Player>( );

}
