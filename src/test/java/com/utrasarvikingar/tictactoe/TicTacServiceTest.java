package com.utrasarvikingar.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacServiceTest{
	private char grid[][];
	private final char EMPTY = ' ';
	private final int GRID_SIZE = 3;

	public static void main(String args[]){
		org.junit.runner.JUnitCore.main("com.utrasarvikingar.TicTacServiceTest");
	}
	private TicTacService s = new TicTacService();

	// 1
	@Test
	public void testGridSize(){
		assertEquals(9, s.getSize());
	}

	// 2
	@Test
	public void testEmptyGrid(){
		boolean isEmpty = true;
		grid = s.getGrid();
		for (int x = 0; x < GRID_SIZE; x++){
			for (int y = 0; y < GRID_SIZE; y++){
				if (grid[x][y] != EMPTY){
					isEmpty = false;
				}
			}
		}
		assertEquals(true, isEmpty);
	}

}
