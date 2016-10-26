package com.utrasarvikingar.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacServiceTest{


	public static void main(String args[]){
		org.junit.runner.JUnitCore.main("com.utrasarvikingar.TicTacServiceTest");
	}
	private TicTacService s = new TicTacService();

	private char[][] grid = s.getGrid();
	private final int GRID_SIZE = 3;
	private final char EMPTY = ' ';
	private final char PLAYER_X = 'X';
	private final char PLAYER_O = 'O';

	// 1
	@Test
	public void testGridSize(){
		assertEquals(9, s.getSize());
	}

	// 2
	@Test
	public void testEmptyGrid(){
		boolean isEmpty = true;
		for (int x = 0; x < GRID_SIZE; x++){
			for (int y = 0; y < GRID_SIZE; y++){
				if (grid[x][y] != EMPTY){
					isEmpty = false;
				}
			}
		}
		assertEquals(true, isEmpty);
	}

	// 3
	@Test
	public void testGetCell(){
		assertEquals(' ', s.getCell(1,1));
	}

	// 4
	@Test
	public void testSetCell(){
		s.setCell(0,1,PLAYER_X);
		assertEquals('X', grid[0][1]);
	}

	// 5
	@Test
	public void testIsItEmpty(){
                s.setCell(0,1,PLAYER_X);
                assertEquals(false, s.isItEmpty(0,1));
        }

	@Test
        public void testIsItEmpty2(){
                s.setCell(0,1,PLAYER_X);
                assertEquals(true, s.isItEmpty(0,0));
        }

	// 6
	@Test
	public void testIsItAValidNumber(){
		assertEquals(false, s.isItAValidNumber("Ex"));
	}

	@Test
	public void testIsItAValidNumber2(){
		assertEquals(true, s.isItAValidNumber("3"));
	}

	@Test
	public void testIsItAValidNumber3(){
		assertEquals(false, s.isItAValidNumber("15"));
	}

	// 7
	@Test
        public void testGetCurrentPlayer(){
                assertEquals(PLAYER_X, s.getCurrentPlayer());
        }
}  
