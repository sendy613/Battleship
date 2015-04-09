package battleship;

import java.awt.Color;
import javax.swing.JButton;

public class Cell extends JButton{
	
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private boolean clicked;
	private boolean occupiedByShip;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		clicked = false;
		occupiedByShip = false;
		Color darkBlue = new Color(51, 102, 204);
		setBackground(darkBlue);
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
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
}
