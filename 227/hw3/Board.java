package hw3;

import static api.Direction.*;
import static api.Orientation.*;

import java.util.ArrayList;

import api.Cell;

import api.Direction;
import api.Move;
//import api.Orientation;

/**
 * Represents a board in the Block Slider game. A board contains a 2D grid of
 * cells and a list of blocks that slide over the cells.
 * @author ARYAN RAO
 */
public class Board {


    /**
     * 2D array of cells, the indexes signify (row, column) with (0, 0) representing
     * the upper-left corner of the board.
     */
    private Cell[][] grid;

    /**
     * A list of blocks that are positioned on the board.
     */
    private ArrayList < Block > blocks;

    /**
     * A list of moves that have been made in order to get to the current position
     * of blocks on the board.
     */
    private ArrayList < Move > moveHistory;
    
    private ArrayList < Move > possibleMoves; // keeps track of possible moves that can be made
    
    private Cell cellBlockGrabbed; // current cell which is grabbed
    
    private Cell cellMovedTo; // the cell which is moved to in moveGrabbedBlock
    
    private boolean isGameEnded; // check whether game ended or not

    private Block grabbedBlock; // records currently grabbed block
    
    private int moveCount = 0; // counts number of moves made

    /**
     * Constructs a new board from a given 2D array of cells and list of blocks. The
     * cells of the grid should be updated to indicate which cells have blocks
     * placed over them (i.e., setBlock() method of Cell). The move history should
     * be initialized as empty.
     *
     * @param grid   a 2D array of cells which is expected to be a rectangular shape
     * @param blocks list of blocks already containing row-column position which
     *               should be placed on the board
     */
    public Board(Cell[][] grid, ArrayList < Block > blocks) {
       
        this.blocks = blocks;
        this.grid = grid;
        moveHistory = new ArrayList < Move > ();
        
        for(Block b : blocks)
        {
        	int l = b.getLength();
        	int r = b.getFirstRow();
        	int c = b.getFirstCol();
        	
        	this.grid[r][c].setBlock(b);
        	
        	if(b.getOrientation() == HORIZONTAL)
        	{
        		for(int i = c+1;i<c+l;i++)
        		{
        			this.grid[r][i].setBlock(b);
        		}
        	}
        	
        	else if(b.getOrientation() == VERTICAL)
        	{
        		for(int i =r+1;i<r+l;i++)
        		{
        			this.grid[i][c].setBlock(b);
        		}
        	}
        }
    }

    /**
     * Constructs a new board from a given 2D array of String descriptions.
     * <p>
     * DO NOT MODIFY THIS CONSTRUCTOR
     * @param desc 2D array of descriptions
     */
    public Board(String[][] desc) {
        this(GridUtil.createGrid(desc), GridUtil.findBlocks(desc));
    }

    /**
     * Models the user grabbing a block over the given row and column. The purpose
     * of grabbing a block is for the user to be able to drag the block to a new
     * position, which is performed by calling moveGrabbedBlock(). This method
     * records two things: the block that has been grabbed and the cell at which it
     * was grabbed.
     *
     * @param row row to grab the block from
     * @param col column to grab the block from
     */
    public void grabBlockAtCell(int row, int col) {
       
        cellBlockGrabbed = grid[row][col];
        for (int i = 0; i < blocks.size(); i++) {
            Block currentBlock = blocks.get(i);
            if (currentBlock.getFirstRow() == row && currentBlock.getFirstCol() == col) {
                grabbedBlock = currentBlock;
                break;

            }
        }

    }

    /**
     * Set the currently grabbed block to null.
     */
    public void releaseBlock() {
       
        grabbedBlock = null;
    }

    /**
     * Returns the currently grabbed block.
     *
     * @return the current block
     */
    public Block getGrabbedBlock() {
        
        return grabbedBlock;
    }

    /**
     * Returns the currently grabbed cell.
     *
     * @return the current cell
     */
    public Cell getGrabbedCell() {
        
        return cellBlockGrabbed;
    }

    /**
     * Returns true if the cell at the given row and column is available for a block
     * to be placed over it. Blocks can only be placed over floors and exits. A
     * block cannot be placed over a cell that is occupied by another block.
     *
     * @param row row location of the cell
     * @param col column location of the cell
     * @return true if the cell is available for a block, otherwise false
     */
    public boolean canPlaceBlock(int row, int col) {
    	
    	if(!((grid[row][col].isFloor()) || (grid[row][col].isExit()) && grid[row][col].hasBlock()))
		{
			return true;
		}
		
		else
			return false;
    }

    /**
     * Returns the number of moves made so far in the game.
     *
     * @return the number of moves
     */
    public int getMoveCount() {
        
        return moveCount;
    }

    /**
     * Returns the number of rows of the board.
     *
     * @return number of rows
     */
    public int getRowSize() {
        
        return grid.length;
    }

    /**
     * Returns the number of columns of the board.
     *
     * @return number of columns
     */
    public int getColSize() {
        
        return grid[0].length;
    }

    /**
     * Returns the cell located at a given row and column.
     *
     * @param row the given row
     * @param col the given column
     * @return the cell at the specified location
     */
    public Cell getCell(int row, int col) {
        
        return grid[row][col];
    }

    /**
     * Returns a list of all blocks on the board.
     *
     * @return a list of all blocks
     */
    public ArrayList < Block > getBlocks() {
        
        return blocks;
    }

    /**
     * Returns true if the player has completed the puzzle by positioning a block
     * over an exit, false otherwise.
     *
     * @return true if the game is over
     */
    public boolean isGameOver() {


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Cell currCell = grid[i][j];
                if (currCell.isExit() && currCell.hasBlock() == true) {
                    isGameEnded = true;
                    return true;
                }

            }

        }
        isGameEnded = false;
        return isGameEnded;
    }

    /**
     * Moves the currently grabbed block by one cell in the given direction. A
     * horizontal block is only allowed to move right and left and a vertical block
     * is only allowed to move up and down. A block can only move over a cell that
     * is a floor or exit and is not already occupied by another block. The method
     * does nothing under any of the following conditions:
     * <ul>
     * <li>The game is over.</li>
     * <li>No block is currently grabbed by the user.</li>
     * <li>A block is currently grabbed by the user, but the block is not allowed to
     * move in the given direction.</li>
     * </ul>
     * If none of the above conditions are meet, the method does the following:
     * <ul>
     * <li>Moves the block object by calling its move method.</li>
     * <li>Sets the block for the grid cell that the block is being moved into.</li>
     * <li>For the grid cell that the block is being moved out of, sets the block to
     * null.</li>
     * <li>Moves the currently grabbed cell by one cell in the same moved direction.
     * The purpose of this is to make the currently grabbed cell move with the block
     * as it is being dragged by the user.</li>
     * <li>Adds the move to the end of the moveHistory list.</li>
     * <li>Increment the count of total moves made in the game.</li>
     * </ul>
     *
     * @param dir the direction to move
     */
    public void moveGrabbedBlock(Direction dir) {

    	cellMovedTo = cellBlockGrabbed;
    	
    	if(isGameOver() != true && getGrabbedBlock() != null)
		{
			
			if(grabbedBlock.getOrientation() == VERTICAL)
			{
				if(dir == Direction.UP && grabbedBlock.getFirstRow() != 1)
				{
					 cellMovedTo = grid[grabbedBlock.getFirstRow() - 1][grabbedBlock.getFirstCol()];
	                    if (cellMovedTo.isWall() != true && cellMovedTo.hasBlock() == false)
	                    {
	                        cellBlockGrabbed = grid[grabbedBlock.getFirstRow() + 1][grabbedBlock.getFirstCol()];
	                        grabbedBlock.move(dir);
	                        cellMovedTo.setBlock(grabbedBlock);
	                        cellBlockGrabbed.setBlock(null);

	                        moveHistory.add(new Move(grabbedBlock, dir));
	                        moveCount++;
	                        
	                        if (cellMovedTo.isExit() == true)
	                            isGameEnded = true;
	                    }       
				
	                        
					
				}
				
				else if(dir == Direction.DOWN && grabbedBlock.getFirstRow() != grid.length)
				{
					cellMovedTo = grid[grabbedBlock.getFirstRow() + grabbedBlock.getLength()][grabbedBlock.getFirstCol()];
                    if (cellMovedTo.isWall() != true && cellMovedTo.hasBlock() == false) 
                    {
                        cellBlockGrabbed = grid[grabbedBlock.getFirstRow()][grabbedBlock.getFirstCol()];
                        grabbedBlock.move(dir);
                        cellMovedTo.setBlock(grabbedBlock);
                        cellBlockGrabbed.setBlock(null);

                        moveHistory.add(new Move(grabbedBlock, dir));
                        moveCount++;
                        
                        if (cellMovedTo.isExit() == true) 
                            isGameEnded = true;
                    }
                        
				}
			
			}
			
			
			else if(grabbedBlock.getOrientation() == HORIZONTAL)
			{
				if(dir == Direction.RIGHT && grabbedBlock.getFirstCol() != grid[0].length)
				{
					  cellMovedTo = grid[grabbedBlock.getFirstRow()][grabbedBlock.getFirstCol() + grabbedBlock.getLength()];//
	                    if (cellMovedTo.isWall() != true && cellMovedTo.hasBlock() == false)
	                    {
	                        cellBlockGrabbed = grid[grabbedBlock.getFirstRow()][grabbedBlock.getFirstCol()];
	                        grabbedBlock.move(dir);
	                        cellMovedTo.setBlock(grabbedBlock);
	                        cellBlockGrabbed.setBlock(null);

	                        moveHistory.add(new Move(grabbedBlock, dir));
	                        moveCount++;
	                        
	                        if (cellMovedTo.isExit() == true) 
	                            isGameEnded = true;
	                        
	                    }   
					
				}
				
				else if(dir == Direction.LEFT && grabbedBlock.getFirstCol() != 1)
				{
					cellMovedTo = grid[grabbedBlock.getFirstRow()][grabbedBlock.getFirstCol() - 1];
                    if (cellMovedTo.isWall() != true && cellMovedTo.hasBlock() == false) 
                    {
                        cellBlockGrabbed = grid[grabbedBlock.getFirstRow()][grabbedBlock.getFirstCol() + 1];
                        grabbedBlock.move(dir);
                        cellMovedTo.setBlock(grabbedBlock);
                        cellBlockGrabbed.setBlock(null);

                        moveHistory.add(new Move(grabbedBlock, dir));
                        moveCount++;
                        if (cellMovedTo.isExit() == true) 
                            isGameEnded = true;
                        
                    }

                }
				
			}
				
			
			
		}
    	
    	releaseBlock();
    	

    }

    /**
     * Resets the state of the game back to the start, which includes the move
     * count, the move history, and whether the game is over. The method calls the
     * reset method of each block object. It also updates each grid cells by calling
     * their setBlock method to either set a block if one is located over the cell
     * or set null if no block is located over the cell.
     */
    public void reset() {
        
        moveCount = 0;
        isGameEnded = false;
        moveHistory.clear();
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).reset();
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j].clearBlock();
            }
        }

        for (int i = 0; i < blocks.size(); i++) {

            grid[blocks.get(i).getFirstRow()][blocks.get(i).getFirstCol()].setBlock(blocks.get(i));

            if (blocks.get(i).getOrientation() == HORIZONTAL) {
                grid[blocks.get(i).getFirstRow()][blocks.get(i).getFirstCol() + 1].setBlock(blocks.get(i));
            } else if(blocks.get(i).getOrientation() == VERTICAL) {
                grid[blocks.get(i).getFirstRow() + 1][blocks.get(i).getFirstCol()].setBlock(blocks.get(i));
            }
        }

    }

    /**
     * Returns a list of all legal moves that can be made by any block on the
     * current board. If the game is over there are no legal moves.
     *
     * @return a list of legal moves
     */
    public ArrayList < Move > getAllPossibleMoves() {
        
        possibleMoves = new ArrayList < Move > ();
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getOrientation() == HORIZONTAL) {
                if (grid[blocks.get(i).getFirstRow()][blocks.get(i).getFirstCol() + 2].hasBlock() == false && grid[blocks.get(i).getFirstRow()][blocks.get(i).getFirstCol() + 2].isWall() == false) {
                    possibleMoves.add(new Move(blocks.get(i), RIGHT));
                } else if (grid[blocks.get(i).getFirstRow()][blocks.get(i).getFirstCol() - 1].hasBlock() == false && grid[blocks.get(i).getFirstRow()][blocks.get(i).getFirstCol() - 1].isWall() == false) {
                    possibleMoves.add(new Move(blocks.get(i), LEFT));
                }
            } else if (blocks.get(i).getOrientation() == VERTICAL) {
                if (grid[blocks.get(i).getFirstRow() - 1][blocks.get(i).getFirstCol()].hasBlock() == false && grid[blocks.get(i).getFirstRow() - 1][blocks.get(i).getFirstCol()].isWall() == false) {
                    possibleMoves.add(new Move(blocks.get(i), UP));
                } else if (grid[blocks.get(i).getFirstRow() + 2][blocks.get(i).getFirstCol()].hasBlock() == false && grid[blocks.get(i).getFirstRow() + 2][blocks.get(i).getFirstCol()].isWall() == false) {
                    possibleMoves.add(new Move(blocks.get(i), DOWN));
                }
            }
        }

        return possibleMoves;
    }

    /**
     * Gets the list of all moves performed to get to the current position on the
     * board.
     *
     * @return a list of moves performed to get to the current position
     */
    public ArrayList < Move > getMoveHistory() {
        
        return moveHistory;
    }

    /**
     * EXTRA CREDIT 5 POINTS
     * <p>
     * This method is only used by the Solver.
     * <p>
     * Undo the previous move. The method gets the last move on the moveHistory list
     * and performs the opposite actions of that move, which are the following:
     * <ul>
     * <li>grabs the moved block and calls moveGrabbedBlock passing the opposite
     * direction</li>
     * <li>decreases the total move count by two to undo the effect of calling
     * moveGrabbedBlock twice</li>
     * <li>if required, sets is game over to false</li>
     * <li>removes the move from the moveHistory list</li>
     * </ul>
     * If the moveHistory list is empty this method does nothing.
     */
    public void undoMove() {
        
    	if(moveHistory.size()==0)
			return;
		
		isGameEnded = false;
		Move m = moveHistory.remove(moveHistory.size()-1);
		grabbedBlock = m.getBlock();
		
		if(m.getDirection()== RIGHT)
			moveGrabbedBlock(LEFT);
		
		else if(m.getDirection()== LEFT)
			moveGrabbedBlock(RIGHT);
		
		else if(m.getDirection()== UP)
			moveGrabbedBlock(DOWN);
		
		else if(m.getDirection()== DOWN)
			moveGrabbedBlock(UP);
		
		moveHistory.remove(moveHistory.size()-1);
    }


    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        boolean first = true;
        for (Cell row[]: grid) {
            if (!first) {
                buff.append("\n");
            } else {
                first = false;
            }
            for (Cell cell: row) {
                buff.append(cell.toString());
                buff.append(" ");
            }
        }
        return buff.toString();
    }
}
