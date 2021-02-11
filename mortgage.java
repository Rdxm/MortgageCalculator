import java.util.Scanner;
import java.text.NumberFormat;

class mortgage{
	public static void main(String[] args) {
		int principal = (int)readNumber("Principal ($1K - $1M): ", 1000000, 1000);
		float annualInterstRate = (float)readNumber("Annual Interest Rate: ", 30, 1);
		byte period = (byte)readNumber("Years: ", 30, 1);
		
		
		double mortgage = calculateMortgage(principal, annualInterstRate, period);

	  	String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + mortgageFormatted);
	}

	public static double readNumber(String prompt, double max, double min) {
		Scanner scanner = new Scanner(System.in);
		double value;
		while (true) {
			System.out.print(prompt);
			value = scanner.nextFloat();
			if (value > min && value < max) {
				break;			
			}
			System.out.println("Enter a number btw "+min+" and "+max);
		}
		return value;
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
 