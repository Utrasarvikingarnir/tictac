package com.utrasarvikingar.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacServiceTest{

	public static void main(string args[]){
		org.junit.runner.JUnitCore.main("com.utrasarvikingar.TicTacServiceTest");
	}
	private TicTacService s = new TicTacService();

	// 1
	@Test
	public void testGridSize(){
		assertEquals(9, s.getSize());
	}

}