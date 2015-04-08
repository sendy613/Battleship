package battleship;

public class Main1 {
	public static void main(String args[]) {
		// server
		Game game = new Game(1);
		game.setGuiVisible();
		while (true) {
			game.myTurn();
			if (game.didILose()) {
				break;
			}
			game.yourTurn();
			if (game.didYouLose()) {
				break;
			}
		}
	}
}