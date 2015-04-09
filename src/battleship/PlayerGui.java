package battleship;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class PlayerGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private Player player;
	private Board myBoard;
	private Board opponentBoard;
	private Cell cellClicked;
	private boolean activated;
	private JPanel myBoardPanel;
	private JPanel yourBoardPanel;
	private JPanel boardPanel;
	private JPanel panel;
	private JPanel status;
	private JTextPane statusBox;

	public PlayerGui(Player player) {
		this.player = player;
		myBoard = player.getMyBoard();
		opponentBoard = player.getOpponentBoard();
		activated = false;

		setSize(500, 650);
		setTitle("Player " + player.getPlayerNumber() + "'s Board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(10, 10);
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		Color blue = new Color(102, 153, 255);
		Color purple = new Color(204, 153, 255);
		Color darkBlue = new Color(51, 102, 204);
		myBoardPanel = new JPanel(new GridLayout(8, 8, 1, 1));
		myBoardPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
		yourBoardPanel = new JPanel(new GridLayout(8, 8, 1, 1));
		yourBoardPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
		JLabel myLabel = new JLabel("My Board");
		JLabel yourLabel = new JLabel("Opponent's Board");
		status = new JPanel(new FlowLayout());
		status.setBackground(blue);
		statusBox = new JTextPane();
		statusBox.setEditable(false);
		statusBox.setSize(50, 30);
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		statusBox.setParagraphAttributes(attribs, true);
		statusBox.setBackground(purple);
		Border border = BorderFactory.createLineBorder(Color.black);
		statusBox.setBorder(border);

		Cell[][] tempBoard = myBoard.getBoard();
		// get the myboard cells and make each one a button - grid in North
		for (int i = 0; i < tempBoard.length; i++) {
			for (int j = 0; j < tempBoard[i].length; j++) {
				myBoardPanel.add(tempBoard[i][j]);
			}
		}

		Cell temp;
		tempBoard = opponentBoard.getBoard();
		// get opponents cells and make each one a button - grid in South
		for (int i = 0; i < tempBoard.length; i++) {
			for (int j = 0; j < tempBoard[i].length; j++) {
				temp = tempBoard[i][j];
				yourBoardPanel.add(temp);
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
		panel = new JPanel(new BorderLayout());
		boardPanel = new JPanel();
		boardPanel.setBackground(blue);
		myBoardPanel.setBackground(blue);
		yourBoardPanel.setBackground(blue);
		boardPanel.setLayout(new BoxLayout(boardPanel, BoxLayout.PAGE_AXIS));
		boardPanel.add(myLabel);
		boardPanel.add(myBoardPanel);
		boardPanel.add(yourLabel);
		boardPanel.add(yourBoardPanel);
		status.add(statusBox);
		panel.add(boardPanel, BorderLayout.CENTER);
		panel.add(status, BorderLayout.SOUTH);
		contentPane.add(panel);

	}

	public void activate() {
		activated = true;
	//	yourBoardPanel.setEnabled(true);
		// activate all cells in opponent's board - or setEditable equivalent?
		
		Cell[][] tempBoard = opponentBoard.getBoard();
		for (int i = 0; i < tempBoard.length; i++) {
			for (int j = 0; j < tempBoard[i].length; j++) {
				tempBoard[i][j].setEnabled(true);
			}
		}
	}

	public void deactivate() {
		activated = false;
	//	yourBoardPanel.setEnabled(false);
		// deactivate all cells in opponent's board or setEditable equivalent?
		
		Cell[][] tempBoard = opponentBoard.getBoard();
		for (int i = 0; i < tempBoard.length; i++) {
			for (int j = 0; j < tempBoard[i].length; j++) {
				tempBoard[i][j].setEnabled(false);
			}
		}
	}

	public boolean isActivated() {
		return activated;
	}

	public Cell getCellClicked() {
		return cellClicked;
	}

	public JTextPane getStatus() {
		return statusBox;
	}
}
