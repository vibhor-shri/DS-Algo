package string;

import java.util.Arrays;

/*
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

public class ReverseString {

	public static void main(String[] args) {
//		char[] array = { 'h', 'e', 'l', 'l', 'o' };
		char[] array = { 'w', 'o', 'r', 'l', 'd' };
		reverse(array);

	}

	private static void reverse(char[] array) {
		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = array.length;
		int start = 0;
		int end = length - 1;

		while (start <= end) {
			char c = array[start];
			array[start] = array[end];
			array[end] = c;
			start++;
			end--;

		}

		System.out.println(Arrays.toString(array));

	}

}
