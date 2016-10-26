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
		int counter = 1;
		for (int x = 0; x < GRID_SIZE; x++){
			for (int y = 0; y < GRID_SIZE; y++){
				if ((int)grid[x][y] != (counter + 48)){ //<-- Converting char to ASCII and comparing with counter 
					isEmpty = false;
				}
				counter ++;
			}
		}
		assertEquals(true, isEmpty);
	}

	// 3
	@Test
	public void testGetCell(){
		assertEquals('5', s.getCell(1,1));
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

	// 6
	@Test
        public void testIsItEmpty2(){
                s.setCell(0,1,PLAYER_X);
                assertEquals(true, s.isItEmpty(0,0));
        }

	// 7
	@Test
	public void testIsItAValidNumber(){
		assertEquals(false, s.isItAValidNumber("Ex"));
	}
	
	// 8
	@Test
	public void testIsItAValidNumber2(){
		assertEquals(true, s.isItAValidNumber("3"));
	}

	// 9
	@Test
	public void testIsItAValidNumber3(){
		assertEquals(false, s.isItAValidNumber("15"));
	}

	// 10
	@Test
        public void testGetCurrentPlayer(){
                assertEquals(PLAYER_X, s.getCurrentPlayer());
        }
	
	// 11
	@Test
	public void testSwitchPlayer(){
		s.switchPlayer();
		assertEquals(PLAYER_O, s.getCurrentPlayer());
	}

	// 12
	@Test
	public void testSwitchPlayerBack(){
		s.switchPlayer();
		s.switchPlayer();
		assertEquals(PLAYER_X, s.getCurrentPlayer());
	}

	//13 
	@Test
	public void testHorizontalWin(){
		for(int i = 0; i < GRID_SIZE; i++){
			grid[0][i] = PLAYER_X;	
		}
		assertEquals(PLAYER_X, s.checkHorizontal());
	}

        //14
        @Test
        public void testHorizontalNotWin(){
                grid[0][0] = PLAYER_X;
		grid[0][1] = PLAYER_X;
		assertEquals('F', s.checkHorizontal());       
	}	
	//15
	@Test
	public void testVerticalWin(){
                for(int j = 0; j < GRID_SIZE; j++){
                        grid[j][0] = PLAYER_O;
                }
                assertEquals(PLAYER_O, s.checkVertical());
	}

	//16
	@Test
	public void testVerticalNotWin(){
		grid[0][0] = PLAYER_O;
		grid[1][0] = PLAYER_O;
		grid[2][0] = PLAYER_X;
		assertEquals('F', s.checkVertical());
	}
	//17
	@Test
        public void testDiagonalWin(){
		for(int i = 0; i < GRID_SIZE; i++){
			grid[i][i] = PLAYER_X;
		}
                assertEquals(PLAYER_X, s.checkDiagonal());
        }

	//18
	@Test
	public void testDiagonalNotWin(){
		grid[0][0] = PLAYER_O;
		grid[2][2] = PLAYER_O;
		assertEquals('F', s.checkDiagonal());
	}
	
	//19
	@Test
	public void testCheckIfSomeoneWon(){
		for(int i = 0; i < GRID_SIZE; i++){
                        grid[0][i] = PLAYER_X;
                }
		assertEquals(true, s.checkIfSomeoneWon());
	}

	//20
	@Test
        public void testCheckIfSomeoneDidNotWin(){
                grid[0][0] = PLAYER_X;
                grid[0][1] = PLAYER_X;
                assertEquals(false, s.checkIfSomeoneWon());
        }

	//21
	@Test
	public void testCheckIfGridIsNotFull(){
		grid[1][2] = PLAYER_X;
		grid[1][1] = PLAYER_O;
		assertEquals(false, s.checkIfGridIsFull());
	}

	//22
	@Test
	public void testCheckIfGridIsFull(){
		grid[0][0] = PLAYER_X;
		grid[1][0] = PLAYER_O;
		grid[2][0] = PLAYER_X;
		grid[0][1] = PLAYER_O;
		grid[1][1] = PLAYER_X;
		grid[2][1] = PLAYER_O;
		grid[0][2] = PLAYER_X;
		grid[1][2] = PLAYER_O;
		grid[2][2] = PLAYER_X;
		assertEquals(true, s.checkIfGridIsFull());
	}
}  
