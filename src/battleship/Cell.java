package battleship;

import java.awt.Color;
import javax.swing.JButton;

public class Cell extends JButton{
	
	private int x;
	private int y;
	private boolean clicked;
	private boolean occupiedByShip;
	//private Color color;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		clicked = false;
		occupiedByShip = false;
		Color color = new Color(51, 102, 204);
		setBackground(color);
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

/*	public void setColor(Color color) {
		this.color = color;
		
	}*/

	
}
