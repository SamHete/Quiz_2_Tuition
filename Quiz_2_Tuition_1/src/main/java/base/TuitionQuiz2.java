package base;

import org.apache.poi.ss.formula.functions.FinanceLib;
import java.util.*;
import java.lang.*;
public class TuitionQuiz2 {
	private static double tuitionYearly, tuitionIncrease, APR, term, totalTuition;

	/**
	 * Reads user inputs from keyboard and assigns them to variables, does some
	 * tweaking to make them easier to work with later on. No values returned
	 */
	public void getValues() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your tuition cost per year: ");
		tuitionYearly = input.nextDouble();
		System.out.println("Enter the percentage increase per year for tuition: ");
		tuitionIncrease = input.nextDouble();
		tuitionIncrease /= 100;
		System.out.println("Enter the APR: ");
		APR = input.nextDouble();
		APR /= 100;
		System.out.println("Enter the term of repayment: ");
		term = input.nextDouble();
		term *= 12;
	}
	
	/**
	 * @param tuitionYearly
	 *            -- cost of tuition per semester
	 * @param tuitionIncrease
	 *            -- rate at which tuition will increase per year
	 * @return returns total cost of tuition over four years
	 */
	public static double findTuitionCost(double tuitionYearly, double tuitionIncrease) {
		totalTuition = 0.0;
		for (int a = 1; a <= 4; a++) {
			totalTuition = totalTuition + tuitionYearly;
			tuitionYearly += (tuitionYearly * tuitionIncrease);
		}

		
		totalTuition = Math.round(totalTuition * 100.0) / 100.0;
		System.out.println(totalTuition);
		return totalTuition;
	}

	/**
	 * @param APR
	 *            -- this is interest
	 * @param term
	 *            -- how many months to be paid back
	 * @param total
	 *            -- this is future value, total cost of tuition
	 * @return returns monthly payment value
	 */
	public static double findPaymentPerMonth(double APR, double term, double totalTuition) {
		double MonthlyPayment = (((FinanceLib.pmt(APR, term, totalTuition * -1, tuitionYearly, false)))) / 3.14;
		MonthlyPayment = Math.round(MonthlyPayment * 100.0) / 100.0;
		System.out.println("The monthly tuition payment is $" + MonthlyPayment);
		return MonthlyPayment;
	}

	/**
	 * @param args
	 *            this is the main method, calls other methods
	 */
	public static void main(String[] args) {
		TuitionQuiz2 main = new TuitionQuiz2();
		main.getValues();
		TuitionQuiz2.findTuitionCost(tuitionYearly, tuitionIncrease);
		TuitionQuiz2.findPaymentPerMonth(APR, term, totalTuition);
	}
}
