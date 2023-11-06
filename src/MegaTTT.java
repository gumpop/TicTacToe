/*
 * Class: MegaTTT
 * Author: Mallorie Mackay
 * Purpose: bigger tic tac toe!
 */

import java.util.Scanner;

public class MegaTTT {
	private static final int BOARD_SIZE = 3;
	private TicTacToe[][] boards;
	private Board board;

	public MegaTTT() {
		boards = new TicTacToe[BOARD_SIZE][BOARD_SIZE];
		board = new Board();
		for(int i=0; i<BOARD_SIZE; i++) {
			for(int j=0; j<BOARD_SIZE; j++) {
				boards[i][j] = new TicTacToe();
			}
		}
	}

	public char playGame() {
		board.setUp(); //set up the board to play
		//begin prompting the player for info
		System.out.println("Welcome to MEGA TicTacToe!\nPlayer X will go first. Pick a board to play first.");
		board.printBoard(); //print the board so the players can view it
		//loop until there is a WINNER!!!!
		boolean win = false;
		int round = 1; // start at first round, determine player based on round
		while(!win) {
			if(round%2 == 1) { //if the round is odd, its x's turn!
				startRound('X'); //make player x choose spot
				win = board.checkForWin('X'); //check for a win!
				if(win) { //if x wins tell them and end game
					System.out.println("PLAYER X WINS!!!!!!!!");
					return 'X';
				}
			} else {
				startRound('O');
				win = board.checkForWin('O'); //check for a win!
				if(win) { //if x wins tell them and end game
					System.out.println("PLAYER O WINS!!!!!!!!");
					return 'O';
				}
			}
			if(board.checkForTie()) { //if theres a tie
				System.out.println("You tied! Well played :)");
				return '-';
			}
			round++;
		}
		return '-';
	}

	public void startRound(char player) {
		System.out.printf("Pick a board Player %c! (1-9, only the first digit of input will be counted)%n", player);
		Scanner kb = new Scanner(System.in);
		char choice = kb.next().charAt(0);
		kb.nextLine();
		boolean validChoice = board.isValid(choice); //take a turn
		while(!validChoice) { //if the user choice is already selected continue to prompt until they select a valid choice
			System.out.println("Uh Oh! You can't play there! Pick another spot!");
			System.out.printf("Pick a board Player %c! (1-9, only the first digit of input will be counted)%n", player);
			choice = kb.next().charAt(0);
			kb.nextLine();
			validChoice = board.isValid(choice);
		}
		playBoard(choice);
		board.printBoard();
	}

	private void playBoard(int choice) {
		char winner;
		switch(choice) {
		case '1':
			winner = boards[0][0].playGame();
			board.setChar(0, 0, winner);
			break;
		case '2':
			winner = boards[0][1].playGame();
			board.setChar(0, 1, winner);
			break;
		case '3':
			winner = boards[0][2].playGame();
			board.setChar(0, 2, winner);
			break;
		case '4':
			winner = boards[1][0].playGame();
			board.setChar(1, 0, winner);
			break;
		case '5':
			winner = boards[1][1].playGame();
			board.setChar(1, 1, winner);
			break;
		case '6':
			winner = boards[1][2].playGame();
			board.setChar(1, 2, winner);
			break;
		case '7':
			winner = boards[2][0].playGame();
			board.setChar(2, 0, winner);
			break;
		case '8':
			winner = boards[2][1].playGame();
			board.setChar(2, 1, winner);
			break;
		case '9':
			winner = boards[2][2].playGame();
			board.setChar(2, 2, winner);
			break;
		}
	}
	
	public static void main(String[] args) {
		MegaTTT game = new MegaTTT();
		boolean play = true; //play will keep track of if another game should be played or not
		while(play) {
			game.playGame(); //play the game!
			//when done, see if they'd like to play again!
			System.out.println("\nWould you like to play again? (\"y\" to continue, any other key to quit)");
			Scanner kb = new Scanner(System.in);
			char choice = Character.toUpperCase(kb.next().charAt(0));
			if(choice == 'Y') {
				System.out.println("Starting a new game....\n\n");
			} else {
				System.out.println("Thanks for playing, goodbye!");
				play = false;
			}
		}
	}
}
