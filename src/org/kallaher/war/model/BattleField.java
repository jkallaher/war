/**
 * 
 */
package org.kallaher.war.model;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>BattleField</code> represents the collection of cards played by each
 * player during a round of War.  It handles the logic of determining who wins
 * each round or if there is a <code>War</code> condition.
 * 
 * @author Jay Kallaher
 * @created May 10, 2013
 * @version 1.0
 */
public class BattleField
{
	/**
	 * Default constructor.
	 */
	public BattleField ( ) { }
	
	/**
	 * Clears the playing field.
	 */
	public void clear ( )
	{
		cardsPlayed.clear();
	}
	
	/**
	 * Determines if there is a war condition.
	 * 
	 * @return TRUE if there are two or more of the same high card played,
	 *         FALSE if only one high card played.
	 */
	public boolean isWar ( )
	{
		boolean rslt = false;
		
		// Check each played card and see if the high card is played more than
		// once.
		Card highCard = null;
		for (Card c : cardsPlayed.values())
		{
			if (null == highCard)
				highCard = c;
			else if (null != c)
			{
				if (highCard.compareTo(c) == -1)
				{
					highCard = c;
					rslt = false;
				}
				else if (highCard.equals(c))
					rslt = true;
			}
		}
		
		return rslt;
	}
	
	/**
	 * Retrieves the card played by the specified player.
	 * 
	 * @param player  The player that played the card.
	 * @param card    The played card.
	 */
	public void playCard ( final Player player, final Card card )
	{
		cardsPlayed.put ( player, card );
	}
	
	/**
	 * Display the played cards.
	 */
	public void print ( )
	{
		for (Player p : cardsPlayed.keySet())
		{
			System.out.println ( p.getName() + " : "
					           + cardsPlayed.get(p) );
		}
	}

	/** The cards that have been played. */
	private Map<Player, Card> cardsPlayed = new HashMap<Player,Card> ();
}
