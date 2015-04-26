package battleship;

import java.awt.Color;

public class Ship {
	private int numOfCells;
	private Cell[] cellsArray;
	private boolean vertical;
	private Color color;
//	private boolean sunk;
//	private int amountSunk;

	public Ship(int numOfCells, boolean vertical, Color color) {
		this.numOfCells = numOfCells;
		this.cellsArray = new Cell[numOfCells];
		this.vertical = vertical;
		this.color = color;
//		sunk = false;
	//	amountSunk = 0;
	}

	public Cell[] getCellsArray() {
		return cellsArray;
	}

	public void setCellsArray(Cell[] array) {
		cellsArray = array;
		for(Cell cell: cellsArray){
			cell.setBackground(this.color);
		}
	}

	public Color getColor() {
		return color;
	}
	
	public boolean getVertical(){
		return vertical;
	}
/*
	public boolean isSunk() {
		if (numOfCells == amountSunk) {
			sunk = true;
		}
		return sunk;
	}

	public int getAmountSunk() {
		return amountSunk;
	}*/

	public void setNumOfCells(int numOfCells) {
		this.numOfCells = numOfCells;
	}

	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	public void setColor(Color color) {
		this.color = color;
	}
/*
	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}

	public void anotherCellSunk() {
		this.amountSunk++;
	}*/

}
