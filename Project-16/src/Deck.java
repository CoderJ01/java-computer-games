package programmer.coderj.mywindow;

import com.godtsoft.diyjava.DIYWindow;

public class MyWindow extends DIYWindow {
	protected double promptForDouble(String prompt) {
		double i = 0;
		print(prompt);
		String s = input();
		try {
			i = Double.parseDouble(s);
		}
		// print out error message if input is not a number
		catch (NumberFormatException e){
			print(s + " is not a valid number. Try again.");
			i = promptForDouble(prompt);
		}
		return i;
	}
	
	protected int promptForInt(String prompt) {
		int i = 0;
		print(prompt);
		String s = input();
		try {
			i = Integer.parseInt(s);
		}
		// print out error message if input is not a number
		catch (NumberFormatException e){
			print(s + " is not a valid number. Try again.");
			i = promptForInt(prompt);
		}
		return i;
	}
	
	protected String promptForString(String prompt) {
		print(prompt);
		String s = input();
		return s;
	}
	
	protected boolean promptForYesNo(String prompt) {
		boolean yes = true;
		boolean valid = false;
		while(!valid) {
			String YorN = promptForString("Would you like to repeat this?");
			switch(YorN) {
				case "Y":
				case "y":
					yes = true;
					valid = true;
					break;
				case "N":
				case "n":
					yes = false;
					valid = true;
					break;
				default:
					print("Enter Y for yes, or N for no");
					valid = false;
			}
		}
		return yes;
	}
	
	protected char promptForChar(String prompt) {
		char c = ' ';
		boolean valid = false;
		while(!valid) {
			print(prompt);
			String s = input();
			if(s.length() == 1) {
				c = s.charAt(0);
				valid = true;
			}
			else {
				c = promptForChar(prompt);
			}
		}
		return c;
	}
}
