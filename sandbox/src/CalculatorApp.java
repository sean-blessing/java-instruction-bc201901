import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to my Calculator App!");
		
		// declare a Scanner
		Scanner sc = new Scanner(System.in);
		// define 2 ints
		System.out.print("Enter int a:  ");
		int a = sc.nextInt();
		System.out.print("Enter int b:  ");
		int b = sc.nextInt();

		// define sum, diff, product, quotient
		int sum = a + b;
		int diff = a - b;
		int product = a * b;
		int quotient = a / b;
		
		System.out.println("Sum:      " + sum);
		System.out.println("Diff:     "+diff);
		System.out.println("Product:  "+product);
		System.out.println("Quotient: "+quotient);
		

		System.out.println("Bye!");
	}

}
