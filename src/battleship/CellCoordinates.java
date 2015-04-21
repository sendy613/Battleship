package battleship;

import java.io.Serializable;

public class CellCoordinates implements Serializable {

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;

	public CellCoordinates(Cell cell) {
		x = cell.getX();
		y = cell.getY();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
