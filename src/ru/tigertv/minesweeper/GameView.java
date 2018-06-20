package ru.tigertv.minesweeper;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;

public class GameView {
	private JFrame frame;
	private GameModel model;
	
	public MyObservable cellClicked = new MyObservable();
	private JPanel panel;
	private int cellSize = 20;
	private int cellsInRow = 20;
	
	private ArrayList<ArrayList<JButton>> buttons = new ArrayList<ArrayList<JButton>>();
	
	enum ButtonIcon {
		NUM0,NUM1,NUM2,NUM3,NUM4,NUM5,NUM6,NUM7,NUM8,NUM9
		,CLOSED,BOMB,FLAG
	};
	
	public GameView(GameModel model) {
		this.model = model;
		showGamePlayScene();
	}
	
	private void showGamePlayScene() {
		frame = new JFrame(model.getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		frame.setLocation(100, 100);
		
		MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {
			
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	int idButton = evt.getButton();
		    	
		    	JButton button = (JButton) evt.getSource();
		    	String[] xy = button.getName().split(" ", 2);
	            int x = Integer.parseInt(xy[0]);
	            int y = Integer.parseInt(xy[1]);
	            
		    	switch(idButton) {
		    	case MouseEvent.BUTTON1:
		            int[] xy2 = {x, y, 0};
		            cellClicked.change();
		            cellClicked.notifyObservers(xy2);
		    		break;
		    		
		    	case MouseEvent.BUTTON3:
		            int[] xy21 = {x, y, 1};
		            cellClicked.change();
		            cellClicked.notifyObservers(xy21);
		    		break;
		    	}
		    	
		    }
		};
		
		panel = new JPanel(new GridLayout(model.board.width, model.board.height));
		panel.setPreferredSize(new Dimension(220,220));
		
		for(int rowIndex=0;rowIndex<model.board.height;rowIndex++) {
			ArrayList<JButton> row = new ArrayList<JButton>();
			
			for(int columnIndex=0;columnIndex<model.board.width;columnIndex++) {
				JButton button = new JButton();
				button.setBounds(cellSize * rowIndex, cellSize * columnIndex, cellSize, cellSize);
				button.setName(columnIndex+" "+rowIndex);
				button.setMargin(new Insets(0, 0, 0, 0));
				button.addMouseListener(mouseAdapter);
				
				panel.add(button);
				row.add(button);
			}
			
			buttons.add(row);
		}
		
		for(int row=0;row<model.board.height;row++) {
			for(int column=0;column<model.board.width;column++) {
				changeIconOnButton(column, row, ButtonIcon.CLOSED);
			}
		}
		
		JPanel mainPanel = new JPanel();
		mainPanel.add(panel, mainPanel.CENTER_ALIGNMENT);
		
		frame.setContentPane(mainPanel);
		frame.pack();
	}
	
	private void removeMouseListeners(int column, int row) {
		/*
		for (JButton button : buttons) {
			if(button.getName().equals(row + " " + column)) {
				for( MouseListener al : button.getMouseListeners() ) {
			        button.removeMouseListener(al);
			    }
			}
		}
		//*/
	}
	
	public void show() {
		frame.setVisible(true);
	}
	
	public void changeIconOnButton(int column, int row, ButtonIcon icon) {
		JButton button = buttons.get(row).get(column);

		String path = "./images/";
		
		switch(icon) {
		case NUM0:
			path += '0';
			break;
		
		case NUM1:
			path += '1';
			break;
			
		case NUM2:
			path += '2';
			break;
			
		case NUM3:
			path += '3';
			break;
			
		case NUM4:
			path += '4';
			break;
			
		case NUM5:
			path += '5';
			break;
			
		case NUM6:
			path += '6';
			break;
			
		case NUM7:
			path += '7';
			break;
			
		case NUM8:
			path += '8';
			break;
			
		case NUM9:
			path += '9';
			break;
			
		case CLOSED:
			path += "closed";
			break;
			
		case BOMB:
			path += "bomb";
			break;
			
		case FLAG:
			path += "flagged";
			break;
		}
		
		path += ".png";
		
		ImageIcon icon2 = new ImageIcon(path);
		Image img = icon2.getImage(); 
		Image newimg = img.getScaledInstance(cellSize, cellSize,  java.awt.Image.SCALE_SMOOTH);  
		icon2 = new ImageIcon(newimg); 
		button.setIcon(icon2);
	} // function ends
	

}
