package programmer.coderj.namegame;

import com.godtsoft.diyjava.DIYWindow;

public class NameGame extends DIYWindow {

	public NameGame() {
		// variables
		String name = "Josh";
		
		// output
		print(name + " be nimble,");
		print(name + " be quick,");
		print(name + " jump over the candlestick,");
		print("");
		print("Way to go, " + name + "!");
	}

	public static void main(String[] args) {
		new NameGame();
	}
}