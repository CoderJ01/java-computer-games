package programmer.coderj.namegame;

import com.godtsoft.diyjava.DIYWindow;

public class NameGame extends DIYWindow {

	public NameGame() {
		print("Enter a name: ");
		String name = input();
		// while(!name.equals("quit")) { // infinite loop
			print("");
			checkName(name);
			print("");
		// }
		// print("Thank you for playing my game!");
	}
	
	private void checkName(String name) {
		print(name + " be nimble,");
		print(name + " be quick,");
		print(name + " jump over the candlestick,");
		print("");
		print("Way to go, " + name + "!");
		
		if(name.equals("Jack")) {
			print(name + ", your jumping skills are famous!");
		}
		else {
			print(name + ", I've never heard of you.");
		}
		
		if(name.startsWith("King")) {
			print("Your highest!");
		}
		else if(name.startsWith("Queen")) {
			print("Madam");
		}
		else {
			print("You must be commoner.");
		}
		
		if(!name.contains(" ")) {
			print("Don't you have a last name?");
		}
	}

	public static void main(String[] args) {
		new NameGame();
	}
}
