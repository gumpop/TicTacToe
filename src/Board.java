/*
 * Class: Board
 * Author: Mallorie Mackay
 * Purpose: Contains the array with information for the board, has funtions to print the board and place Xs and Os
 */


public class Board {
	private static final int BOARD_SIZE = 3; // set board size variable
	private char[][] board; //double array holds the board information

	public Board() {
		board = new char[BOARD_SIZE][BOARD_SIZE];
	}

	//complete players's turn. if player's choice is already taken, return false. Handle a wrong choice in the tic tac toe game class.
	public boolean takeTurn(char choice, char player) {
		switch(choice) {
		case '1':
			if(board[0][0]=='X' || board[0][0]=='O') return false; //if the space has been selected, return false
			board[0][0] = player; //if not, place an X
			break;
		case '2':
			if(board[0][1]=='X' || board[0][1]=='O') return false;
			board[0][1] = player;
			break;
		case '3':
			if(board[0][2]=='X' || board[0][2]=='O') return false;
			board[0][2] = player;
			break;
		case '4':
			if(board[1][0]=='X' || board[1][0]=='O') return false;
			board[1][0] = player;
			break;
		case '5':
			if(board[1][1]=='X' || board[1][1]=='O') return false;
			board[1][1] = player;
			break;
		case '6':
			if(board[1][2]=='X' || board[1][2]=='O') return false;
			board[1][2] = player;
			break;
		case '7':
			if(board[2][0]=='X' || board[2][0]=='O') return false;
			board[2][0] = player;
			break;
		case '8':
			if(board[2][1]=='X' || board[2][1]=='O') return false;
			board[2][1] = player;
			break;
		case '9':
			if(board[2][2]=='X' || board[2][2]=='O') return false;
			board[2][2] = player;
			break;
		default: //if none of those, invalid move
			return false;
		}
		return true;
	}
	
	//used for mega TTT. It needs to ensure it has a valid choice, but does not want a letter assigned until the game is over
	public boolean isValid(char choice) {
		switch(choice) {
		case '1':
			if(board[0][0]=='X' || board[0][0]=='O' || board[0][0]=='-') return false; //if the space has been selected, return false
			break;
		case '2':
			if(board[0][1]=='X' || board[0][1]=='O' || board[0][1]=='-') return false;
			break;
		case '3':
			if(board[0][2]=='X' || board[0][2]=='O' || board[0][2]=='-') return false;
			break;
		case '4':
			if(board[1][0]=='X' || board[1][0]=='O' || board[1][0]=='-') return false;
			break;
		case '5':
			if(board[1][1]=='X' || board[1][1]=='O' || board[1][1]=='-') return false;
			break;
		case '6':
			if(board[1][2]=='X' || board[1][2]=='O' || board[1][2]=='-') return false;
			break;
		case '7':
			if(board[2][0]=='X' || board[2][0]=='O' || board[2][0]=='-') return false;
			break;
		case '8':
			if(board[2][1]=='X' || board[2][1]=='O' || board[2][1]=='-') return false;
			break;
		case '9':
			if(board[2][2]=='X' || board[2][2]=='O' || board[2][2]=='-') return false;
			break;
		default: //if none of those, invalid move
			return false;
		}
		return true;
	}
	//also for megaTTT
	public void setChar(int row, int col, char result) {
		board[row][col] = result;
	}
	
	//check for tie will be called after each round
	public boolean checkForTie() { //doesnt need to know player to check a tie
		for(char[] row: board) {
			for(char c: row) {
				if(c!='X' && c!='O' && c!='-') { // if the tile is NOT taken, it cant be a tie
					return false;
				}
			}
		}
		return true;
	}
	//check for win will be called in the game, and it will call methods for each possible win
	public boolean checkForWin(char player) {
		if(checkVertical(player)) return true;
		if(checkHorizontal(player)) return true;
		if(checkDiagonal(player)) return true;
		return false;
	}
	
	//****************METHODS TO CHECK FOR WINS*********************\\
	//all private since only board needs them
	private boolean checkVertical(char player) { //takes in the last player as only the most recent move can cause a win
		for(int col=0; col<BOARD_SIZE; col++) { //go through each column
			if(board[0][col] == player && board[1][col] == player && board[2][col] == player) { //if a column has a win
				return true;
			}
		}
		return false; //if no win is found, return false
	}

	private boolean checkHorizontal(char player) { //takes in the last player as only the most recent move can cause a win
		for(int row=0; row<BOARD_SIZE; row++) { //go through each column
			if(board[row][0] == player && board[row][1] == player && board[row][2] == player) { //if a row has a win
				return true;
			}
		}
		return false; //if no win is found, return false
	}

	private boolean checkDiagonal(char player) {
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) { //check for win on diagonal from top left
			return true;
		}
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player) { //check for win on diagonal from top right
			return true;
		}
		return false;
	}

	//reset function if user wants to play again
	public void setUp() {
		char num = '1'; //to be placed in each square, counting up
		for(int row=0; row<BOARD_SIZE; row++) {
			for(int col=0; col<BOARD_SIZE; col++) {
				board[row][col] = num;
				num++;
			}
		}
	}
	
	//Print out the board in a way the user will easily understand
	public void printBoard() {
		System.out.println();
		System.out.printf("  %c | %c | %c%n", board[0][0], board[0][1], board[0][2]); //first row
		System.out.println(" -----------"); //break for board layout
		System.out.printf("  %c | %c | %c %n", board[1][0], board[1][1], board[1][2]); //second row
		System.out.println(" -----------"); //break for board layout
		System.out.printf("  %c | %c | %c%n", board[2][0], board[2][1], board[2][2]); //third row
		System.out.println();
	}
}
