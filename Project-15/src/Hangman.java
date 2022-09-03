package programmer.coderj.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

import programmer.coderj.mystringmethods.MyStringMethods;
import programmer.coderj.mywindow.MyWindow;

public class Hangman extends MyWindow {
	private String phrase;
	private String clue;
	private String wrongLetters;
	
	private static final String FILENAME = "phrases.txt";

	public Hangman() {
		ArrayList<String> phrases = new ArrayList<String>();
		Random rand = new Random();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(FILENAME)));
			String s = in.readLine();
			while (s != null) {
				//print(s); // this works
				phrases.add(s);
				s = in.readLine();
			}
			in.close();
			int numberOfPhrases = phrases.size();
			
			boolean again = true;
			while(again) {
				int pick = rand.nextInt(numberOfPhrases);
				
				phrase = phrases.get(pick);
				// phrase = "hello world"; // test code
			    phrase = phrase.toUpperCase();
				blankOutClue();
				
				wrongLetters = "";
				printPuzzle();
				
				while(clue.contains("-") && wrongLetters.length() < 10) {
					String guess = promptForString("Guess a letter");
					guess = guess.toUpperCase();
					// must be one letter
					if(guess.length() != 1) {
						print("Your guess must conatain only 1 letter. Guess again.");
					}
					// guess must not have been tried before
					else if(clue.contains(guess) || wrongLetters.contains(guess)) {
						print("You already guessed " + guess + ". Guess again.");
					}
					else {
						boolean found = false;
						// find the first index of the guessed letter
						int index = phrase.indexOf(guess);
						// as long as it finds the guessed letter
						while(index > -1) {
							found = true;
							// replace the dash in the same position of the clue with the letter
							clue = MyStringMethods.replaceStringAt(clue, index, guess);
							// find the next occurrence of the guessed letter
							index = phrase.indexOf(guess, index + 1);
						}
						if(found == false) {
							wrongLetters += guess;
						}
						// print the puzzle again
						printPuzzle();
					}
				}
				
				if(!clue.contains("-")) {
					print("Congradulations! You guess it before you were hanged");
				}
				else {
					print("Sorry. you lose. The phrase was " + phrase);
				}
				again = promptForYesNo("Would you like to play again?");
			}
			//System.exit(0);
			
		}
		catch(FileNotFoundException e) {
			print("The file " + FILENAME + " was not found.");
		}
		catch(IOException e) {
			print("Could not read from file " + FILENAME + ".");
		}
	}
	
	private void printPuzzle() {
		switch(wrongLetters.length()) {
			case 0:
				print(clue);
				print(" _____");
				print("|");
				print("|     " + wrongLetters);
				print("|");
				print("|");
				break;
			case 1:
				print(clue);
				print(" _____");
				print("|    O");
				print("|     " + wrongLetters);
				print("|");
				print("|");
				break;
			case 2:
				print(clue);
				print(" _____");
				print("|    O");
				print("|    |    " + wrongLetters);
				print("|");
				print("|");
				break;
			case 3:
				print(clue);
				print(" _____");
				print("|    O");
				print("|   -|    " + wrongLetters);
				print("|");
				print("|");
				break;
			case 4:
				print(clue);
				print(" _____");
				print("|    O");
				print("|  --|   " + wrongLetters);
				print("|");
				print("|");
				break;
			case 5:
				print(clue);
				print(" _____");
				print("|    O");
				print("|  --|-    " + wrongLetters);
				print("|");
				print("|");
				break;
			case 6:
				print(clue);
				print(" _____");
				print("|    O");
				print("|  --|--    " + wrongLetters);
				print("|");
				print("|");
				break;
			case 7:
				print(clue);
				print(" _____");
				print("|    O");
				print("|  --|--    " + wrongLetters);
				print("|   /");
				print("|");
				break;
			case 8:
				print(clue);
				print(" _____");
				print("|    O");
				print("|  --|--    " + wrongLetters);
				print("|  _/");
				print("|");
				break;
			case 9:
				print(clue);
				print(" _____");
				print("|    O");
				print("|  --|--    " + wrongLetters);
				print("|  _/ \\");
				print("|");
				break;
			case 10:
				print(clue);
				print(" _____");
				print("|    O");
				print("|  --|--    " + wrongLetters);
				print("|  _/ \\_");
				print("|");
				break;
		}
	}
	
	private void blankOutClue() { 
		// Start with an empty clue
		clue = "";
		
		for(int i = 0; i < phrase.length(); i++) {
			// for each letter in the phrase
			char letter = phrase.charAt(i);
			// if the letter is a blank, add a blank to the clue
			if(letter == ' ') {
				clue += ' ';
			}
			// if the letter is anything else, add a dash to the clue
			else {
				clue += '-';
			}
		}
		//print(clue);
	}

	public static void main(String[] args) {
		new Hangman();
	}

}
