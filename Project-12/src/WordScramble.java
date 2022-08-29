package programmer.coderj.wordscramble;

import programmer.coderj.mystringmethods.MyStringMethods;
import programmer.coderj.mywindow.MyWindow;

public class WordScramble extends MyWindow {

	public WordScramble() {
		String words[] = {"ANIMALS", "ELEPHANT", "GIRAFFE", "PENGUIN"};
		int numberOfWords = words.length;
		// for each word in the list, scramble the word and print it
		for(int i = 0; i < numberOfWords; i++) {
			String scrambled = MyStringMethods.scramble(words[i]);
			print(scrambled);
		}
	}

	public static void main(String[] args) {
		new WordScramble();
	}

}