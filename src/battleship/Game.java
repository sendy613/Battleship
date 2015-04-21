package battleship;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextPane;

public class Game {
	private Integer playerNum;
	private Player me;
	private PlayerGui gui;
	private IOThread reader;
	private ServerSocket serverSocket;
	private Socket cSocket;
	private Socket socket;
	private JTextPane statusBox;

	public Game(Integer num) {
		playerNum = num;
		me = new Player(playerNum);
		gui = new PlayerGui(me);
		this.statusBox = gui.getStatus();
		me.setStatus(statusBox);
		statusBox.setText(statusBox.getText() + "\nPlayer 1 begin");

		// if num==1 (server) then it opens the serverSocket

		if (playerNum == 1) {
			try {
				serverSocket = new ServerSocket(2002);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// if num==2 (client) it opens a socket
		else if (playerNum == 2) {

			try {
				cSocket = new Socket("localhost", 2002);
				reader = new IOThread(cSocket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// server accepts the client
		if (playerNum == 1) {
			try {
				socket = serverSocket.accept();
				reader = new IOThread(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void myTurn() {
		gui.activate();
		while (gui.isActivated())
			;
		Cell cellClicked = gui.getCellClicked();
		reader.write(new CellCoordinates(cellClicked).getCoord());
		boolean hitAShip = (boolean) reader.read();
		if (hitAShip) {
			me.getOpponentBoard().markAsShip(cellClicked);
			//COMMENT 
			System.out.println("HIT");
			statusBox.setText("HIT!");
		} else {
			me.getOpponentBoard().markAsClicked(cellClicked);
			//COMMENT 
			System.out.println("MISS");
			statusBox.setText("MISS!");
		}
	}

	public void yourTurn() {
		CellCoordinates opponentCell = null;
		opponentCell = (CellCoordinates) reader.read();
		Boolean b = me.getMyBoard().isCellAShip(opponentCell);
		if (b) {
			statusBox.setText("Player hit your ship");
		} else {
			statusBox.setText("Player missed your ship");
		}
		reader.write(b);
	}

	public boolean didILose() {
		boolean allSunk = me.allSunk();
		if (allSunk) {
			reader.write("I WON");
			statusBox.setText("YOU WON!");
			gui.deactivate();
		} else {
			reader.write("Nope");
		}
		return allSunk;
	}

	public boolean didYouLose() {
		boolean b = false;
		String won = (String) reader.read();
		if (won.equals("I WON")) {
			b = true;
			statusBox.setText("Game Over. All your ships have sunk.");
			gui.deactivate();
		}
		return b;
	}

	public void setGuiVisible() {
		gui.setVisible(true);
		gui.revalidate();
	}

	public void repaint() {
		gui.repaint();
	}

}
