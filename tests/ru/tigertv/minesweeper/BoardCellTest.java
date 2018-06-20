package ru.tigertv.minesweeper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardCellTest {
	/*
	@Test
	void testBoardCell() {
		fail("Not yet implemented");
	}

	@Test
	void testBoardCellBoolean() {
		fail("Not yet implemented");
	}
//*/
	@Test
	void testSetMine() {
		BoardCell cell = new BoardCell();
		boolean hasMine = cell.hasMine();
		assertEquals(false, hasMine);
		cell.setMine();
		hasMine = cell.hasMine();
		assertEquals(true, hasMine);
	}

	@Test
	void testSetFlag() {
		fail("Not yet implemented");
	}

	@Test
	void testUnsetFlag() {
		fail("Not yet implemented");
	}

	@Test
	void testOpen() {
		fail("Not yet implemented");
	}

	@Test
	void testIsOpen() {
		fail("Not yet implemented");
	}

}
