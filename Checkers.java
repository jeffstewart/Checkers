//Jeff Stewart
// 6/22/11
//Checkers will allow a checker piece to move diagonally on an 8x8 grid. 
//If a proposed move is both within the grid, is touching diagonally the current location, and no piece is already there the move will be completed.
//Moves can be proposed by the user with the keyboard
//Does not support jumping
import java.io.*;
class Checkers {

	public static void main(String[] arg) throws Exception{ // using the main method to play the game of checkers
		Board.fill();
		String enteredValue = "";
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));	//allows for keyboard entry of proposed moves
		int row = 0;
		int col = 0;
		
		System.out.print("How many moves would you like to make today: ");
		enteredValue = keyboard.readLine();	//get a value for movesLeft from the user
		int movesLeft = Integer.parseInt(enteredValue);
		
		System.out.println("The game board looks like this:");
		Board.print();	//display the game board
		
		while (movesLeft > 0)	{
			
			System.out.print("Please enter a row to move from: ");	//prompt user for current row
			enteredValue = keyboard.readLine();
			row = Integer.parseInt(enteredValue);	//sets the row variable from user input
			System.out.print("Please enter a col to move from: ");	//prompt user for current col
			enteredValue = keyboard.readLine();
			col = Integer.parseInt(enteredValue);	//sets the col variable from user input
			System.out.print("Please enter a row to move to: ");	//prompt user for new row
			enteredValue = keyboard.readLine(); 	//proposed row to be checked for in bounds and legality
			int proposedRow = Integer.parseInt(enteredValue);
			System.out.print("Please enter a col to move to: ");	//prompt user for new col
			enteredValue = keyboard.readLine(); 	//proposed col to be checked for in bounds and legality
			int proposedCol = Integer.parseInt(enteredValue); 	
								//if both are legal the move will be completed
			Board.moveIfPossible(row, col, proposedRow, proposedCol);
			System.out.println("The game board now looks like this:");
			Board.print();//display the game board
			movesLeft--;	//decrement movesLeft
			System.out.println("You have " + movesLeft + " move(s) left" );
			
		}
		System.out.println("Thanks for playing, have a nice day!");
	}	
	
}
