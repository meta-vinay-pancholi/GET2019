import java.util.Scanner;
/**
 * N Queens Problem using Recursion
 */
public class NQueenProblem {

	/**
	 * @param board
	 * @param row
	 * @param column
	 * function returning true if it is safe to place queen at [row][column] position otherwise returning false
	 */
	public boolean isSafe(int board[][], int row, int column) {
		// Checking columns
		for (int i = 0; i < row; i++) {
			if (board[i][column] == 1)
				return false;
		}

		// Check for left diagonal
		int x = row;
		int y = column;
		while (x >= 0 && y >= 0) {
			if (board[x][y] == 1)
				return false;
			x--;
			y--;
		}

		// Check for right diagonal
		x = row;
		y = column;
		while (x >= 0 && y < board.length) {
			if (board[x][y] == 1)
				return false;
			x--;
			y++;
		}
		return true;
	}

	/**
	 * @param board
	 * @param row
	 * function return true if all queen are placed else false
	 */
	public boolean solveNQueen(int board[][], int row) {
		if (row == board.length) {
			return true;
		}

		for (int col = 0; col < board.length; col++) {
			// To check whether next Queen can be placed or not!
			if (isSafe(board, row, col)) {
				board[row][col] = 1;
				boolean canPlaceNextQueen = solveNQueen(board, row + 1);
				// backtracking
				if (canPlaceNextQueen) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
	
	/**
	 * @param board
	 * Different function for printing values of board 
	 */
	public int[][] printValue(int[][] board ) {
		if (solveNQueen(board,0)) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j] + "   ");
				}
				System.out.println("\n");
			}
		 }
		 return board;
	 }
}
