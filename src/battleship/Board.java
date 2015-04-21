package battleship;

import java.awt.Color;

public class Board {

	public static final int SIZE_OF_BOARD = 8;
	private Cell[][] board;

	public Board() {
		board = new Cell[SIZE_OF_BOARD][SIZE_OF_BOARD];

		for (int i = 0; i < SIZE_OF_BOARD; i++) {
			for (int j = 0; j < SIZE_OF_BOARD; j++) {
				board[i][j] = new Cell(i, j);
			}
		}

	}

	
	public void disableCells(){
		for(Cell[] c : board){
			for(Cell d : c){
				d.setEnabled(false);
			}
		}
	}
	
	public boolean isCellAShip(CellCoordinates cellClicked){
		board[cellClicked.getX()][cellClicked.getY()].clicked();
		if(board[cellClicked.getX()][cellClicked.getY()].getOccupiedByShip()){
		board[cellClicked.getX()][cellClicked.getY()].setBackground(Color.RED);
		}
		return board[cellClicked.getX()][cellClicked.getY()].getOccupiedByShip();
	}
	
	public void markAsShip(Cell cellClicked){
		cellClicked.setColor(Color.RED);
		//cellClicked.setBackground(Color.RED);
	}
	
	public void markAsClicked(Cell cellClicked){
		cellClicked.setColor(Color.WHITE);
		//cellClicked.setBackground(Color.WHITE);
	}
	public Cell[][] getBoard(){
		return board;
	}

}
