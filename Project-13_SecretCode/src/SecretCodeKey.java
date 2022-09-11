package programmer.coderj.secretcodekey;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import programmer.coderj.mystringmethods.MyStringMethods;
import programmer.coderj.mywindow.MyWindow;

public class SecretCodeKey extends MyWindow {

	public SecretCodeKey() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String scrambled = MyStringMethods.scramble(alphabet);
		print(alphabet);
		print(scrambled);
		
		String fileName = "key.txt";
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(fileName)));
			out.write(alphabet);
			out.newLine();
			out.write(scrambled);
			out.close();
		}
		catch (IOException e){
			print("Could not open file " + fileName);
		}
	
	}

	public static void main(String[] args) {
		new SecretCodeKey();
	}

}
