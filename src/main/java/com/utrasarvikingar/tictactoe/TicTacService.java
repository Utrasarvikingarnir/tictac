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

	// Test 15 and 16
	public char checkVertical(){
                for(int j = 0; j < GRID_SIZE; j++){
                        if(getCell(0, j) == getCell(1, j) && getCell(1, j) == getCell(2, j)){
                                return getCell(0, j);
                        }
                }
                return 'F';
        }

	// Test 17 and 18
	public char checkDiagonal(){
                if(getCell(0,0) == getCell(1,1) && getCell(1, 1) == getCell(2,2)){
                        return getCell(1,1);
                }
                else if(getCell(2,0) == getCell(1,1) && getCell(1, 1) ==getCell(0,2)){
                        return getCell(1,1);
                }
                else {
                        return 'F';
                }
        }

	// Test 19 and 20
	public boolean checkIfSomeoneWon(){
		if(checkHorizontal() == 'X' || checkHorizontal() == 'O'){
                        return true;
                }
                else if(checkVertical() == 'X' || checkVertical() == 'O'){
                        return true;
                }
                else if(checkDiagonal() == 'X' || checkDiagonal() == 'O'){
                        return true;
                }
                else {
                        return false;
                }
       }

	// Test 21 and 22
	public boolean checkIfGridIsFull(){
		boolean isFull = true;
		for (int i = 0; i < GRID_SIZE; i++){
			for (int j = 0; j < GRID_SIZE; j++){
				if (grid[i][j] != 'X' && grid[i][j] != 'O'){
					isFull = false;
				}
			}
		}
		return isFull;
	}

	public int getCellRow(char inputChar){
		int cellRow;
		if(inputChar == '1' || inputChar == '2' || inputChar == '3'){
			cellRow = 0;
		}
		else if(inputChar == '4' || inputChar == '5' || inputChar == '6'){
			cellRow = 1;
		}
		else{
			cellRow = 2;
		}
		return cellRow;
	}

	public int getCellCol(char inputChar) {
		int cellCol;
		if(inputChar == '1' || inputChar == '4' || inputChar == '7'){
			cellCol = 0;
		}
		else if(inputChar == '2' || inputChar == '5' || inputChar == '8'){
			cellCol = 1;
		}
		else{
			cellCol = 2;
		}
		return cellCol;
	}
}
