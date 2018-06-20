package ru.tigertv.minesweeper;

public class GameModel implements ISinglePlayerGame {
	
	enum GameState {
		READY,
		PLAYING,
		GAME_OVER
	};
	
	public MyObservable boardChanged = new MyObservable();
	public MyObservable stateChanged = new MyObservable();
	
	private IPlayer player;
	public Board board;
	private final String TITLE = "MineSweeper";
	private GameState state;
	
	GameModel(IPlayer player) {
		setPlayer(player);
		board = new Board(10, 10, 20);
		board.setMines();
		state = GameState.READY;
	}
	
	public void run() {
		if (state == GameState.READY) {
			state = GameState.PLAYING;
			stateChanged.hasChanged();
			stateChanged.notifyObservers(state);
		}
	}
	
	public void restart() {
		
	}
	
	public void stop() {
		
	}
	
	public void save() {
		
	}
	
	public String getTitle() {
		return TITLE;
	}
	
	public void setPlayer(IPlayer player) {
		this.player = player;
	}
	
	public void openCell(int column, int row) {
		if (state == GameState.PLAYING) {
			board.openCell(column, row);
			boardChanged.change();
			int[] xy = {column,row};
			boardChanged.notifyObservers(xy);
		} else {
			System.out.println("GameModel::openCell()::else");
		}
		
	}
	
}
