package battleship;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Player2Gui extends JFrame {
	private JPanel yourBoardPanel;
	private JPanel opponentBoardPanel;
	
	public Player2Gui() {
		setSize(500, 700);
		setTitle("Player 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550,10);
	}
}
