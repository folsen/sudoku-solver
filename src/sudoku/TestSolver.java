package sudoku;

import org.junit.Test;

import junit.framework.TestCase;


public class TestSolver extends TestCase {

	@Test
	public final void testSolve() {
		int[][] input =  {{0,0,8,0,0,9,0,6,2},
						  {0,0,0,0,0,0,0,0,5},
						  {1,0,2,5,0,0,0,0,0},
						  {0,0,0,2,1,0,0,9,0},
						  {0,5,0,0,0,0,6,0,0},
						  {6,0,0,0,0,0,0,2,8},
					   	  {4,1,0,6,0,8,0,0,0},
						  {8,6,0,0,3,0,1,0,0},
						  {0,0,0,0,0,0,4,0,0}};
		int[][] correct = {{5,4,8,1,7,9,3,6,2},
							{3,7,6,8,2,4,9,1,5},
							{1,9,2,5,6,3,8,7,4},
							{7,8,4,2,1,6,5,9,3},
							{2,5,9,3,8,7,6,4,1},
							{6,3,1,9,4,5,7,2,8},
							{4,1,5,6,9,8,2,3,7},
							{8,6,7,4,3,2,1,5,9},
							{9,2,3,7,5,1,4,8,6}};
		Sudoku su = new Sudoku(input);
		
		assertTrue("should be able to solve", su.solve(0,0));
		boolean flag = true;
		for(int i = 0;i<9;i++) {
			for(int k = 0;k<9;k++) {
				if(su.getResults()[i][k] != correct[i][k])
					flag = false;
			}
		}
		assertTrue("should return correct solution", flag);
	}
	@Test
	public final void testChkAllow() {
		int[][] input =  {{0,0,8,0,0,9,0,6,2},
				  		  {0,0,0,0,0,0,0,0,5},
				  		  {1,0,2,5,0,0,0,0,0},
				  		  {0,0,0,2,1,0,0,9,0},
				  		  {0,5,0,0,0,0,6,0,0},
				  		  {6,0,0,0,0,0,0,2,8},
				  		  {4,1,0,6,0,8,0,0,0},
				  		  {8,6,0,0,3,0,1,0,0},
				  		  {0,0,0,0,0,0,4,0,0}};
		Sudoku su = new Sudoku(input);
		assertTrue("box 7,1 insatt originalvärde",su.chkAllow(6,0,input[6][0]));

	}
}