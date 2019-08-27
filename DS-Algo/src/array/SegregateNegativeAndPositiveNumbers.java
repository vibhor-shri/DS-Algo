package array;

import java.util.Arrays;

/*
 * Given an array of negative and positive integers, segregate them in constant space, no additional data structure to be used
 * Negative numbers should appear before positive numbers.
 */

public class SegregateNegativeAndPositiveNumbers {

	public static void main(String[] args) {
		int[] array = { 9, -3, 5, -2, -8, -6, 1, 3 };
		// -3, 9, 5, -2, -8, -6, 1, 3
		// -3, -2, 5, 9, -8, -6, 1, 3
		// -3, -2, -8, 9, 5, -6, 1, 3
		// -3, -2, -8, -6, 5, 9, 1, 3
		System.out.println(Arrays.toString(segregateNumbers(array)));

	}

	private static int[] segregateNumbers(int[] array) {
		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int negativeIndex = 0;
		int length = array.length;

		for (int i = 0; i < length; i++) {

			if (array[i] < 0) {
				swap(i, negativeIndex, array);
				negativeIndex++;
			}
		}

		return array;
	}

	private static void swap(int i, int negativeIndex, int[] array) {
		int temp = array[i];
		array[i] = array[negativeIndex];
		array[negativeIndex] = temp;
	}

}
