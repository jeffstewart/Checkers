//Jeff Stewart
// 6/22/11
//Checkers will allow a checker piece to move diagonally on an 8x8 grid. 
//If a proposed move is both within the grid, is touching diagonally the current location, and no piece is already there the move will be completed.
//Moves can be proposed by the user with the keyboard
//Does not support jumping
import java.io.*;
class Checkers {

	public static void main(String[] arg) throws Exception{ // using the main method to play the game of checkers
		int grid[][] = new int[8][8];
		fillGrid(grid);
		String enteredValue = "";
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));	//allows for keyboard entry of proposed moves
		int row = 0;
		int col = 0;
		
		System.out.print("How many moves would you like to make today: ");
		enteredValue = keyboard.readLine();	//get a value for movesLeft from the user
		int movesLeft = Integer.parseInt(enteredValue);
		
		System.out.println("The game board looks like this:");
		printGrid(grid);	//display the game board
		
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
			Board.moveIfPossible(row, col, proposedRow, proposedCol,grid);
			System.out.println("The game board now looks like this:");
			printGrid(grid);//display the game board
			movesLeft--;	//decrement movesLeft
			System.out.println("You have " + movesLeft + " move(s) left" );
			
		}
		System.out.println("Thanks for playing, have a nice day!");
	}	
	
	private static void fillGrid(int[][] grid) {	//fills the grid with the standard checkers game layout
		grid[0][0] = 0;
		grid[0][1] = 1;
		grid[0][2] = 0;
		grid[0][3] = 1;
		grid[0][4] = 0;
		grid[0][5] = 1;
		grid[0][6] = 0;
		grid[0][7] = 1;
		grid[1][0] = 1;
		grid[1][1] = 0;
		grid[1][2] = 1;
		grid[1][3] = 0;
		grid[1][4] = 1;
		grid[1][5] = 0;
		grid[1][6] = 1;
		grid[1][7] = 0;
		grid[2][0] = 0;
		grid[2][1] = 1;
		grid[2][2] = 0;
		grid[2][3] = 1;
		grid[2][4] = 0;
		grid[2][5] = 1;
		grid[2][6] = 0;
		grid[2][7] = 1;
		grid[3][0] = 0;
		grid[3][1] = 0;
		grid[3][2] = 0;
		grid[3][3] = 0;
		grid[3][4] = 0;
		grid[3][5] = 0;
		grid[3][6] = 0;
		grid[3][7] = 0;
		grid[4][0] = 0;
		grid[4][1] = 0;
		grid[4][2] = 0;
		grid[4][3] = 0;
		grid[4][4] = 0;
		grid[4][5] = 0;
		grid[4][6] = 0;
		grid[4][7] = 0;
		grid[5][0] = 1;
		grid[5][1] = 0;
		grid[5][2] = 1;
		grid[5][3] = 0;
		grid[5][4] = 1;
		grid[5][5] = 0;
		grid[5][6] = 1;
		grid[5][7] = 0;
		grid[6][0] = 0;
		grid[6][1] = 1;
		grid[6][2] = 0;
		grid[6][3] = 1;
		grid[6][4] = 0;
		grid[6][5] = 1;
		grid[6][6] = 0;
		grid[6][7] = 1;
		grid[7][0] = 1;
		grid[7][1] = 0;
		grid[7][2] = 1;
		grid[7][3] = 0;
		grid[7][4] = 1;
		grid[7][5] = 0;
		grid[7][6] = 1;
		grid[7][7] = 0;
		return;
	}

	public static void printGrid(int[][] grid){		//prints the grid so a user can read where chess pieces are
		int row = 0;
		while (row < 8) {
			int col = 0;
			while (col < 8) {
				System.out.print(grid[row][col] + " ");
				col++;
			}
			System.out.print("\n");
			row++;
		}
		return;
	}
	
}
