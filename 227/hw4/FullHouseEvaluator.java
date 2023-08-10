package hw4;

import java.util.ArrayList;
import java.util.Arrays;

import api.Card;
import api.Hand;
import util.SubsetFinder;

/**
 * Evaluator for a generalized full house. The number of required cards is equal
 * to the hand size. If the hand size is an odd number n, then there must be (n
 * / 2) + 1 cards of the matching rank and the remaining (n / 2) cards must be
 * of matching rank. In this case, when constructing a hand, the larger group
 * must be listed first even if of lower rank than the smaller group</strong>
 * (e.g. as [3 3 3 5 5] rather than [5 5 3 3 3]). If the hand size is even, then
 * half the cards must be of matching rank and the remaining half of matching
 * rank. Any group of cards, all of which are the same rank, always satisfies
 * this evaluator.
 *
 * The name of this evaluator is "Full House".
 * 
 * @author ARYAN RAO
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FullHouseEvaluator extends AbstractEvaluator {

    /**
     * Constructs the evaluator.
     *
     * @param ranking  ranking of this hand
     * @param handSize number of cards in a hand
     */
    public FullHouseEvaluator(int ranking, int handSize) {
        // TODO: call appropriate superclass constructor and
        // perform other initialization
        super(handSize, handSize, ranking);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Full House";
    }

    @Override
    public boolean canSatisfy(Card[] mainCards) {
        // TODO Auto-generated method stub

        if (mainCards.length != cardsRequired()) {
            return false;
        }

        Arrays.sort(mainCards);
        int cardRank1 = mainCards[0].getRank();
        int cardRank2 = mainCards[mainCards.length - 1].getRank();
        int counter1 = 0;
        int counter2 = 0;

        if (cardsRequired() % 2 == 0) {
            for (int i = 0; i < mainCards.length; i++) {
                if (i < mainCards.length / 2) {
                    if (mainCards[i].getRank() == cardRank1) {
                        counter1++;
                    } else {
                        return false;
                    }
                } else if (i >= mainCards.length / 2 && i < mainCards.length) {
                    if (mainCards[i].getRank() == cardRank2) {
                        counter2++;
                    } else {
                        return false;
                    }
                }

            }

            if (counter1 == counter2) {
                return true;
            }
        }
        if (cardsRequired() % 2 != 0) {
            for (int i = 0; i < mainCards.length; i++) {
                if (i < (mainCards.length / 2)) {
                    if (mainCards[i].getRank() == cardRank1) {
                        counter1++;
                    } else {
                        return false;
                    }
                }
                if (i >= (mainCards.length / 2) + 1 && i < mainCards.length) {
                    if (mainCards[i].getRank() == cardRank2) {
                        counter2++;
                    } else {
                        return false;
                    }
                }
                if (i == (mainCards.length) / 2 + 1) {
                    if (mainCards[i].getRank() == cardRank1) {
                        counter1++;
                    }
                    if (mainCards[i].getRank() == cardRank2) {
                        counter2++;
                    }
                }

            }

            if (counter1 - counter2 == 1 || counter2 - counter1 == 1) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean canSubsetSatisfy(Card[] allCards) {
        // TODO Auto-generated method stub

        ArrayList < int[] > arr = SubsetFinder.findSubsets(allCards.length, cardsRequired());

        if (allCards.length < cardsRequired()) {
            return false;
        }


        Arrays.sort(allCards);
        for (int i = 0; i < arr.size(); i++) {
            Card[] cards = new Card[cardsRequired()];
            for (int j = 0; j < cardsRequired(); j++) {
                cards[j] = allCards[arr.get(i)[j]];
            }

            if (canSatisfy(cards) == true) {
                return true;
            }

        }

        return false;
    }

    @Override
    public Hand createHand(Card[] allCards, int[] subset) {
        // TODO Auto-generated method stub

        Card[] mainCards = new Card[cardsRequired()];
        Card[] sideCards = new Card[handSize() - mainCards.length];

        if (allCards.length < handSize()) {
            return null;
        }


        Arrays.sort(allCards);

        for (int i = 0; i < subset.length; i++) {
            mainCards[i] = allCards[subset[i]];


        }

        int counter = 0;

        for (int j = 0; j < allCards.length; j++) {
            boolean canAdd = true;
            for (int k = 0; k < subset.length; k++) {
                if (j == subset[k]) {
                    canAdd = false;
                    break;
                }

            }
            if (canAdd && counter < sideCards.length) {
                sideCards[counter] = allCards[j];
                counter++;
            }


        }

        if (canSatisfy(mainCards) == true) {
            return new Hand(mainCards, sideCards, this);
        }

        return null;
    }
}
