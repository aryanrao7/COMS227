package hw4;

import java.util.Arrays;

import api.Card;
import api.Hand;


/**
 * 
 * @author ARYAN RAO
 * Abstract class for StraightEvaluator and StraightFlushEvaluator
 * Code is same for both classes so to make code efficient this class is inherited by above two classes 
 */
public abstract class AbstractStraight extends AbstractEvaluator
{
	/**
	 * Integer to keep track of maximum rank of a card
	 */
	private int maxCardRank;
	
	public AbstractStraight(int ranking, int handSize, int maxCardRank)
	{
		super(handSize,handSize,ranking);
		this.maxCardRank= maxCardRank;
	}

	@Override
	public boolean canSatisfy(Card[] mainCards)
	{
		boolean satisfy = false;
		
		if(mainCards.length!=cardsRequired())
		{
			return false;
		}
		
		if(AceLow(mainCards) || AceHigh(mainCards))
		{
			return true;
		}
		
		for(int i =1;i<mainCards.length;i++)
		{
			if(mainCards[i-1].getRank()==mainCards[i].getRank())
			{
				satisfy = true;
			}
			
			else
			{
				return false;
			}
		}
		
		return satisfy;
	}
	
	@Override
	public Hand createHand(Card[] allCards, int [] subset)
	{
		if(allCards.length<handSize() || subset.length!=cardsRequired())
		{
			return null;
		}
		
		Hand reqHand = null;
		
		 Card[] mainCards = new Card[cardsRequired()];
	     Card[] sideCards = new Card[handSize() - mainCards.length];
	     
	     Arrays.sort(allCards);

	        for (int i = 0; i < subset.length; i++) {
	            mainCards[i] = allCards[subset[i]];

	        }
		
		if(mainCards.length!=cardsRequired() || mainCards.length + sideCards.length < handSize() || !(canSatisfy(mainCards)))
		{
			return null;
		}
		
		if(AceLow(mainCards))
		{
			mainCards = reSortIfAceLow(mainCards);
			reqHand = new Hand(mainCards, sideCards, this);
		}
		
		else
		{
			reqHand = new Hand(mainCards, sideCards ,this);
		}
		
		return reqHand;
	}
	
	
    /**
     * Helper method to check if the given cards is a ace-high
     * 
     * @param mainCards
     * @return
     */
	protected boolean AceHigh (Card[] mainCards) 
	{
		boolean isHigh = false;
		
		for (int i = 2; i < mainCards.length; i++)
		{
			if (mainCards[0].getRank() == 1 && mainCards[1].getRank() == maxCardRank && mainCards[i - 1].getRank() == mainCards[i].getRank() + 1)
			{
				isHigh = true;
			}
			
			else
			{
				isHigh = true;
			}
		}
		return isHigh;
		
	}
	/**
	 * Helper method to check if the given cards is a ace-low
	 * 
	 * @param mainCards
	 * @return
	 */
	protected boolean AceLow(Card[] mainCards) 
	{
		boolean isLow = false;
		
		for (int i = 2; i < mainCards.length; i++)
		{
			if((mainCards[0].getRank() == 1 && mainCards[mainCards.length - 1].getRank() == 2 && mainCards[i - 1].getRank() == mainCards[i].getRank() + 1))
			{
				isLow= true;
			}
			
			else
			{
				isLow = false;
			}
			
		}
		
		return isLow;
	}
	
	/**
	 * Helper method to sort the cards if the card is a Low Ace card
	 * 
	 * @param mainCards
	 * @return
	 */
	protected Card[] reSortIfAceLow(Card[] mainCards)
	{
		Card aceCard = mainCards[0];
		
		for (int i = 0; i < mainCards.length- 1; i++)
		{
			mainCards[i] = mainCards[i+1];
			
		}
		mainCards[mainCards.length-1] = aceCard;
		
		return mainCards;
	}
}
