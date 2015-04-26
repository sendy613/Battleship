package battleship;

import java.awt.Color;
import javax.swing.JButton;

public class Cell extends JButton{
	
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private boolean clicked;
	private boolean occupiedByShip;
	private static final Color defaultCellColor = new Color(51, 102, 204);
	private boolean sunk;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		clicked = false;
		occupiedByShip = false;
		sunk = false;
		setBackground(defaultCellColor);
	}

	public int getCellX() {
		return x;
	}
	
	public void setCellX(int x) {
		this.x = x;
	}

	public int getCellY() {
		return y;
	}

	public void setCellY(int y) {
		this.y = y;
	}

	public void clicked() {
		clicked = true;
		if(occupiedByShip){
			sunk=true;
		}
	}

	public void occupiedByShip() {
		occupiedByShip = true;
	}

	public boolean getClicked() {
		return clicked;
	}

	public boolean getOccupiedByShip() {
		return occupiedByShip;
	}
	public boolean getSunk(){
		return sunk;
	}
	
}
