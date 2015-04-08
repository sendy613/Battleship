package battleship;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class Game {
	private Integer playerNum;
	private Player me;
	private PlayerGui gui;
	private IOThread reader;
	private ServerSocket serverSocket;
	private Socket cSocket;
	private Socket socket;
	private JTextArea statusBox;

	public Game(Integer num) {
		playerNum = num;
		me = new Player();
		gui = new PlayerGui(me);
		this.statusBox = gui.getStatus();
		me.setStatus(statusBox);
		statusBox.append("\nPlayer 1 begin");

		// if num==1 (server) then it opens the serverSocket

		if (playerNum == 1) {
			try {
				serverSocket = new ServerSocket(2001);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// if num==2 (client) it opens a socket
		else if (playerNum == 2) {

			try {
				cSocket = new Socket("localhost", 2001);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// server accepts the client
		if (playerNum == 1) {
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		reader = new IOThread(socket);
		reader.start();

	}

	public void myTurn() {
<<<<<<< HEAD
		// get opponent's clicked cell and mark his board as ship or not
		Cell opponentCell;
		if (reader.read() != null) {
			// opponentCell = reader.read();
		}
		// Boolean b = me.getMyBoard().isCellAShip(opponentCell);
		// reader.write(b.toString());

		// activate your gui and send your own clicked cell to the stream for
		// your opponent to receive at his turn
=======
>>>>>>> origin/master
		gui.activate();
		while (gui.isActivated())
			;
		Cell cellClicked = gui.getCellClicked();
<<<<<<< HEAD
		// reader.write(cellClicked);

		// writeToStream(cellClicked);
		// inputStream.read(boolean);
		// if boolean is true, me.getopponentBoard().markAsShip()
		// else markAsClicked()
=======
		reader.write(cellClicked);
		boolean hitAShip = (boolean) reader.read();
		if (hitAShip) {
			me.getOpponentBoard().markAsShip(cellClicked);
		} else {
			me.getOpponentBoard().markAsClicked(cellClicked);
		}
>>>>>>> origin/master
	}

	public void yourTurn() {
		Cell opponentCell = null;
		opponentCell = (Cell) reader.read();
		Boolean b = me.getMyBoard().isCellAShip(opponentCell);
		reader.write(b);
	}

	public boolean didILose() {
		boolean allSunk = me.allSunk();
		if (allSunk) {
			reader.write("I WON");
			// GAME OVER, YOU WON in the status box
			gui.deactivate();
		}
		return allSunk;
	}

	public boolean didYouLose() {
		boolean b = false;
		String won = (String) reader.read();
		if (won.equals("I WON")) {
			b = true;
			// write GAME OVER, SHE WON in the status box
			gui.deactivate();
		}
		return b;
	}

	public void setGuiVisible() {
		gui.setVisible(true);
	}

}
