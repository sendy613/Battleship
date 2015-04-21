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
		//player 1
		if(this.playerNumber==1){
		arrayOfShips[0].setCellsArray(new Cell[] { new Cell(2, 2), new Cell(3, 2) });
		arrayOfShips[1].setCellsArray(new Cell[] { new Cell(0, 0), new Cell(1, 0), new Cell(2, 0) });
		arrayOfShips[2].setCellsArray(new Cell[] { new Cell(4, 3), new Cell(4, 4), new Cell(4, 5) });
		arrayOfShips[3].setCellsArray(new Cell[] { new Cell(7, 7), new Cell(6, 7), new Cell(5, 7), new Cell(4, 7) });
		arrayOfShips[4].setCellsArray(new Cell[] { new Cell(6, 1), new Cell(6, 2), new Cell(6, 3), new Cell(6, 4),
				new Cell(6, 5) });
		}
		else{
			arrayOfShips[0].setCellsArray(new Cell[] { new Cell(6, 2), new Cell(7, 2) });
			arrayOfShips[1].setCellsArray(new Cell[] { new Cell(0, 1), new Cell(1, 1), new Cell(2, 1) });
			arrayOfShips[2].setCellsArray(new Cell[] { new Cell(6, 3), new Cell(6, 4), new Cell(6, 5) });
			arrayOfShips[3].setCellsArray(new Cell[] { new Cell(7, 0), new Cell(6, 0), new Cell(5, 0), new Cell(4, 0) });
			arrayOfShips[4].setCellsArray(new Cell[] { new Cell(3, 3), new Cell(3, 4), new Cell(3, 5), new Cell(3, 6),
					new Cell(3, 7) });
		}
		
		
		for (int i = 0; i < arrayOfShips.length; i++) {
			Cell[] temp = arrayOfShips[i].getCellsArray();
			for (int j = 0; j < temp.length; j++) {
				Cell tempCell = myBoard.getBoard()[temp[j].getX()][temp[j].getY()];
				tempCell.occupiedByShip();
				tempCell.setBackground(arrayOfShips[i].getColor());
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
}
