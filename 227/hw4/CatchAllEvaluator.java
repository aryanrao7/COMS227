package hw4;

//import api.Card;
//import api.Hand;

/**
 * Evaluator satisfied by any set of cards.  The number of
 * required cards is equal to the hand size.
 *
 * The name of this evaluator is "Catch All".
 * 
 * @author ARYAN RAO
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class CatchAllEvaluator extends AbstractEvaluator {
    /**
     * Constructs the evaluator.
     * @param ranking
     *   ranking of this hand
     * @param handSize
     *   number of cards in a hand
     */
    public CatchAllEvaluator(int ranking, int handSize) {
        // TODO: call appropriate superclass constructor and
        // perform other initialization
        super(handSize, handSize, ranking);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Catch All";
    }

    //@Override
    //public int getRanking() {
    // // TODO Auto-generated method stub
    // return 8;
    //}
    //
    //@Override
    //public int cardsRequired() {
    // // TODO Auto-generated method stub
    // return 0;
    //}
    //
    //@Override
    //public int handSize() {
    // // TODO Auto-generated method stub
    // return 0;
    //}
    //
    //@Override
    //public boolean canSatisfy(Card[] mainCards) {
    // // TODO Auto-generated method stub
    // return false;
    //}
    //
    //@Override
    //public boolean canSubsetSatisfy(Card[] allCards) {
    // // TODO Auto-generated method stub
    // return false;
    //}
    //
    //@Override
    //public Hand createHand(Card[] allCards, int[] subset) {
    // // TODO Auto-generated method stub
    // return null;
    //}
    //
    //@Override
    //public Hand getBestHand(Card[] allCards) {
    // // TODO Auto-generated method stub
    // return null;
    //}


}