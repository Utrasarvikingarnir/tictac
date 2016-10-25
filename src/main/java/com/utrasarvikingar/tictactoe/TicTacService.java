package com.utrasarvikingar.tictactoe;


public class TicTacService{

	private char grid[][];
	private final char EMPTY = ' ';
	private final int GRID_SIZE = 3;


	public void createGrid(){
		for (int x = 0; x < GRID_SIZE; x++){
			for (int y = 0; y < GRID_SIZE; y++){
				grid[x][y] = EMPTY;
			}
		}
	}

	public void TicTacServie(){
		grid = new char[GRID_SIZE][GRID_SIZE];
		createGrid();
	}


	// Tests


	// Test 1
	public int getSize(){
		int size = 0;
		for (int x = 0; x < GRID_SIZE; x++){
			for (int y = 0; y < GRID_SIZE; y++){
				size++;
			}
		}
		return size;
	}

}