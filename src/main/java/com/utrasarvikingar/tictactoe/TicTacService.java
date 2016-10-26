package com.utrasarvikingar.tictactoe;


public class TicTacService{
	private char grid[][];
	private final char EMPTY = ' ';
	private final int GRID_SIZE = 3;
	private final char PLAYER_X = 'X';
        private final char PLAYER_O = 'O';
	private char currentPlayer;

	public TicTacService(){
                grid = new char[GRID_SIZE][GRID_SIZE];
                createGrid();
		currentPlayer = PLAYER_X;
        }

	public void createGrid(){
		for (int x = 0; x < GRID_SIZE; x++){
			for (int y = 0; y < GRID_SIZE; y++){
				grid[x][y] = EMPTY;
			}
		}
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

	// Test 2
	public char[][] getGrid(){
		return grid;
	}

	// Test 3
	public char getCell(int i, int j){
		return grid[i][j];
	}

	// Test 4
	public void setCell(int i, int j, char p) {
		grid[i][j] = p;
	}
	
	// Test 5
	 public boolean isItEmpty(int i, int j){
	 	if(grid[i][j] == 'X' || grid[i][j] == 'O'){
	 		return false;
	 	}
	 	else {
	 		return true;
	 	}
	}

	// Test 6
	public boolean isItAValidNumber(String s){
		int i;
		try{
			i = Integer.parseInt(s);
		}
		catch (NumberFormatException ex){
			return false;
		}
		if (i < 1 || i > 9){
			return false;
		}
		else {
			return true;
		}
	}

	// Test 7
        public char getCurrentPlayer(){
                return currentPlayer;
        }
	
	
}

