import java.math.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
		// 1 - Welcome
		System.out.println("Welcome to the Interest Calculator App!");
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// 2 - Prompt for input
			System.out.print("Enter loan amount:   ");
			//double loanAmt = sc.nextDouble();  original
			String loanAmtStr = sc.next();
			BigDecimal loanAmt = new BigDecimal(loanAmtStr);
			loanAmt = loanAmt.setScale(2, RoundingMode.HALF_UP);
			
			System.out.print("Enter interest rate: ");
			//double intRate = sc.nextDouble(); original
			String intRateStr = sc.next();
			BigDecimal intRate = new BigDecimal(intRateStr);
			
			// 3 - Biz logic
			BigDecimal intAmt = loanAmt.multiply(intRate);
			
			// 4 - Display results
			NumberFormat cf = NumberFormat.getCurrencyInstance();
			cf.setRoundingMode(RoundingMode.HALF_UP);
			NumberFormat pf = NumberFormat.getPercentInstance();
			pf.setMaximumFractionDigits(3);
			//pf.setMinimumFractionDigits(3);
			
			System.out.println("Loan amount:         "+cf.format(loanAmt));
			System.out.println("Interest rate:       "+pf.format(intRate));
			System.out.println("Interest:            "+cf.format(intAmt));
			
			System.out.print("Continue(y/n)?  ");
			choice = sc.next();
		}
		
		
		// 5 - bye
		System.out.println("Bye");
	}
	

}
