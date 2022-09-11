package programmer.coderj.guessmynumber;

import java.util.Random;
import programmer.coderj.mywindow.MyWindow;

public class GuessMyNumber extends MyWindow {

	public GuessMyNumber() {
		Random rand = new Random();
		int myNumber = rand.nextInt(101) + 5;
		int myGuess = promptForInt("Guess my number between 5 and 100");
		int count = 1;
		
		while(myGuess != myNumber) {
			if(myGuess < myNumber) {
				myGuess = promptForInt("You guessed too low, try again!");
			}
			else if(myGuess > myNumber) {
				myGuess = promptForInt("You guessed too high, try again!");
			}
			count++;
		}
	
		if(myGuess == myNumber) {
			print("You guessed it in " + count + " tries!");
		}
		
	}

	public static void main(String[] args) {
		new GuessMyNumber();
	}
}
