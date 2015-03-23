package battleship;

import java.awt.Color;

//numOfCells, array of Cells[numOfCells], vertical boolean, Color color, boolean sunk, int counter
public class Ship {
	private int numOfCells;
	private Cell[] cellsArray;
	private boolean vertical;
	private Color color;
	private boolean sunk;
	private int counter;

	public Ship(int numOfCells,boolean vertical, Color color) {
		this.numOfCells = numOfCells;
		this.cellsArray = new Cell[numOfCells];
		this.vertical = vertical;
		this.color = color;
		sunk=false;
		counter=0;
	}

	public int getNumOfCells() {
		return numOfCells;
	}

	public Cell[] getCellsArray() {
		return cellsArray;
	}

	public boolean isVertical() {
		return vertical;
	}

	public Color getColor() {
		return color;
	}

	public boolean isSunk() {
		return sunk;
	}

	public int getCounter() {
		return counter;
	}

	public void setNumOfCells(int numOfCells) {
		this.numOfCells = numOfCells;
	}

	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	

}