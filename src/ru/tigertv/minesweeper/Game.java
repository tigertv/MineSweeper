package ru.tigertv.minesweeper;

import java.util.Observable;
import java.util.Observer;

import ru.tigertv.minesweeper.GameView.ButtonIcon;


public class Game {
	private GameModel model;
	private GameView view;

	Game(IPlayer player) {
		model = new GameModel(player);
		view = new GameView(model);
		init();
	}
	
	public void init() {
		observeView();
		addObserverToModel();
	}
	
	public void run() {
		model.run();
		view.show();
	}
	
	public void setPlayer(IPlayer player) {
		model.setPlayer(player);
	}
	
	public void save() {
		
	}
	
	public void load() {
		
	}
	
	private void observeView() {
		Observer a;
		
		a  = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				
				int[] xy = (int[])arg;
				int x = xy[0];
				int y = xy[1];
				int isRightClick = xy[2];
				
				System.out.println("Controller: x="+x+" y="+y);
				
				if (isRightClick == 0) {
					model.openCell(x, y);
					
					ButtonIcon icon = null;
					
					if(model.board.isMineInXY(x, y)) {
						icon = ButtonIcon.BOMB;
					} else {
						int count = model.board.getBombsCountAround(x, y);
						
						switch(count) {
						case 1:
							icon = ButtonIcon.NUM1;
							break;
							
						case 2:
							icon = ButtonIcon.NUM2;
							break;
							
						case 3:
							icon = ButtonIcon.NUM3;
							break;
							
						case 4:
							icon = ButtonIcon.NUM4;
							break;
							
						case 5:
							icon = ButtonIcon.NUM5;
							break;
							
						case 6:
							icon = ButtonIcon.NUM6; 
							break;
							
						case 7:
							icon = ButtonIcon.NUM7;
							break;
							
						case 8:
							icon = ButtonIcon.NUM8;
							break;
							
						case 9:
							icon = ButtonIcon.NUM9;
							break;
							
						case 0:
							icon = ButtonIcon.NUM0;
							break;
						}
					}
					view.changeIconOnButton(x, y, icon);
				} else {
					// isRightClick
					model.board.setFlag(x, y);
					//model.board.
					
				}
				
			}
		};
		
		view.cellClicked.addObserver(a);
		
	}
	
	private void addObserverToModel() {
		Observer a  = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				//String text = (String) arg; 
				//view.setDisplayText(text);
			}
		};

		model.boardChanged.addObserver(a);
	}
	
}
