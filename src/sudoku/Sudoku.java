package sudoku;
/**
 * This is the Sudoku model that contains all the solving algorithms
 */
public class Sudoku {

	private int[][] sudokuMatrix;
	private int[][] original; 
	
	public Sudoku(int[][] sudokuMatrix) {
		this.sudokuMatrix = sudokuMatrix;
		this.original = sudokuMatrix;
	}
	/**
	 * Gets a place in the working-matrix.
	 * @param row Which row to get
	 * @param column Which column to get
	 * @return Returns the integer of that place in the matrix
	 */
	public int get(int row, int column) {
		return sudokuMatrix[row][column];
	}
	/**
	 * Set a place in the working-matrix
	 * @param row Which row to set
	 * @param column Which column to set
	 * @param value What you want to set the place too
	 */
	public void set(int row, int column, int value) {
		sudokuMatrix[row][column] = value;
	}
	/**
	 * The backtracking algorithm that solves the sudoku.
	 * @param row What row to start the solving at
	 * @param column What column to start the solving at
	 * @return Returns true if the sudoku was solved and false if it is unsolvable.
	 */
	public boolean solve(int row, int column) {
		if (chkNotDef(row,column)) {
			for (int i = 1; i <= 9; i++) {
				if (chkAllow(row,column,i)) {	
					set(row,column,i);
					if (row == 8 && column == 8) {
						return true;
					} else if(column == 8) {
						if(solve(row+1,0)) return true;
					} else {
						if(solve(row,column+1)) return true;
					}
				}
			}
			set(row,column,0);
			return false;
		} else {
			if (!chkAllow(row,column,original[row][column])) {
				return false;
			}
			if (column == 8 && row == 8) {
				return true;
			} else if (column == 8) {
				return solve(row+1,0);
			} else {
				return solve(row,column+1);
			}
		}
	}
	/**
	 * Check if a place in the original given matrix is predefined or not.
	 * @param row Row to check
	 * @param column Column to check
	 * @return Returns true if the place was defined in the original matrix, false if it was not.
	 */
	public boolean chkNotDef(int row, int column) {
		//Predefined//
		if (original[row][column] == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks to see if a given value is allowed to be at a given place
	 * according to the sudoku rules.
	 * @param row Row to check if the value is allowed
	 * @param column Column to check if the value is allowed
	 * @param value The value to check if it is allowed
	 */
	public boolean chkAllow(int row, int column, int value) {
		// Column //
		for (int i = 0; i < 9; i++) {
			if(i != row) {
				if (get(i,column) == value) 
					return false;
			}
		}
		//Row//
		for (int i = 0; i < 9; i++) {
			if(i != column) {
				if (get(row,i) == value) 
					return false;
			}
		}
		
		// Region //
		int xr = row/3*3;
		int yr = column/3*3;
		for (int i = xr; i <= xr+2; i++) {
			for (int j = yr; j <= yr+2; j++) {
				if (i != row && j != column) {
					if (get(i,j) == value)
						return false;
				}
			}
		}
		
		return true;
	}
	/**
	 * This gets the working-matrix. If solve(0,0) has at some time been run
	 * and has returned true. This will return the solved matrix.
	 * @return Returns an int matrix
	 */
	public int[][] getResults() {
		return sudokuMatrix;
	}
	
}