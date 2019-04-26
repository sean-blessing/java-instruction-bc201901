
public class StaticMethodDemo {

	public static void main(String[] args) {
		//System.out.println("Welcome to my static method app");
		//printWelcomeMessage();
		int n = 27;
				
		//printMessage("Welcome to my static method app", n);
		System.out.println(buildMessage("Welcome to my static method app", n));
		String s1 = buildMessage("Bootcamp rocks!!!!!!", 4.5);
		System.out.println(s1);
		
		System.out.println();
		//System.out.println("bye");
		//printByeMessage();
		printMessage("Bye", n);
	}

	private static String buildMessage(String s, int j) {
		String str = s + ".  The number is " + j;
		return str;
	}
	
	private static String buildMessage(String s, double j) {
		String str = s + ".  The number is " + j;
		return str;
	}

	
	private static void printMessage(String s, int j) {
		System.out.println(s+".  The number is "+j);
	}
	
	private static void printWelcomeMessage() {
		System.out.println("Welcome to my static method app");
	}

	private static void printByeMessage() {
		System.out.println("Bye");
	}
}
