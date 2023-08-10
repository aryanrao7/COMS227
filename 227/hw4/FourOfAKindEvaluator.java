package hw4;

import api.Card;
//import api.Hand;

/**
 * Evaluator for a hand containing (at least) four cards of the same rank.
 * The number of cards required is four.
 *
 * The name of this evaluator is "Four of a Kind".
 * 
 * @author ARYAN RAO
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FourOfAKindEvaluator extends AbstractEvaluator {
    /**
     * Constructs the evaluator.
     * @param ranking  
     *   ranking of this hand
     * @param handSize
     *   number of cards in a hand
     */
    public FourOfAKindEvaluator(int ranking, int handSize) {
        // TODO: call appropriate superclass constructor and
        // perform other initialization
        super(handSize, 4, ranking);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Four Pair";
    }


    @Override
    public boolean canSatisfy(Card[] mainCards) {
        if (cardsRequired() == handSize()) {
            return mainCards[0].getRank() == mainCards[1].getRank() && mainCards[1].getRank() == mainCards[2].getRank() && mainCards[2].getRank() == mainCards[3].getRank();
        }
        return false;
    }


}