package battleship;

public class Game {

	private Player me;
	private PlayerGui gui;

	public Game() {
		me = new Player();
		gui = new PlayerGui(me);

	}

	public void myTurn() {
		// activate gui
		gui.activate();
		// wait for it to be deactivated while(gui.isActivated());
		// Cell cellClicked = gui.getCellClicked();
		// writeToStream(cell);
		// inputStream.read(boolean);
		// if boolean is true, me.getopponentBoard().markAsShip()
		//else markAsClicked()
	}

	public void yourTurn() {
		// Cell selected = inputStream.read();
		// boolean = me.getMyBoard.isCellAShip(selected); - mark as clicked in method
		// if yes { markAsShip() }
		//if no { markAsClicked() }
		// write boolean to outputStream
	}

	public boolean didILose() {
		boolean allSunk = me.allSunk();
		// if true, outputStream.write(WON)
		// disable gui, YOU WON across opponents board screen;
		return allSunk;
	}

	public boolean didYouLose() {
		boolean b =true;
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
