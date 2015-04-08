package battleship;

public class Main1 {
	public static void main(String args[]) {
		//server
		Game game = new Game(1);
		game.setGuiVisible();
		while (true) {
			game.myTurn();
			game.didILose();
			game.yourTurn();
			game.didYouLose();
		}
	}
}