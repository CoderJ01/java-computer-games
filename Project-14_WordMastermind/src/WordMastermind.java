package programmer.coderj.wordmastermind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import programmer.coderj.mystringmethods.MyStringMethods;
import programmer.coderj.mywindow.MyWindow;

public class WordMastermind extends MyWindow {
	private String word;
	private String clue;
	private static final int NUMBEROFWORDS = 342;
	private static final String FILENAME = "wordMastermind.txt";

	public WordMastermind() {
		
		String words[] = new String[NUMBEROFWORDS];
		Random rand = new Random();
		
		try {
			// read list of words from the file
			BufferedReader in = new BufferedReader(new FileReader(new File(FILENAME)));
			for(int i = 0; i < NUMBEROFWORDS; i++) {
				words[i] = in.readLine();
			}
			in.close();
			
			boolean repeat = true;
			while(repeat == true) {
				int pick = rand.nextInt(words.length);
				word = words[pick];
				word.toUpperCase();
				
				// Prompt user for a guess
				print("I'm thinking of a 4 letter word.");
				print("I will give you clues:");
				print("An \"O\" means you guess the correct letter in the correct position");
				print("An \"X\" means you guess the correct letter but in the wrong position");
				String guess = promptForString("Guess my word:");
				guess = guess.toUpperCase();
				int count = 0;
				String orignalWord = word;
				boolean solved = false;
				
				// Repeat while not solved
				while(!solved) {
					
					if(guess.length() == 4) {
						// reset word and clue for each guess
						word = orignalWord;
						clue = "----";
						
						// set clue
						findRightPlaceLetters(guess);
						findWrongPlaceLetters(guess);
						
						// did he guess it?
						if(guess.equals(orignalWord)) {
							solved = true;
						}
						else {
							guess = promptForString(clue);
							guess.toUpperCase();
							count++;
						}
					}
					else {
						guess = promptForString("The word has four letters. Guess again.");
						guess = guess.toUpperCase();
					}
					
				}
				//clue = "----";
				
				// congratulate the user
				print("OOOO");
				print("You guessed it in " + count + " tries!");
				repeat = promptForYesNo("Would you like to play again?");
				print();
			}
			System.exit(0);
		}
		catch(FileNotFoundException e) {
			print("Could not find the file " + FILENAME);
		}
		catch(IOException e) {
			print("Could not read from file " + FILENAME);
		}
		
	}
	
	private void findRightPlaceLetters(String guess) {
		// loop through all the letters of the guess
		for(int i = 0; i < guess.length(); i++) {
			// get the letter in that position of the guess and word
			String guessLetter = guess.substring(i, i + 1);
			String wordLetter = word.substring(i, i + 1);
			// if guess letter is same as word letter, set clue to O and word to -
			if(guessLetter.equals(wordLetter)) {
				clue = MyStringMethods.replaceStringAt(clue, i, "O");
				word = MyStringMethods.replaceStringAt(word, i, "-");
			}
		}
	}
	
	private void findWrongPlaceLetters(String guess) {
		// loop through all the letters of the guess
		for(int i = 0; i < guess.length(); i++) {
			// get the letter in position i
			String letter = guess.substring(i, i + 1);
			// if the letter is in the word (indexOf > -1)
			int letterLoc = word.indexOf(letter);
			if(letterLoc > -1) {
				// replace letter in word with -
				word = MyStringMethods.replaceStringAt(word, letterLoc, "-");
				// set clue at the loop index of X if it is still -
				String clueLetter = clue.substring(i, i + 1);
				if(clueLetter.equals("-")) {
					clue = MyStringMethods.replaceStringAt(clue, i, "X");
				}
			}
			
		}
	}

	public static void main(String[] args) {
		new WordMastermind();
	}

}
