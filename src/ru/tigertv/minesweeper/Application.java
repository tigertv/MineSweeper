package ru.tigertv.minesweeper;

public class Application {

	public static void main(String[] args) {
		IPlayer player = new Player();
		Game game = new Game(player);
		game.run();
	}

}
