package ru.tigertv.minesweeper;

public class Board {
	
	public int height;
	public int width;
	private BoardCell[][] boardCells;
	private int bombs = 20;
	
	public Board(int width, int height, int bombs) {
		this.width = width;
		this.height = height;
		this.bombs = bombs;
		
		boardCells = new BoardCell[width][height];
		for (int i=0;i<width;i++) {
			for (int j=0;j<height;j++) {
				boardCells[i][j] = new BoardCell();
			}
		}
	}
	
	public void setMine(int column, int row) {
		//TODO: check bounds
		boardCells[column][row].setMine();
	}
	
	public void setMines() {
		int column;
		int row;

		for (int i=0; i<bombs; i++) {
			// generate the row and the column to set a bomb
			// TODO: check free space on the board
			do {
				row = (int)(Math.random() * height);
				column = (int)(Math.random() * width);
			} while (isMineInXY(row, column));
			
			this.setMine(column, row);
		}
	}
	
	public int getBombsCountAround(int x, int y) {
		int count = 0;
		
		for(int i = x-1; i<x+2; i++) {
			if (i<0 || i>=this.width) continue;
			
			for (int j=y-1; j<y+2; j++) {
				if (j<0 || j>=this.height) continue;
				if (isMineInXY(i, j)) count++;
			}
		}

		return count;
	}
	
	public boolean isMineInXY(int column, int row) {
		// TODO: check bounds
		return boardCells[column][row].hasMine();
	}
	
	public void openCell(int column, int row) {
		// TODO: check bounds
		boardCells[column][row].open();
	}
	
	public void setFlag(int column, int row) {
		// TODO: check bounds
		boardCells[column][row].setFlag();
	}

}
