package battleship;

import java.awt.Color;

import javax.swing.JComponent;

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

	//only to be used for myBoard
	public void placeShips(Ship[] arrayOfShips) {
		for (Ship ship : arrayOfShips) {
			Cell[] shipCells = ship.getCellsArray();
			for (Cell cell : shipCells) {
				cell.occupiedByShip();
			}
		}
	}
	
	public boolean isCellAShip(Cell cellClicked){
		//first mark it as clicked
		return board[cellClicked.getX()][cellClicked.getY()].getOccupiedByShip();
	}
	
	public void markAsShip(Cell cellClicked){
		//change color
		cellClicked.setColor(Color.RED);
	}
	
	public void markAsClicked(Cell cellClicked){
		//change color
		cellClicked.setColor(Color.WHITE);
	}
	public Cell[][] getBoard(){
		return board;
	}

}
