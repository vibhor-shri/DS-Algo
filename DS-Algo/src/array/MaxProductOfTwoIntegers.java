package array;

import java.util.Arrays;

/*
 * Given an array of integers (both positive and negative), find the maximum possible product
 * between two numbers in the array.
 */

public class MaxProductOfTwoIntegers {

	public static void main(String[] args) {
		// int[] array = {-10,-3,5,6,2};
//		int[] array = { -10, -3, 5, 6, -20 };
//		int[] array = { 1, 4, 3, 6, 7, 0 };
		int[] array = { -1, -3, -4, 2, 0, -5 };
		System.out.println(maxProductUsingSorting(array));
		System.out.println(maxProduct(array));

	}

	/*
	 * A naive approach is to sort the array, using any custom sorting algorithm,
	 * or standard sorting algorithm, and calculate the product of first 2 elements
	 * and last 2 elements and return whichever is highest.
	 * 
	 * Time complexity O(n log(n))
	 * Space complexity O(n) (considering merge sort)
	 */
	
	
	private static long maxProductUsingSorting(int[] array) {
		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = array.length;

		if (length < 2) {
			throw new IndexOutOfBoundsException("Invalid length");
		}

		Arrays.sort(array);

		return array[0] * array[1] > array[length - 1] * array[length - 2] ? array[0] * array[1]
				: array[length - 1] * array[length - 2];
	}

	/*
	 * A linear time approach is to keep track of 2 maximum elements seen so far, and return their product.
	 * However, the elements are considered based on their absolute value, and not actual value.
	 * 
	 * Time complexity O(n)
	 * Space complexity O(1)
	 */
	
	private static long maxProduct(int[] array) {
		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = array.length;

		if (length < 2) {
			throw new IndexOutOfBoundsException("Invalid length");
		}

		int max1 = Math.abs(array[0]), max2 = Math.abs(array[1]);
		if (max1 < max2) {
			int temp = max2;
			max2 = max1;
			max1 = temp;
		}

		for (int i = 2; i < length; i++) {
			if (Math.abs(array[i]) > max1) {
				max2 = max1;
				max1 = Math.abs(array[i]);
			}
		}

		return max1 * max2;
	}

}
