package hw4;

import api.Card;
//import api.Hand;

/**
 * Evaluator for a hand in which the rank of each card is a prime number. The
 * number of cards required is equal to the hand size.
 *
 * The name of this evaluator is "All Primes".
 * 
 * @author ARYAN RAO
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class AllPrimesEvaluator extends AbstractEvaluator {
    /**
     * Constructs the evaluator.
     *
     * @param ranking  ranking of this hand
     * @param handSize number of cards in a hand
     */
    public AllPrimesEvaluator(int ranking, int handSize) {
        super(handSize, handSize, ranking);
        // TODO: call appropriate superclass constructor and
        // perform other initialization
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "All Primes";
    }

    @Override
    public boolean canSatisfy(Card[] mainCards) {
        for (int i = 0; i < mainCards.length; i++) {
            if (!(isPrime(mainCards[i].getRank()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to check whether passed number is prime or not
     * 
     * @param number
     * @return
     */
    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) { // number is perfectly divisible - no prime return false
                return false;
            }
        }

        return true;
    }
}