import static org.junit.Assert.*;

import org.junit.Test;


public class BoardTest {

	@Test
	public void checkInBoundsAcceptsInBoundsLowerLeft() {
		Board.fill();
		assertTrue(Board.checkInBounds(0, 0));
	}

	@Test
	public void checkInBoundsAcceptsInBoundsUpperRight() {
		Board.fill();
		assertTrue(Board.checkInBounds(7, 7));
	}

	@Test
	public void checkInBoundsRejectsOutOfBounds() {
		Board.fill();
		assertFalse(Board.checkInBounds(0, 8));
	}

	@Test
	public void checkIfBoundsRejectsRowOutOfBounds() {
		Board.fill();
		assertFalse(Board.checkInBounds(8, 0));
	}


	@Test
	public void checkInBoundsRejectsNegativeCol() {
		Board.fill();
		assertFalse(Board.checkInBounds(0, -1));
	}
	
	@Test
	public void checkInBoundsRejectsNegativeRow() {
		Board.fill();
		assertFalse(Board.checkInBounds(-1, 0));
	}
	
	@Test
	public void checkIfPossibleAcceptsMovingDiagonallyRightRed() {
		Board.fill();
		assertTrue(Board.checkIfPossible(2, 1, 3, 2));
	}
	

	@Test
	public void checkIfPossibleAcceptsMovingDiagonallyRightBlack() {
		Board.fill();
		assertTrue(Board.checkIfPossible(5, 0, 4, 1));
	}
	

	@Test
	public void checkIfPossibleAcceptsMovingDiagonallyLeftBlack() {
		Board.fill();
		assertTrue(Board.checkIfPossible(5, 2, 4, 1));
	}
	


	@Test
	public void checkIfPossibleAcceptsMovingDiagonallyLeft() {
		Board.fill();
		assertTrue(Board.checkIfPossible(2, 1, 3, 0));
	}
	

	@Test
	public void checkIfPossibleDeclinesNonDiagonal() {
		Board.fill();
		assertFalse(Board.checkIfPossible(1, 0, 2, 0));
	}
	

	@Test
	public void checkIfPossiblRejectsNoBoardPieces() {
		assertFalse(Board.checkIfPossible(1, 0, 2, 1));
	}
}
 