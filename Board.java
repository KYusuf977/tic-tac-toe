import java.util.Arrays;

public class Board {

	private char[][] board;
	private char currentPlayer;

	/**
	 * This is the constructor for the class. It initializes the board so all cells
	 * in the board are equal to '-'. The currentPlayer is initialized to 'x'.
	 *
	 */
	public Board() {
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
		this.currentPlayer = 'x';

	}

	/**
	 * The method outputs the board in the following format. First the message
	 * "Current board" underlined is printed. Then the content of the board is
	 * printed as a 3 by 3 matrix.
	 */
	public void print() {
		System.out.println("Current Board");
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			for (int h = 0; h < 3; h++) {
				System.out.print(this.board[i][h] + "  ");
			}
			System.out.println();
		}
	}

	/**
	 * The method checks if all the positions on the board have been played.
	 *
	 * @return true if all the cells in the board are different than '-', false
	 *         otherwise.
	 */
	public boolean isFull() {
		boolean check = false;
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int h = 0; h < 3; h++) {
				if (this.board[i][h] != '-') count++;
			}
		}
		if (count == 9) check = true;
		return check;

	}

	/**
	 * The method checks if there is a winner.
	 *
	 * @return true if either a column, a row or a diagonal is filled by the same
	 *         character and the character is different than '-', false otherwise.
	 */
	public boolean isWin() {
		boolean checkIfWin = false;
		if (checkRows() == true) checkIfWin = true;
		if (checkColumns() == true) checkIfWin = true;
		if (checkDiagonals() == true) checkIfWin = true;
		
		return checkIfWin;

	}

	/**
	 * The method checks if at least one row is occupied by the same player.
	 *
	 * @return true if any row is filled by the same character and the character is
	 *         different than '-', false otherwise.
	 */
	private boolean checkRows() {
		boolean checkRows = false;
		for (int i = 0; i < 3; i++) {
			int check = 0;
			int check1 = 0;
			for (int h = 0; h < 3; h++) {
				if (this.board[i][h] == 'x') check++;
			    else if (this.board[i][h] == 'o') check1++;
			}
			if (check == 3 || check1 == 3) checkRows = true;
		}
		return checkRows;
	}

	/**
	 * The method checks if at least one column is occupied by the same player.
	 *
	 * @return true if any column is filled by the same character and the character
	 *         is different than '-', false otherwise.
	 */
	private boolean checkColumns() {
		boolean checkRows = false;
		for (int i = 0; i < 3; i++) {
			int check = 0;
			int check1 = 0;
			for (int h = 0; h < 3; h++) {
				if (this.board[h][i] == 'x') check++;
			    else if (this.board[h][i] == 'o') check1++;
			}
			if (check == 3 || check1 == 3) checkRows = true;
		}
		return checkRows;

	}

	/**
	 * The method checks if at least one diagonal is occupied by the same player.
	 *
	 * @return true if any diagonal is filled by the same character and the
	 *         character is different than '-', false otherwise.
	 */
	private boolean checkDiagonals() {
		boolean booCheck = false;
		
		if (this.board[0][0] == 'x' && this.board[1][1] == 'x' && this.board[2][2] == 'x') booCheck=true;
		if (this.board[0][0] == 'o' && this.board[1][1] == 'o' && this.board[2][2] == 'o') booCheck=true;
		if (this.board[0][2] == 'x' && this.board[1][1] == 'x' && this.board[2][0] == 'x') booCheck=true;
		if (this.board[0][2] == 'o' && this.board[1][1] == 'o' && this.board[2][0] == 'o') booCheck=true;
		
		return booCheck;

	}

	/**
	 * The method changes the currentPlayer. If the currentPlayer is 'x', it changes
	 * to 'o'. If the currentPlayer is 'o', it changes to 'x'.
	 *
	 */
	public void changePlayer() {
		if (currentPlayer == 'x') currentPlayer = 'o';
		else if (currentPlayer == 'o') currentPlayer = 'x';
	}

	/**
	 * The method attempts to set the cell on the position indicated by the row and
	 * column given to the currentPlayer value if the cell is unoccupied (equal to
	 * '-') in which case returns true. If the position is occupied (not equal to
	 * '-') the cell remains unchanged and the method returns false.
	 *
	 */
	public char currPlayer() {
		return currentPlayer;
	}
	
	public boolean setRowCol(int row, int col) {
		boolean check = false;
		if (this.board[row][col] == '-') {
			check = true;
			this.board[row][col] = currentPlayer;
		} 
		
		return check;
	}
}
