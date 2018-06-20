package ru.tigertv.minesweeper;

public class BoardCell {
	
	private boolean hasMine = false;
	private boolean isOpen = false;
	private boolean hasFlag = false;
	
	public BoardCell() {
		
	}
	
	public BoardCell(boolean hasMine) {
		this.hasMine = hasMine;
	}
	
	public void setMine() {
		hasMine = true;
	}
	
	public void setFlag() {
		if (!isOpen) hasFlag = true;
	}

	public void unsetFlag() {
		hasFlag = false;
	}
	
	public boolean hasMine() {
		return this.hasMine;
	}
	
	public void open(){
		isOpen = true;
	}
	
	public boolean isOpen() {
		return isOpen;
	}

}
