package battleship;

public class Main {
	public static void main(String args[]) {
		Game game = new Game();
		game.setVisible();
		while (true) {
			game.myTurn();
			game.didIWin();
			game.yourTurn();
			game.didYouWin();
		}
	}
}
