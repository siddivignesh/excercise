package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MyPractice {

	public static void main(String[] args) {
		String str = "123";
		String s2 = "vignesh";
		int i = 5;
		int j = 10;
		int z = 7;
		int arr[] = { 1, 5, 3, 7 };
		List<Number> numbers = new ArrayList<Number>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(7);
		// I want answer line 612
		// System.out.println(reverse(str));
		System.out.println(flipDigits(str));
		System.out.println(StringBuilderTest(s2));
		SwapNumbers(5, 10);
		// System.out.println(Prime(z));
		//System.out.println(Odd(numbers));
		System.out.println(Odd1(numbers));
	}

	/*
	 * public static String reverse(String in) { if (in == null) throw new
	 * IllegalArgumentException("Null is not valid input");
	 * 
	 * StringBuilder out = new StringBuilder();
	 * 
	 * char[] chars = in.toCharArray();
	 * 
	 * for (int i = chars.length - 1; i >= 0; i--) out.append(chars[i]);
	 * 
	 * return out.toString(); }
	 */
	public static String flipDigits(String in) {
		if (in == null)
			throw new IllegalArgumentException("Null is not valid input");

		StringBuilder out = new StringBuilder();

		char[] chars = in.toCharArray();
		int i;
		// int j = 5;
		for (i = chars.length - 1; i >= 0; i--) {
			// for (i = 0; i < chars.length; i += 2, j += 3) {

			System.out.println("i : " + i);
			System.out.println("chars : " + chars[i]);

			// int val = chars[i];
			int val = Character.getNumericValue(chars[i]);
			System.out.println("Characters value : " + val);
			System.out.println(10 - val);
			// System.out.println("j0 :" + j);
			System.out.println(chars[i]);
			out.append(val);
		}
		// System.out.println("i2 :" + i);
		// i = j + 3;

		// System.out.println("i3 :" + i);
		// System.out.println("j1 :" + j);

		return out.toString();

	}

	public static String StringBuilderTest(String s1) {

		StringBuilder out = new StringBuilder();
		// out.append(s1);
		// out.append(s1);
		for (int i = 0; i < 5; i++) {
			out.append(s1);
			if (i != 4) {
				out.append(" ");
			} else {
				out.append(".");
			}
			// System.out.println(out.toString());
		}
		return out.toString();
	}

	public static void SwapNumbers(int i, int j) {

		System.out.println("in the begining i :" + i + "j :" + j);
		int k = i;
		i = j;
		j = k;

		System.out.println("at the end i :" + i + "j :" + j);

	}

	//

	// class

	public static boolean Odd(List<Number> numbers) {
		for (Number i : numbers) {
			if ((int)i % 2 == 0) {
				 System.out.println(i);
				return false;
			}

		}
		return true;

	}
	 
	 

	public static boolean Odd1(List<Number> numbers) {

		for (int i = 0; i < numbers.size(); i++) {
			if (i % 2 == 0) {
				// System.out.println(i);
				return false;
			}
 
		}
		return true;
	} 
}