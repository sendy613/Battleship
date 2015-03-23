package battleship;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class PlayerGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private Player player;
	private Board myBoard;
	private Board opponentBoard;
	private Cell cellClicked;
	private boolean activated;

	public PlayerGui(Player player) {
		this.player = player;
		myBoard = player.getMyBoard();
		opponentBoard = player.getOpponentBoard();
		activated = false;

		setSize(500, 700);
		setTitle("My Board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(10, 10);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		// get the myboard cells and make each one a button - grid in North
		// get opponents cells and make each one a button - grid in South
		// give each grid a title
		// give each button a new ActionListener(){
		// button's cell = cellClicked;
		// button.clicked();
		// button.disable();
		// gui.deactivate();
		// }

	}

	public void activate() {
		activated = true;
		// activate all cells in opponent's board - or setEditable equivalent?
	}

	public void deactivate() {
		activated = false;
		// deactivate all cells in opponent's board or setEditable equivalent?
	}

	public boolean getActivated() {
		return activated;
	}
}
