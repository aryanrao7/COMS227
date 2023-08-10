package hw4;

//import java.util.*;
//import java.lang.*;
import api.Card;
//import api.Hand;

/**
 * Evaluator for a hand containing (at least) two cards of the same rank.
 * The number of cards required is two.
 *
 * The name of this evaluator is "One Pair".
 * 
 * @author ARYAN RAO
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class OnePairEvaluator extends AbstractEvaluator {
    /**
     * Constructs the evaluator.
     * @param ranking
     *   ranking of this hand
     * @param handSize
     *   number of cards in a hand
     */
    public OnePairEvaluator(int ranking, int handSize) {
        super(handSize, 2, ranking);
    }

    @Override
    public String getName() {
        return "One Pair";
    }

    @Override
    public boolean canSatisfy(Card[] mainCards) {
        if (cardsRequired() == mainCards.length) {
            return mainCards[0].getRank() == mainCards[1].getRank();
        }
        return false;
    }
    
    




}


