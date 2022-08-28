package programmer.coderj.calculator;

import programmer.coderj.mywindow.MyWindow;

public class Calculator extends MyWindow {

	public Calculator() {
		addIntegers();
	}
	
	private void addIntegers() {
		String repeat = "";
		
		while(repeat.equals("") || repeat.equals("yes")) {
			double a = promptForDouble("Enter a number");
			double b = promptForDouble("Enter a number");
			
			promptForOperation(a, b);
			
			print("Would you like to do another calculation? Enter yes or no.");
			repeat = input();
		}
		
		if(repeat.equals("no")) {
			print("Thank you for tinkering!");
		}
	}
	
	private double promptForOperation(double a, double b) {
		print("Choose an operation to perform:");
		print("a) Addition");
		print("b) Subtraction");
		print("c) Multiplication");
		print("d) Division");
		print("e) Remainder of division");
		String operation = input();
		double c = 0;
		switch(operation) {
		case "a":
			c = a + b;
			print(a + " + " + b + " = " + c);
			break;
		case "b":
			c = a - b;
			print(a + " - " + b + " = " + c);
			break;
		case "c":
			c = a * b;
			print(a + " * " + b + " = " + c);
			break;
		case "d":
			try {
				c = a / b;
				print(a + " / " + b + " = " + c);
			}
			catch(ArithmeticException e) {
				print("Division by zero is not allowed");
			}
			break;
		case "e":
			c = a % b;
			print(a + " % " + b + " = " + c);
			break;
		default:
			print("Invalid operation was entered.");
		}
		return 0;
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
