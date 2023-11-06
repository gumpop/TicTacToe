/*
 * Class: TicTacToe
 * Author: Mallorie Mackay
 * Purpose: Plays the game, having its own class allows for MEGA TICTACTOE (which I may implement if i become bored)
 */
import java.util.Scanner;

public class TicTacToe {
	private Board board;

	public TicTacToe() {
		board = new Board();
	}

	//method playGame will start the game (returns winner or '-' for none
	public char playGame() {
		board.setUp(); //set up the board to play
		//begin prompting the player for info
		System.out.println("Welcome to TicTacToe!\nPlayer X will go first.");
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
	
	//method prompts player for choice and takes a turn
	public void startRound(char player) {
		System.out.printf("Pick a spot Player %c! (1-9, only the first digit of input will be counted)%n", player);
		Scanner kb = new Scanner(System.in);
		char choice = kb.next().charAt(0);
		kb.nextLine();
		boolean validChoice = board.takeTurn(choice, player); //take a turn
		while(!validChoice) { //if the user choice is already selected continue to prompt until they select a valid choice
			System.out.println("Uh Oh! You can't play there! Pick another spot!");
			System.out.printf("Pick a spot Player %c! (1-9, only the first digit of input will be counted)%n", player);
			choice = kb.next().charAt(0);
			kb.nextLine();
			validChoice = board.takeTurn(choice, player);
		}
		board.printBoard();
	}
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
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
