package com.utrasarvikingar.tictactoe;


public class TicTacService{
	private char grid[][];
	private final char GRID_SIZE = 3;
	private final char PLAYER_X = 'X';
        private final char PLAYER_O = 'O';
	private char currentPlayer;

	public TicTacService(){
                grid = new char[GRID_SIZE][GRID_SIZE];
                createGrid();
		currentPlayer = PLAYER_X;
        }

	public void createGrid(){
		int counter = 1;
		for (int x = 0; x < GRID_SIZE; x++){
			for (int y = 0; y < GRID_SIZE; y++){
				char temp = (char) (counter + 48); //<-- Converting int to char using ASCII values
				grid[x][y] = temp;
				counter ++;
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
	
	// Test 5 and 6
	 public boolean isItEmpty(int i, int j){
	 	if(grid[i][j] == 'X' || grid[i][j] == 'O'){
	 		return false;
	 	}
	 	else {
	 		return true;
	 	}
	}

	// Test 7, 8 and 9
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

	// Test 10
        public char getCurrentPlayer(){
                return currentPlayer;
        }
	
	// Test 11 and 12
	public void switchPlayer() {
		char p = getCurrentPlayer();
		if(p == PLAYER_X){
			currentPlayer = PLAYER_O;
		}
		else{
			currentPlayer = PLAYER_X;
		}
	}
	
	// Test 13 and 14
	        public char checkHorizontal(){
                for(int i = 0; i < GRID_SIZE; i++){
                        if(getCell(i, 0) == getCell(i, 1) && getCell(i, 1) == getCell(i, 2)){
                                return getCell(i, 0);
                        }
                }
                return 'F';
        }		
}
