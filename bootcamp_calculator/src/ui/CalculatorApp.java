package ui;

import business.Calculator;
import util.Console;

public class CalculatorApp {

	public static void main(String[] args) {
		//Requirements:
		// 1) provide basic calculator functions:  +, -, *, /, and %
		// 2) prompt user for 2 numbers
		// 3) perform calculation
		// 4) display result
		
		System.out.println("Welcome to the Calculator App");
		

		double result = 0.0;
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int a = Console.getIntWithinRange("Enter 1st #:  ", 0, Integer.MAX_VALUE);
			String opr = Console.getRequiredString("Operation (+ - * / %)?  ");
			int b = Console.getIntWithinRange("Enter 2nd #:  ", 0, Integer.MAX_VALUE);
			Calculator calc = new Calculator(a,b);
			if (opr.equals("+")) {
				result = calc.add();
			}
			else if (opr.equals("-")) {
				result = calc.subtract();
			}
			else if (opr.equals("*")) {
				result = calc.multiply();
			}
			else if (opr.equals("/")) {
				result = calc.divide();
			}
			else if (opr.equals("%")) {
				result = calc.modulus();
			}
			System.out.println("Result = "+ result);
			choice = Console.getRequiredString("Continue??");
		}		
		System.out.println("Bye");

	}


}
