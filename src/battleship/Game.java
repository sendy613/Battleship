package battleship;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextPane;

public class Game {
	private Integer playerNum;
	private Player me;
	private PlayerGui gui;
	private IOReader reader;
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
				reader = new IOReader(cSocket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// server accepts the client
		if (playerNum == 1) {
			try {
				socket = serverSocket.accept();
				reader = new IOReader(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void myTurn() {
		gui.activate();
		while (gui.isActivated()) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		;
		Cell cellClicked = gui.getCellClicked();
		CellCoordinates cellCoords = new CellCoordinates(cellClicked);
		reader.write(cellCoords);
		String hitAShip = (String) reader.read();
		if (hitAShip.compareTo("sunk") == 0) {
			me.getOpponentBoard().markAsShip(cellClicked);
			statusBox.setText("HIT! \n Sunk ship!");
		} else if (hitAShip.compareTo("hit") == 0) {
			me.getOpponentBoard().markAsShip(cellClicked);
			statusBox.setText("HIT!");
		} else {
			me.getOpponentBoard().markAsClicked(cellClicked);
			statusBox.setText("MISS!");
		}
	}

	public void yourTurn() {
		CellCoordinates opponentCell = null;
		opponentCell = (CellCoordinates) reader.read();
		boolean b = me.getMyBoard().isCellAShip(opponentCell);

		boolean sunkShip;
		if (b) {
			me.getArray(opponentCell).anotherCellSunk();
			sunkShip = me.getArray(opponentCell).isSunk();
			if (sunkShip) {
				statusBox.setText("Player sunk your ship");
				reader.write("sunk");
			} else {
				statusBox.setText("Player hit your ship");
				reader.write("hit");
			}
		} else {
			statusBox.setText("Player missed your ship");
			reader.write("miss");
		}
	}

	public boolean didILose() {
		boolean allSunk = me.allSunk();
		if (allSunk) {
			reader.write("YOU WON");
			statusBox.setText("YOU LOST! \n All of your ships were sunk!");
			gui.deactivate();
		} else {
			reader.write("Nope");
		}
		return allSunk;
	}

	public boolean didYouLose() {
		boolean b = false;
		String won = (String) reader.read();
		if (won.equals("YOU WON")) {
			b = true;
			statusBox.setText("YOU WON! \n You have sunk all the ships!");
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

	public void displayLose() {
		gui.displayLose();
	}

	public void displayWin() {
		gui.displayWin();
	}
}
