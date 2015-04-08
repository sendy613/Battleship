package battleship;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PlayerGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private Player player;
	private Board myBoard;
	private Board opponentBoard;
	private Cell cellClicked;
	private boolean activated;
	private JPanel myPanel;
	private JPanel yourPanel;
	private JPanel panel;
	private JPanel status;
	private JTextArea statusBox;

	public PlayerGui(Player player) {
		this.player = player;
		myBoard = player.getMyBoard();
		opponentBoard = player.getOpponentBoard();
		activated = false;

		setSize(500, 700);
		setTitle("My Board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(10, 10);
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		myPanel = new JPanel(new GridLayout(8, 8, 1, 1));
		myPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
		yourPanel = new JPanel(new GridLayout(8, 8, 1, 1));
		yourPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
		JLabel myLabel = new JLabel("My Board");
		JLabel yourLabel = new JLabel("Opponent's Board");
		status = new JPanel(new FlowLayout());
		statusBox = new JTextArea();
		//statusBox.setColumns(15);
		statusBox.setBackground(this.getBackground());
		
		Cell[][] tempBoard = myBoard.getBoard();
		// get the myboard cells and make each one a button - grid in North
		for (int i = 0; i < tempBoard.length; i++) {
		for (int j = 0; j < tempBoard[i].length; j++) {			
				myPanel.add(tempBoard[i][j]);
			}
		}

		Cell temp;
		tempBoard = opponentBoard.getBoard();
		// get opponents cells and make each one a button - grid in South
		for (int i = 0; i < tempBoard.length; i++) {
			for (int j = 0; j < tempBoard[i].length; j++) {
				temp = tempBoard[i][j];
				yourPanel.add(temp);
				temp.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						cellClicked = (Cell) e.getSource();
						cellClicked.clicked();
						cellClicked.setEnabled(false);
						deactivate();
					}

				});
			}
		}
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(myLabel);
		panel.add(myPanel);
		panel.add(yourLabel);
		panel.add(yourPanel);
		status.add(statusBox);
		panel.add(status);
		contentPane.add(panel);

	}

	public void activate() {
		activated = true;
		yourPanel.setEnabled(true);
		// activate all cells in opponent's board - or setEditable equivalent?
	}

	public void deactivate() {
		activated = false;
		yourPanel.setEnabled(false);
		// deactivate all cells in opponent's board or setEditable equivalent?
	}

	public boolean isActivated() {
		return activated;
	}
	
	public Cell getCellClicked(){
		return cellClicked;
	}
	
	public JTextArea getStatus(){
		return statusBox;
	}
}
