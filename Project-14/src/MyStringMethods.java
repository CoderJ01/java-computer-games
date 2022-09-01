package programmer.coderj.mystringmethods;

import java.util.Random;

public class MyStringMethods {

	public static String scramble(String word) {
		String scrambled = "";
		Random rand = new Random();
		
		// repeat these steps until all the letters have been removed from the original word
		while(word.length() > 0) {
			// pick a random letter from the original word
			int length = word.length();
			int index = rand.nextInt(length);
			System.out.println("index = " + index);
			String letter = word.substring(index, index + 1);
			System.out.println("letter = " + letter);
			
			// remove that letter from the original word
			String firstString = word.substring(0, index);
			String secondString = word.substring(index + 1);
			word = firstString + secondString;
			System.out.println("word = " + word);
			
			// add that letter to a new word
			scrambled += letter;
			System.out.println("scrambled = " + letter);
		}

		return scrambled;
	}
	
	public static String replaceStringAt(String originalString, int index, String replaceString) {
		String newString = originalString;
		// replace the string only if the index is inside the original string
		if (index <= originalString.length()) {
			// if replaceString is too long to fit, truncate it
			int roomAvailible = originalString.length() - index;
			if(replaceString.length() > roomAvailible) {
				replaceString = replaceString.substring(0, roomAvailible);
			}
			String firstString = originalString.substring(0, index);
			String secondString = originalString.substring(index + replaceString.length());
			newString = firstString + replaceString + secondString;
		}
		return newString;
	}
}