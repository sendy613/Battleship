package battleship;

public class Main2 {
	public static void main(String args[]) {
		// client
		Game game = new Game(2);
		game.setGuiVisible();
		while (true) {
			game.yourTurn();
			if (game.didYouLose()) {
				break;
			}
			game.myTurn();
			if (game.didILose()) {
				break;
			}
		}
	}
}
