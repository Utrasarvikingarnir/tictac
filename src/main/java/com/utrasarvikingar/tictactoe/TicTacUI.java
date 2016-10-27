package com.utrasarvikingar.tictactoe;

import java.util.Scanner;

public class TicTacUI {

		
	private TicTacService s = new TicTacService();
	private final int GRID_SIZE = 3;
	private final char PLAYER_X = 'X';
	private final char PLAYER_O = 'O';
	private char grid[][];
	
	public void startNewGame() {
		Scanner input = new Scanner(System.in);
		String inputCharString;
		char inputChar;
		String again = "y";
		int row;
		int col;
		
		do{
			initMsg();

			while (true) {
				showGrid();

				if(s.getCurrentPlayer() == PLAYER_X) {
					playerX();
				}
				else {
					playerO();
				}

				inputCharString = input.nextLine();

				if(s.isItAValidNumber(inputCharString) == true) {
					inputChar = inputCharString.charAt(0);
					row = s.getCellRow(inputChar);
					col = s.getCellCol(inputChar);
				}
				else {
					invalidInput();
					continue;
				}

				if (s.isItEmpty (row, col) == false) {
					numberNA();
					continue;
				} 
				else {
					break;
				}
			}

			s.setCell(row, col, s.getCurrentPlayer());
									
			if (s.checkIfSomeoneWon() == true || s.checkIfGridIsFull() == true) {
				
				char player = s.getCurrentPlayer();
				boolean wasWinner = s.checkIfSomeoneWon();

				if (wasWinner) {
					if (player == PLAYER_X) {
						showGrid();
						winnerPlayerX();
					} 
					else {
						showGrid();
						winnerPlayerO();
					}
				}
				else {
					showGrid();
					draw();							
				}
				startAnother();
				again = input.nextLine();
				s.createGrid();
			}
			else {
				s.switchPlayer();
			}
		}
		while(again.equals("Y") || again.equals("y"));
	
		input.close();
	}		
	
	public void playerX() {
		System.out.println(" Player X,");
		System.out.println();
		System.out.println("Enter a number from 1-9");
		System.out.println();
	}
	
	public void playerO() {
		System.out.println(" Player O,");
		System.out.println();
		System.out.println("Enter a number from 1-9");
		System.out.println();
	}

	public void showGrid() {
		System.out.println("  TICTACTOE");
		System.out.println("-------------");
		grid = s.getGrid();
		for (int i = 0; i < GRID_SIZE; i++) {
			System.out.print("| ");
			for(int j = 0; j < GRID_SIZE; j++) {
			System.out.print(grid[i][j] + " | ");
		}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public static void initMsg() {
		System.out.println();
		System.out.println();
		System.out.println("  This is a TicTacToe game made by Utrasarvikingar!");
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println("Player X starts");
		System.out.println();
		System.out.println("Enter a number between 1 and 9:");
		System.out.println();
	}

	public void  invalidInput() {
		System.out.println();
		System.out.println("The input has to be a number between 1 and 9!");
		System.out.println();
		System.out.println("Please enter a valid number:");
		System.out.println();
	}

	public void numberNA() {
		System.out.println();
		System.out.println("The number is not available!");
		System.out.println();
		System.out.println("Please enter a valid number:");
		System.out.println();
	}
     
	public void winnerPlayerO() {
		System.out.println("=================");
		System.out.println(" PLAYER O WINS!");
 		System.out.println("================="); 
	}
	
	public void winnerPlayerX() {
		System.out.println("=================");
		System.out.println(" PLAYER X WINS!");
		System.out.println("=================");
	}
     
	public void draw() {
		System.out.println("=======");
		System.out.println(" DRAW!");
 		System.out.println("======="); 
	}
     
	public void startAnother() {
 		System.out.println();
 		System.out.println("Do you want to play  again?");
 		System.out.println("Type 'Y' for Yes!");
 		System.out.println("Type anything else for No!");
	}
     

}
