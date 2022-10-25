package com.interview;

public class Fibonacci {

	/**
	 * Function tat accepts a number and returns a number in that position
	 * 
	 * @return
	 */
	static int fibonacci(int i) {
		if (i < 2)
			return i;
		return fibonacci(i - 1) + fibonacci(i - 2);
	}

	public static void main(String[] args) {
		int value = fibonacci(10);
		System.out.println("Value in the position ::: \n" + value);
	}

}
