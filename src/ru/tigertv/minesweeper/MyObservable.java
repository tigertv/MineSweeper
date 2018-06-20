package ru.tigertv.minesweeper;

import java.util.Observable;

class MyObservable extends Observable {
	public void change() {
		super.setChanged();
	}
}
