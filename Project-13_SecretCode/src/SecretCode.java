package programmer.coderj.secretcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import programmer.coderj.mywindow.MyWindow;

public class SecretCode extends MyWindow {

	public SecretCode() {
		String fileName = "key.txt";
		try {
			// read the alphabet and key from the file
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
			String alphabet = in.readLine();
			String key = in.readLine();
			in.close();
			
			boolean quit = false;
			while(!quit) {
				String option = promptForString("Would you like to encode message, decode, or quit?");
				switch(option) {
					// quit
					case "Q":
					case "q":
						quit = true;
						break;
					// encode
					case "E":
					case "e":
						String messageToEncode = promptForString("Enter a message to encode:");
						String encodedMessage = encode(messageToEncode, alphabet, key);
						print(encodedMessage + "\n");
						break;
					// decode
					case "D":
					case "d":
						String messageToDecode = promptForString("Enter a message to decode:");
						String decodedMessage = encode(messageToDecode, key, alphabet);
						print(decodedMessage + "\n");
						break;
					default:
						print(option + " is not a valid option.");
				}
			}
			System.exit(0);
		}
		catch(FileNotFoundException e) {
			print("Could not find file " + fileName + ".");
		}
		catch(IOException e) {
			print("Could not open file " + fileName + ".");
		}
	}
	
	private String encode(String message, String fromAlphabet, String toAlphabet) {
		String newMessage = "";
		
		// repeat these steps using the next letter in the message
		for(int i = 0; i < message.length(); i++) {
			// take the first letter of the message
			String letter = message.substring(0, 1);
			
			// find the index of that letter in the "from alphabet"
			int letterPos = fromAlphabet.indexOf(letter);
			
			// if the letter is in the "from alphabet", get the letter in 
			// the same position of the "to alphabet" and add that new letter to the message
			if(letterPos > -1) {
				String newLetter = toAlphabet.substring(letterPos, letterPos + 1);
				newMessage += newLetter;
			}
			// if the letter isn't in the "from alphabet", add that letter to the new message
			else {
				newMessage += letter;
			}
		}
		return newMessage;
	}

	public static void main(String[] args) {
		new SecretCode();
	}

}