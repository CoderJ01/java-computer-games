package programmer.coderj.chooseanadventure;

import com.godtsoft.diyjava.DIYWindow;

public class ChooseAnAdventure extends DIYWindow {

	public ChooseAnAdventure() {
		startStory();
	}

	// methods
	// void method return no value, private methods can be used only in class it is declared in
	private void goUpTheHill() {
		print("Going up the hill.");
		String story = "On my way up the hill, a girl joined me.";
		story = story + " She told me her name was Jill";
		story = story + " She was carrying a pail.";
		story = story + " Theres also a trail of breadcrumbs going down another path";
		story = story + " Up the hill was a well.";
		story = story + " To the right was a small cottage.";
		
		print("Should I:");
		print("a) Ask Jill to join me?");
		print("b) Follow the trail of bread crumbs?");
		
		String choice = input();
		
		switch(choice) {
		case "a":
			goUpWithJill();
			break;
		case "b":
			followTheBreadCrumbs();
			break;
		default:
			goUpTheHill();
		}
	}
	
	private void checkCottage() {
		print("Checking the cottage");
	}
	
	private void plantBeans() {
		print("Planting beans");
	}
	
	private void startStory() {
		String story = "I woke up in an unfamiliar woods.";
		story = story + " I was hungry and I was tired.";
		story = story + " I didn't know where I was.";
		story = story + " In my pocket were three beans";
		story = story + " Up the hill was a well.";
		story = story + " To the right was a small cottage.";
		print(story);
		
		// question
		print("Should I:");
		print("a) Go up the hill?");
		print("b) Check out the cottage?");
		print("c) Plant the beans?");
		
		String choice = input(); // initialize input
		
		// conditional
		switch(choice) {
			case "a":
				goUpTheHill();
				break;
			case "b":
				checkCottage();
				break;
			case "c":
				plantBeans();
				break;
			default:
				startStory();
		}
	}
	
	private void goUpWithJill() {
		print("I enjoyed Jill's mythological tales");
	}
	
	private void followTheBreadCrumbs() {
		print("I followed the magical bread crumbs");
	}

	public static void main(String[] args) {
		new ChooseAnAdventure();
	}
}
