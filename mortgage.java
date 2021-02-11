import java.util.Scanner;
import java.text.NumberFormat;

class mortgage{
	public static void main(String[] args) {
		

		int principal=0;
		float annualInterstRate=0;
		byte period=0;

		Scanner scanner = new Scanner(System.in);

		
		while (true) { 
			System.out.print("Principal ($1K - $1M): ");
			principal = scanner.nextInt();
			if (principal > 1000 && principal < 1000000) {
				break;
			}
			System.out.println("Enter a number btw 1,000 and 1,000,000");
		}


		while (true) {
			System.out.print("Annual Interest Rate: ");
			annualInterstRate = scanner.nextFloat();
			if (annualInterstRate > 0 && annualInterstRate < 30) {
				break;			
			}
			System.out.println("Enter a number btw 1 and 30");
			
		}
		
		while (true) {
			System.out.print("Period (Years): ");
			period = scanner.nextByte();	
			if (period > 0 && period < 30) {
				break		;
			}
			System.out.println("Enter a number btw 1 and 30.");
		}
		
		double mortgage = calculateMortgage(principal, annualInterstRate, period);

	  	String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + mortgageFormatted);
	}

	public static double calculateMortgage(int principal, float annualInterstRate, byte period) {
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;

		short numberOfPayments = (short)(period * MONTHS_IN_YEAR);
		float monthlyInterestRate = annualInterstRate / PERCENT / MONTHS_IN_YEAR;

		double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) 
						  / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

	  	return mortgage;
	}
}
 