package programmer.coderj.sillystory;

import com.godtsoft.diyjava.DIYWindow;

public class SillyStory extends DIYWindow {

	public SillyStory() {
		// prompt
		print("Enter an animal");
		
		// variables
		String name = "Josh";
		String animal = input();
		
		print(""); // space for readability
		
		// output
		print(name + " had a little " + animal + ",");
		print("Whose fleece was white as snow,");
		print("And everywhere that " + name + " went,");
		print("The lamb was sure to go");
	}

	public static void main(String[] args) {
		new SillyStory();
	}
}
