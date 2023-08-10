package hw2;

/**
 * The aim of this assignment is to implement a real life game of monopoly for two players
 * The set of instructions have been provided
 * The various functionalities of each each square has also been given
 * @author ARYAN RAO
 *
 */

public class CyGame {
/**
* Do nothing square type.
*/
public static final int DO_NOTHING = 0;
/**
* Pass go square type.
*/
public static final int PASS_GO = 1;
/**
* Cyclone square type.
*/
public static final int CYCLONE = 2;
/**
* Pay the other player square type.
*/
public static final int PAY_PLAYER = 3;
/**
* Get an extra turn square type.
*/
public static final int EXTRA_TURN = 4;
/**
* Jump forward square type.
*/
public static final int JUMP_FORWARD = 5;
/**
* Stuck square type.
*/
public static final int STUCK = 6;
/**
* Points awarded when landing on or passing over go.
*/
public static final int PASS_GO_PRIZE = 200;
/**
* The amount payed to the other player per unit when landing on a
* PAY_PLAYER square.
*/
public static final int PAYMENT_PER_UNIT = 20;
/**
* The amount of money required to win.
*/
public static final int MONEY_TO_WIN = 400;
/**
* The cost of one unit.
*/
public static final int UNIT_COST = 50;
// TODO: EVERTHING ELSE
// Note that this code will not compile until you have put in stubs for all
// the required methods.
// The method below is provided for you and you should not modify it.
// The compile errors will go away after you have written stubs for the
// rest of the API methods.

/**
 *  currentPlayer- Tracks the player who is currently playing. Player 1 is 1 and Player 2 is 2.
 *  Square1-       Records the square where Player 1 is currently on.
 *  Money1-        Records the total money Player 1 has.
 *  Property1-     Records the total number of properties Player 1 owns.
 *  Square2-       Records the square where Player 2 is currently on.
 *  Money2-        Records the total money Player 2 has.
 *  Property2-     Records the total number of properties Player 2 owns.
 *  totalSquares-  Records total number of squares in a given game of monopoly.
 */
private int currentPlayer; 

private int Square1;

private int Money1;

private int Property1;

private int Square2;

private int Money2;

private int Property2;

private int totalSquares;


/**
 * Initialises all the instances variable with some value.
 * Two value are provided by the user of total squares and the starting amount of money each player will have
 * @param numSquares- Value provided by the user of total number of squares in a given game.
 * @param startingMoney- Value provided by the user of the starting money each players starts with.
 */
public CyGame(int numSquares, int startingMoney)
{
			currentPlayer=1;
			
			totalSquares=numSquares;
			
			Money1=startingMoney;
			
			Money2=startingMoney;
			
			Square1=0;
			
			Square2=0;
			
			Property1=1;
			
			Property2=1;

}

/**
 * This method will allow the current player to buy a unit of property if the game hasn't ended.
 * The player is allowed to buy a unit only if the player is on a DO_NOTHING square type.
 * The player also must have minimum cost of UNIT_COST amount to purchase the unit.
 * If player is allowed to buy a unit, the money decreases by the UNIT_COST and the number of property units increase.
 * The player's turn is ended after the purchase.
 */

public void buyUnit()
{
		if (isGameEnded() == false)
		
		{
		if (currentPlayer == 1)
		
		{
		
		if (getSquareType(Square1) == DO_NOTHING)
		
		{
		
		if (Money1 >= UNIT_COST)
		
		{
		
		Money1 -= UNIT_COST;
		
		Property1 += 1;
		endTurn();
		
		}
		}
		
		}
		
		else if (currentPlayer == 2)
		
		{
		
		if (getSquareType(Square2) == DO_NOTHING)
		
		{
		
		if (Money2 >= UNIT_COST)
		
		{
		
		Money2 = Money2 - UNIT_COST;
		
		Property2 += 1;
		endTurn();
		
		}
		
		}
		}
		
		else
		{
		endTurn();
		}
		
		}

}

/**
 * This method ends the current players' turn.
 * If the current player is 1 it will change the current player to 2.
 */

public void endTurn()
{
		if(currentPlayer!=1)
		{
		currentPlayer=1;
		}
		else
		{
		currentPlayer=2;
		}
}

/**
 * Returns current player which is 1 or 2.
 * @return- currentPlayer
 */

public int getCurrentPlayer()
{  
		return currentPlayer;
}

/**
 * Returns the total money Player 1 has.
 * @return- Money1
 */

public int getPlayer1Money()
{
		return Money1;
}

/**
 * Returns the current square player 1 is on.
 * @return- Square1
 */
public int getPlayer1Square()
{
		return Square1;
}

/**
 * Returns the total number of properties Player 1 owns.
 * @return- Property1
 */

public int getPlayer1Units()
{
		return Property1;
}

/**
 * Returns the total money Player 2 has.
 * @return- Money2
 */

public int getPlayer2Money()
{
		return Money2;
}

/**
 * Returns the current square player 2 is on.
 * @return- Square2
 */

public int getPlayer2Square()
{
		return Square2;
}

/**
 * Returns the total number of properties Player 2 owns.
 * @return- Property2
 */
public int getPlayer2Units()
{
		return Property2;
}

/**
 * Returns the value for the provided type of square.
 * Helps us determine the action to be taken for the given square.
 * @param square- Value of the square for which we need to find the value for.
 * @return- type of square
 */

public int getSquareType( int square)
{
			int temp = totalSquares - 1;
			
			if (square == 0)
			
			{
			
			return PASS_GO;
			
			}
			
			else if (square == temp)
			
			{
			
			return CYCLONE;
			
			}
			
			else if (square % 5 == 0)
			
			{
			
			return PAY_PLAYER;
			
			}
			
			else if (square % 7 == 0 || square % 11 == 0)
			
			{
			
			return EXTRA_TURN;
			
			}
			
			else if (square % 3 == 0)
			
			{
			
			return STUCK;
			
			}
			
			else if (square % 2 == 0)
			
			{
			
			return JUMP_FORWARD;
			
			}
			
			else
			
			{
			
			return DO_NOTHING;
			
			}

}

/**
 * Returns true or false depending on whether the game has ended or not. 
 * Checks some conditions and takes the following steps depending on it.
 * @return- true or false
 */

public boolean isGameEnded()
{
		   if(Money1>=MONEY_TO_WIN || Money2>=MONEY_TO_WIN || Money1<0 || Money2<0)
			return true;
		   else
			return false;   

}

/**
 * Simulates rolling of dice.
 * Checks whether games has ended or not.
 * Checks whether the value of dice is between 1 and 6.
 * Checks the current player who is playing.
 * Checks if player is on STUCK or not.
 * If player is on STUCK, check if value is even or not.
 * If value is even or player is not on STUCK, adds value to the respective players current square value.
 * After the value is added, proceed with conditions provided for the new square.
 * 
 * @param value
 */
public void roll(int value)
{
if (isGameEnded() == false)

{
       if (value >= 1 && value <= 6)

       {

              if (currentPlayer == 1)

              {

                    if (getSquareType(Square1) == STUCK )

                    {

                           if (value % 2 == 0)

                           {

                                  Square1 += value;

                           }

                           else

                           {

                                 

                           }

                    }

                    else

                    {

                           Square1 += value;
                    }

                   

                    if (Square1 >= totalSquares)

                    {
                           Square1 %= totalSquares;
                           Money1 += PASS_GO_PRIZE;
                           endTurn();

                    }

                     Square1 %= totalSquares;

                    if (getSquareType(Square1) == CYCLONE)

                    {

                           Square1 = Square2;
                            endTurn();

                    }

                    else if (getSquareType(Square1) == PAY_PLAYER)

                    {

                           Money1 -= PAYMENT_PER_UNIT * Property2;

                           Money2 += PAYMENT_PER_UNIT * Property2;

                    }

                    else if (getSquareType(Square1) == EXTRA_TURN)

                    {

                           currentPlayer = 2;

                    }

                    else if (getSquareType(Square1) == STUCK) {

                    }

                    else if (getSquareType(Square1) == JUMP_FORWARD)

                    {

                           Square1 += 4;

                           if (Square1 >= totalSquares)

                           {
                                  Square1 %= totalSquares;
                                  Money1 += PASS_GO_PRIZE;
                                  endTurn();

                           }
                            Square1 %= totalSquares;
                    }

                    else

                    {
                         

                    }

              }

              if (currentPlayer == 2)

              {

                    if (getSquareType(Square2) == STUCK)

                    {

                           if (value % 2 == 0)

                           {

                                  Square2 += value;

                           }

                           else

                           {

                                 

                           }

                    }

                    else

                    {

                           Square2 += value;
                    }

                    if (Square2 >= totalSquares)

                    {
                           Square2 %= totalSquares;
                           Money2 += PASS_GO_PRIZE;
                           endTurn();

                    }

                    Square2 %= totalSquares;

                    if (getSquareType(Square2) == CYCLONE)

                    {

                           Square2 = Square1;
                            endTurn();

                    }

                    else if (getSquareType(Square2) == PAY_PLAYER)

                    {

                           Money2 -= PAYMENT_PER_UNIT * Property1;

                           Money1 += PAYMENT_PER_UNIT * Property1;

                    }

                    else if (getSquareType(Square2) == EXTRA_TURN)

                    {

                           currentPlayer = 1;

                    }

                    else if (getSquareType(Square2) == STUCK) {

                    }

                    else if (getSquareType(Square2) == JUMP_FORWARD)

                    {

                           Square2 += 4;

                           if (Square2 >= totalSquares)

                           {

                                  Square2 %= totalSquares;
                                  Money2 += PASS_GO_PRIZE;
                                  endTurn();

                           }
                          Square2 %= totalSquares;
                    }

                    else

                    {
                         

                    }

              }

              endTurn();

       }

}

}


/**
 * The method lets the current player sell a unit of his property he owns.
 * The current players money is increased by UNIT_COST and his property is decreased by 1.
 */
public void sellUnit()
{

			if (isGameEnded() == false)
			
			{
			
			if (currentPlayer == 1)
			
			{
			
			if (Property1 >= 1) {
			
			Money1 += UNIT_COST;
			
			Property1 -= 1;
			
			
			endTurn();
			} else {
			 //endTurn();
			}
			}
			
			else
			
			{
			if (Property2 >= 1) {
			
			Money2 += UNIT_COST;
			
			Property2 -= 1;
			
			
			endTurn();
			
			} else {
			// endTurn();
			}
			}
			
			}

}
/**
* Returns a one-line string representation of the current game state. The
* format is:
* <p>
* <tt>Player 1*: (0, 0, $0) Player 2: (0, 0, $0)</tt>
* <p>
* The asterisks next to the player's name indicates which players turn it
* is. The numbers (0, 0, $0) indicate which square the player is on, how
* many units the player has, and how much money the player has
* respectively.
* @return one-line string representation of the game state
*/
public String toString() 
{
   String fmt = "Player 1%s: (%d, %d, $%d) Player 2%s: (%d, %d, $%d)";
   String player1Turn = "";
   String player2Turn = "";
   if (getCurrentPlayer() == 1) {
      player1Turn = "*";
} 
   else {
      player2Turn = "*";
}
   
   return String.format(fmt,
   player1Turn, getPlayer1Square(), getPlayer1Units(),
   getPlayer1Money(),
   player2Turn, getPlayer2Square(), getPlayer2Units(),
   getPlayer2Money());
}
}

