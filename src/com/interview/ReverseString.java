package com.interview;

/**
 * 
 * @author ERIC
 *
 */
public class ReverseString {

	/**
	 * Function receives a sentense inform of a String, returns a reversed
	 * 
	 */
	public static String reverseSentense(String s) {

		String rev = "";

		// Remove multiple spaces/ clean the string
		String cleanedS = s.trim().replaceAll("\\s{2,}", " ").trim();

		// Breaking the sentence into words
		String sArray[] = cleanedS.split(" ");

		// Adding the words stored in the array to the last
		for (int i = 0; i < sArray.length; i++) {
			rev = sArray[i] + " " + rev;
		}

		return rev;
	}

	public static void main(String[] args) {
		String s = "This is my name";

		String rev = reverseSentense(s);

		System.out.println(rev);

	}

}
