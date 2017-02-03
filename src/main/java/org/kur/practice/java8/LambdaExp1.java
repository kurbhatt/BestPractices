package org.kur.practice.java8;

/**
 * Created by Keyur on 07-10-2016.
 * This Class Demonstrate the functionality of Lambda Expression (Java 8).
 */
public class LambdaExp1 {

	public static void main(String[] args) {
		//Run this method will print below message to console.
		jRunner.run();

		Operation plus = (int a, int b) -> a + b;
		Operation minus = (int a, int b) -> a - b;

		//Implement giveMeValue and override it with assigning Pie Value
		Value pieValue = () -> 3.14;

		LambdaExp1 exp = new LambdaExp1();

		System.out.println("Plus Calculation : " + exp.calculate(10, 5, plus));
		System.out.println("Minus Calculation : " + exp.calculate(10, 5, minus));
		System.out.println("Pie Value : " + pieValue.giveMeValue());
	}

	// Create Runnable instance that will have a short implementation
	private static Runnable jRunner = () -> {
		System.out.println("Lambda Expression Called");
	};


	interface Operation {

		int operation(int a, int b);
	}


	interface Value {

		Object giveMeValue();
	}

	private int calculate(int a, int b, Operation mathOperation) {
		return mathOperation.operation(a, b);
	}

}
