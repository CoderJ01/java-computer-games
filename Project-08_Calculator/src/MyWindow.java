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
}
