package hw3;

import static api.Direction.*;
import static api.Orientation.HORIZONTAL;

import api.Direction;
import api.Orientation;

/**
 * Represents a block in the Block Slider game.
 * @author ARYAN RAO
 */
public class Block {
	
	
	private int first_Row; // row for reseting
	private int first_Col; // column for reseting
	
	
	private int row; // first row of block
	private int col; // first column of block
	private int len; // length of block
	private Orientation ori; // orientation of block
	
	/**
	 * Constructs a new Block with a specific location relative to the board. The
	 * upper/left most corner of the block is given as firstRow and firstCol. All
	 * blocks are only one cell wide. The length of the block is specified in cells.
	 * The block can either be horizontal or vertical on the board as specified by
	 * orientation.
	 * 
	 * @param firstRow    the first row that contains the block
	 * @param firstCol    the first column that contains the block
	 * @param length      block length in cells
	 * @param orientation either HORIZONTAL or VERTICAL
	 */
	public Block(int firstRow, int firstCol, int length, Orientation orientation) {
		
		this.first_Row = firstRow;
		this.first_Col = firstCol;
		
		
		row = firstRow;
		col = firstCol;
		len = length;
		ori = orientation;
	}

	/**
	 * Resets the position of the block to the original firstRow and firstCol values
	 * that were passed to the constructor during initialization of the the block.
	 */
	public void reset() {
		
          row = first_Row;
          col = first_Col;
	}

	/**
	 * Move the blocks position by one cell in the direction specified. The blocks
	 * first column and row should be updated. The method will only move VERTICAL
	 * blocks UP or DOWN and HORIZONTAL blocks RIGHT or LEFT. Invalid movements are
	 * ignored.
	 * 
	 * @param dir direction to move (UP, DOWN, RIGHT, or LEFT)
	 */
	public void move(Direction dir) {
		
		if(ori == Orientation.VERTICAL)
		{
		if(dir == Direction.UP)
		{
			row-=1;
		}
		
		else if(dir == Direction.DOWN)
		{
			row+=1;
		}
		
		}
		
		else if(ori == Orientation.HORIZONTAL)
		{
		if(dir == Direction.LEFT)
		{
			col-=1;
		}
		
		else if(dir == Direction.RIGHT)
		{
			col+=1;
			
		}
		}
	}

	/**
	 * Gets the first row of the block on the board.
	 * 
	 * @return first row
	 */
	public int getFirstRow() {
		
		//return first_Row;
	    return row;
		
	}

	/**
	 * Sets the first row of the block on the board.
	 * 
	 * @param firstRow first row
	 */
	public void setFirstRow(int firstRow) {
		
		//first_Row = firstRow;
		row = firstRow;
	}

	/**
	 * Gets the first column of the block on the board.
	 * 
	 * @return first column
	 */
	public int getFirstCol() {
		
		//return first_Col;
		return col;
	}

	/**
	 * Sets the first column of the block on the board.
	 * 
	 * @param firstCol first column
	 */
	public void setFirstCol(int firstCol) {
		
		//first_Col = firstCol;
		col = firstCol;
	}

	/**
	 * Gets the length of the block.
	 * 
	 * @return length measured in cells
	 */
	public int getLength() {
		
		return len;
	}

	/**
	 * Gets the orientation of the block.
	 * 
	 * @return either VERTICAL or HORIZONTAL
	 */
	public Orientation getOrientation() {
		
		return ori;
	}

	@Override
	public String toString() {
		return "(row=" + getFirstRow() + ", col=" + getFirstCol() + ", len=" + getLength()
				+ ", ori=" + getOrientation() + ")";
	}
	
	public static void main(String args[]) {
		Block block = new Block(2, 1, 2, HORIZONTAL);
		System.out.println("Block is " + block);
		block.move(DOWN);
		System.out.println("After move DOWN, block is " + block);
		System.out.println("Expected block at (row=2, col=1).");
		block.move(RIGHT);
		System.out.println("After move RIGHT, block is " + block);
		System.out.println("Expected block at (row=2, col=2).");
		System.out.println();
	}
}
