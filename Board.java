//Jeff Stewart
//6/22/11
//Board will accept a current position and a proposed position
//if the move is legal and no other checker piece takes that position the move will be completed
public class Board {
	
	
	public static void moveIfPossible(int currentRow, int currentCol, int proposedRow, int proposedCol, int[][] grid) {
		if (CheckInBounds(proposedRow, proposedCol)) 
			if(CheckLegal(currentRow, currentCol, proposedRow, proposedCol)) 
				if (isOccupied(currentRow, currentCol, grid)) {
					if (isOccupied(proposedRow, proposedCol, grid) == false)
						move(currentRow, currentCol, proposedRow, proposedCol, grid);	//all tests pass, complete the move
					else
						System.out.println("However, the ending position was already occupied. The move has not been comleted.");	//proposed location was previously occupied
				}
				else
					System.out.println("However, the starting position was not occupied. The move has not been completed.");	//current location was not occupied
			return;
		
	}
	
	
	private static void move(int currentRow, int currentCol, int proposedRow, int proposedCol, int[][] grid) {
		grid[currentRow][currentCol] = 0;	//remove checker piece from old location
		grid[proposedRow][proposedCol] = 1;	//place checker piece at new location
		System.out.println("The move has been completed.");	//inform user that the move has been completed
		return;
	}


	public static boolean checkIfPossible(int currentRow, int currentCol, int proposedRow, int proposedCol){	//checks for in bounds and legality of both row and col
		if (CheckInBounds(proposedRow, proposedCol))
			if(CheckLegal(currentRow, currentCol, proposedRow, proposedCol))
				return true;
			else
				return false;
		else
			return false;
	}
	
	public static boolean CheckInBounds(int row, int col){		//checks for both row and col to be in bounds
		if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {		//8x8 grid
			System.out.print(row + "," + col + " is in bounds, ");	//print the outcome of the test for debug purposes
			return true;
		}
		else
			System.out.println(row + "," + col + " is out of bounds");	//print the outcome of the test for debug purposes
			return false;
	}
	
	public static boolean CheckLegal(int initalRow, int initalCol, int proposedRow, int proposedCol) {	//checks for a legal one-space diagonal move. Does not allow jumping
		int rowChange = Math.abs(initalRow-proposedRow);
		int colChange = Math.abs(initalCol-proposedCol);
		if (rowChange==1 && colChange==1) { //must move one unit diagonally 
			System.out.println("and is a legal move.");	//print the outcome of the test for debug purposes
			return true;
		}
		else
			System.out.println("however, it is not a legal move.");	//print the outcome of the test for debug purposes
			return false;
	}
	
	public static boolean isOccupied(int row, int col, int[][] grid){	//check the grid array to see if the given row,col is occupied
		if (grid[row][col] == 1)
			return true;
		else
			return false;
	}
}