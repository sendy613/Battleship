package battleship;

import java.awt.Color;
import javax.swing.JTextPane;

// arrayOfShips[5], board[][] of cells with your ships, opponents empty board, int numShipsLeft, client

public class Player {
	private int playerNumber;
	private Ship[] arrayOfShips;
	private Board myBoard;
	private Board opponentBoard;

	public Player(int playerNumber) {
		this.playerNumber = playerNumber;
		myBoard = new Board();
		opponentBoard = new Board();

		arrayOfShips = new Ship[5];
		arrayOfShips[0] = new Ship(2, true, Color.gray);
		arrayOfShips[1] = new Ship(3, true, Color.darkGray);
		arrayOfShips[2] = new Ship(3, false, Color.lightGray);
		arrayOfShips[3] = new Ship(4, true, Color.BLACK);
		arrayOfShips[4] = new Ship(5, false, Color.WHITE);

		// hard coded ships - allow user to enter this info
		// player 1
		if (this.playerNumber == 1) {
			arrayOfShips[0].setCellsArray(new Cell[] { new Cell(2, 2, 0), new Cell(3, 2, 0) });
			arrayOfShips[1].setCellsArray(new Cell[] { new Cell(0, 0, 1), new Cell(1, 0, 1), new Cell(2, 0, 1) });
			arrayOfShips[2].setCellsArray(new Cell[] { new Cell(4, 3, 2), new Cell(4, 4, 2), new Cell(4, 5, 2) });
			arrayOfShips[3].setCellsArray(new Cell[] { new Cell(7, 7, 3), new Cell(6, 7, 3), new Cell(5, 7, 3),
					new Cell(4, 7, 3) });
			arrayOfShips[4].setCellsArray(new Cell[] { new Cell(6, 1, 4), new Cell(6, 2, 4), new Cell(6, 3, 4),
					new Cell(6, 4, 4), new Cell(6, 5, 4) });
		} else {
			arrayOfShips[0].setCellsArray(new Cell[] { new Cell(6, 2, 0), new Cell(7, 2, 0) });
			arrayOfShips[1].setCellsArray(new Cell[] { new Cell(0, 1, 1), new Cell(1, 1, 1), new Cell(2, 1, 1) });
			arrayOfShips[2].setCellsArray(new Cell[] { new Cell(6, 3, 2), new Cell(6, 4, 2), new Cell(6, 5, 2) });
			arrayOfShips[3].setCellsArray(new Cell[] { new Cell(7, 0, 3), new Cell(6, 0, 3), new Cell(5, 0, 3),
					new Cell(4, 0, 3) });
			arrayOfShips[4].setCellsArray(new Cell[] { new Cell(3, 3, 4), new Cell(3, 4, 4), new Cell(3, 5, 4),
					new Cell(3, 6, 4), new Cell(3, 7, 4) });
		}

		for (int i = 0; i < arrayOfShips.length; i++) {
			Cell[] temp = arrayOfShips[i].getCellsArray();
			for (int j = 0; j < temp.length; j++) {
				Cell tempCell = myBoard.getBoard()[temp[j].getCellX()][temp[j].getCellY()];
				tempCell.occupiedByShip();
				tempCell.setBackground(arrayOfShips[i].getColor());
				tempCell.occupiedByShip();
			}
		}

	}

	public Board getMyBoard() {
		return myBoard;
	}

	public Board getOpponentBoard() {
		return opponentBoard;
	}

	public boolean allSunk() {
		for (Ship ship : arrayOfShips) {
			if (!ship.isSunk()) {
				return false;
			}
		}
		return true;
	}

	public void setStatus(JTextPane status) {
		status.setText("Ships placed");
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public Ship getArray(CellCoordinates cell) {
		int x = cell.getX();
		int y = cell.getY();
		int shipNum = -1;
		Cell[] cellArray;
		loop: {
			for (int i = 0; i < arrayOfShips.length; i++) {
				cellArray = arrayOfShips[i].getCellsArray();
				for (int j = 0; j < cellArray.length; j++) {
					if (x == cellArray[j].getCellX() && y == cellArray[j].getCellY()) {
						shipNum = cellArray[j].getShipNum();
						break loop;
					}
				}
			}
		}
		return arrayOfShips[shipNum];
	}
}
