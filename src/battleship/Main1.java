package battleship;

public class Main1 {
	public static void main(String args[]) {
		// server
		Game game = new Game(1);
		game.setGuiVisible();
		while (true) {
			game.myTurn();

			if (game.didILose() || game.didYouLose()) {
				break;
			}
			game.yourTurn();
			if (game.didILose() || game.didYouLose()) {
				break;
			}
		}
		if (game.didILose()) {
			game.displayLose();
		} else {
			game.displayWin();
		}
	}
}
