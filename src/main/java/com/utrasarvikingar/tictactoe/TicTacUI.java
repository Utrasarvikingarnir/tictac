package com.utrasarvikingar.tictactoe;

public class TicTacUI {

	private TicTacService s = new TicTacService();
	private final int GRID_SIZE = 3;

	public void showGrid(){
		System.out.println("  TICTACTOE");
		System.out.println("-------------");
		for(int i = 0; i < GRID_SIZE; i++){
			System.out.print("| ");
			for(int j = 0; j < GRID_SIZE; j++){
				System.out.print(" " + " | ");
				
			}			
			System.out.println();
			System.out.println("-------------");
		}
	}

	public static void initMsg(){
		System.out.println("  This is a TicTacToe game made by Utrasarvikingar!");
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println("Player X starts");
		System.out.println();
	}

	public void  invalidInput(){
		System.out.println("The input has to be a number between 1 and 9!");
		System.out.println("Please enter a number");
	}

	public void invalidNumber(){
		System.out.println("The number you chose is taken!");
		System.out.println("Please enter another number");
	}
}
