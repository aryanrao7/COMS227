package hw4;

import api.Card;
//import api.Hand;

/**
 * Evaluator for a hand containing (at least) three cards of the same rank.
 * The number of cards required is three.
 *
 * The name of this evaluator is "Three of a Kind".
 * 
 * @author ARYAN RAO
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class ThreeOfAKindEvaluator extends AbstractEvaluator {
    /**
     * Constructs the evaluator.
     * @param ranking
     *   ranking of this hand
     * @param handSize
     *   number of cards in a hand
     */
    public ThreeOfAKindEvaluator(int ranking, int handSize) {
        // TODO: call appropriate superclass constructor and
        // perform other initialization
        super(handSize, 3, ranking);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Three Pair";
    }



    @Override
    public boolean canSatisfy(Card[] mainCards) {
        if (cardsRequired() == handSize()) {
            return mainCards[0].getRank() == mainCards[1].getRank() && mainCards[1].getRank() == mainCards[2].getRank();
        }
        return false;
    }


}