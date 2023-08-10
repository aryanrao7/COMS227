package hw4;

import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

import api.Card;
import api.Hand;
import api.IEvaluator;
import util.SubsetFinder;

/**
 * The class AbstractEvaluator includes common code for all evaluator types.
 * 
 * Used one more Abstract class for StraightEvaluator and StraightFlushEvaluator
 * 
 *
 * TODO: Expand this comment with an explanation of how your class hierarchy is
 * organized.
 * @author ARYAN RAO
 */
public abstract class AbstractEvaluator implements IEvaluator {
    private int hand_Size;
    private int cardsRequired;
    private int ranking;

    protected AbstractEvaluator(int handsize, int cardsRequired, int ranking) {
        hand_Size = handsize;
        this.ranking = ranking;
        this.cardsRequired = cardsRequired;
    }

    public String getName() {
        return (this.getClass().getSimpleName());
    }

    public int cardsRequired() {
        return cardsRequired;
    }

    public int getRanking() {
        return ranking;
    }

   
     @Override
     public Hand createHand(Card[] allCards, int[] subset) {



    	 Card[] mainCards = new Card[subset.length];
    	 Card[] sideCards = new Card[hand_Size - subset.length];

    	 for(int i=0;i<subset.length;i++) {

    	 mainCards[i]= allCards[subset[i]];
    	 }

    	 if(!(canSatisfy(mainCards))) {
    	 return null;
    	 }

    	 for(int i=0;i<hand_Size-subset.length;i++) {

    	 sideCards[i] = allCards[i];
    	 }

    	 Hand newHand = new Hand(mainCards,sideCards,this);
    	 return newHand;

        }
       
    

    @Override
    public Hand getBestHand(Card[] allCards) {

        Hand h = null;
        ArrayList < int[] > subsets = SubsetFinder.findSubsets(allCards.length, cardsRequired());
        h = createHand(allCards, subsets.get(0));
        for (int i = 0; i < subsets.size(); i++) 
        {
            Hand hand2 = createHand(allCards, subsets.get(i));
            if (h == null) 
            {
                h = hand2;
            } 
            else if (hand2 != null)
            {
                if (hand2.compareTo(h) < 0) 
                {
                    h = hand2;
                }
            }
        }
        return h;
    }

    public int handSize() {
        return hand_Size;
    }

    @Override
    public boolean canSatisfy(Card[] mainCards) {
        if (cardsRequired() == handSize()) {
            return true;
        }
        return false;
    }


    @Override
    public boolean canSubsetSatisfy(Card[] allCards) {

        ArrayList < int[] > subsets = SubsetFinder.findSubsets(allCards.length, cardsRequired());

        for (int[] subset: subsets) {

            Card[] mainCards = new Card[subset.length];
            for (int i = 0; i < subset.length; i++) {

                mainCards[i] = allCards[subset[i]];
            }

            if (canSatisfy(mainCards)) {
                return true;
            }

        }

        return false;
    }
}
