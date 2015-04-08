package battleship;

public class Main2 {
	public static void main(String args[]) {
		//client
		Game game = new Game(2);
		game.setGuiVisible();
		while (true) {
			game.myTurn();
			game.didILose();
			game.yourTurn();
			game.didYouLose();
		}
	}
}
