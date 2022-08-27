public class HelloWorld {
    public HelloWorld() {
        // variables
		String word1 = "Mercury";
		String word2 = "Venus";
		String statement = "The first planet is " + word1 + "\nThen comes " + word2;
		
        // outputs
		System.out.println("Hello World");
		System.out.println(word1);
		System.out.println(word2);
		System.out.println(statement);
		System.out.println("Annette said \"hi\".");
		
	}

    public static void main(String[] args) throws Exception {
        new HelloWorld();
    }
}
