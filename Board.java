//Jeff Stewart
//6/22/11
//Board will accept a current position and a proposed position
//if the move is legal and no other checker piece takes that position the move will be completed
public class Board {
	private static String grid[][] = new String[8][8];

	public static void moveIfPossible(int currentRow, int currentCol, int proposedRow, int proposedCol) {
		if (checkInBounds(proposedRow, proposedCol)) 
			if(checkLegal(currentRow, currentCol, proposedRow, proposedCol)) 
				if (isOccupied(currentRow, currentCol)) {
					if (isOccupied(proposedRow, proposedCol) == false)
						move(currentRow, currentCol, proposedRow, proposedCol);	//all tests pass, complete the move
					else
						System.out.println("However, the ending position was already occupied. The move has not been comleted.");	//proposed location was previously occupied
				}
				else
					System.out.println("However, the starting position was not occupied. The move has not been completed.");	//current location was not occupied
			return;
		
	}
	
	
	private static void move(int currentRow, int currentCol, int proposedRow, int proposedCol) {
		if ("R".equals(grid[currentRow][currentCol])) {
			grid[proposedRow][proposedCol] = "R";
		}
		else
			grid[proposedRow][proposedCol] = "B";
		grid[currentRow][currentCol] = null;
	
		System.out.println("The move has been completed.");	//inform user that the move has been completed
		return;
	}


	public static boolean checkIfPossible(int currentRow, int currentCol, int proposedRow, int proposedCol){	//checks for in bounds and legality of both row and col
		return checkInBounds(proposedRow, proposedCol) &&
			checkLegal(currentRow, currentCol, proposedRow, proposedCol) && isOccupied(currentRow, currentCol) && !isOccupied(proposedRow, proposedCol);
	}
	
	public static boolean checkInBounds(int row, int col){		//checks for both row and col to be in bounds
		return row >= 0 && row <= 7 && col >= 0 && col <= 7; 
	}
	
	public static boolean checkLegal(int initialRow, int initialCol, int proposedRow, int proposedCol) {	//checks for a legal one-space diagonal move. Does not allow jumping
		int rowChange = ("R".equals(grid[initialRow][initialCol]) ? 1 : -1) * (proposedRow - initialRow);
		int colChange = Math.abs(initialCol-proposedCol);
		return rowChange==1 && colChange==1; //must move one unit diagonally
	}
	
	public static boolean isOccupied(int row, int col){	//check the grid array to see if the given row,col is occupied
		return grid[row][col] != null;
	}
	
	public static void print(){		//prints the grid so a user can read where chess pieces are
		int row = 0;
		while (row < 8) {
			int col = 0;
			while (col < 8) {
				System.out.print((grid[row][col] == null ? " " : grid[row][col]) + " ");
				col++;
			}
			System.out.print("\n");
			row++;
		}
		return;
	}
	
	public static void fill() {	//fills the grid with the standard checkers game layout
		grid[0][0] = null;
		grid[0][1] = "R";
		grid[0][2] = null;
		grid[0][3] = "R";
		grid[0][4] = null;
		grid[0][5] = "R";
		grid[0][6] = null;
		grid[0][7] = "R";
		grid[1][0] = "R";
		grid[1][1] = null;
		grid[1][2] = "R";
		grid[1][3] = null;
		grid[1][4] = "R";
		grid[1][5] = null;
		grid[1][6] = "R";
		grid[1][7] = null;
		grid[2][0] = null;
		grid[2][1] = "R";
		grid[2][2] = null;
		grid[2][3] = "R";
		grid[2][4] = null;
		grid[2][5] = "R";
		grid[2][6] = null;
		grid[2][7] = "R";
		grid[3][0] = null;
		grid[3][1] = null;
		grid[3][2] = null;
		grid[3][3] = null;
		grid[3][4] = null;
		grid[3][5] = null;
		grid[3][6] = null;
		grid[3][7] = null;
		grid[4][0] = null;
		grid[4][1] = null;
		grid[4][2] = null;
		grid[4][3] = null;
		grid[4][4] = null;
		grid[4][5] = null;
		grid[4][6] = null;
		grid[4][7] = null;
		grid[5][0] = "B";
		grid[5][1] = null;
		grid[5][2] = "B";
		grid[5][3] = null;
		grid[5][4] = "B";
		grid[5][5] = null;
		grid[5][6] = "B";
		grid[5][7] = null;
		grid[6][0] = null;
		grid[6][1] = "B";
		grid[6][2] = null;
		grid[6][3] = "B";
		grid[6][4] = null;
		grid[6][5] = "B";
		grid[6][6] = null;
		grid[6][7] = "B";
		grid[7][0] = "B";
		grid[7][1] = null;
		grid[7][2] = "B";
		grid[7][3] = null;
		grid[7][4] = "B";
		grid[7][5] = null;
		grid[7][6] = "B";
		grid[7][7] = null;
		return;
	}

}