package battleship;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Game {

	private Player me;
	private PlayerGui gui;
	private IOThread reader;
	private ServerSocket serverSocket;
	private Socket socket;

	public Game() {
		me = new Player();
		gui = new PlayerGui(me);
		try {
			serverSocket = new ServerSocket(2000);
			socket = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reader = new IOThread(new Socket());
		// reader.start();
	}

	public void myTurn() {
		// activate gui
		gui.activate();
		while (gui.isActivated());
		Cell cellClicked = gui.getCellClicked();
		// writeToStream(cellClicked);
		// inputStream.read(boolean);
		// if boolean is true, me.getopponentBoard().markAsShip();
		// else markAsClicked();
	}

	public void yourTurn() {
		// Cell selected = inputStream.read();
		// boolean = me.getMyBoard.isCellAShip(selected); - mark as clicked in
		// method
		// if yes { markAsShip() }
		// if no { markAsClicked() }
		// write boolean to outputStream
	}

	public boolean didILose() {
		boolean allSunk = me.allSunk();
		// if true, outputStream.write(WON)
		// disable gui, YOU WON across opponents board screen;
		return allSunk;
	}

	public boolean didYouLose() {
		boolean b = true;
		// check if inputStream is yelling WON
		// if yes, return true and
		// disable gui, write SHE WON across my sunk screen;
		// else, return false

		return b;
	}

	public void setGuiVisible() {
		gui.setVisible(true);
	}

}
