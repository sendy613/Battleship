package battleship;

public class Main {
	public static void main(String args[]) {
		Game game = new Game();
		game.setGuiVisible();
		while (true) {
			game.myTurn();
			game.didILose();
			game.yourTurn();
			game.didYouLose();
		}
	}
}
