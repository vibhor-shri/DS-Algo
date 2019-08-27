package array;

import java.util.Arrays;

/*
 * Given an array of integers (both positive and negative), find and return the pair with the maximum 
 * product in the array.
 */

public class PairWithMaximumProduct {

	public static void main(String[] args) {
		// int[] array = {1, 4, 3, 6, 7, 0};
		// int[] array = {-1, -3, -4, 2, 0, -5};
		int[] array = { -10, -3, 5, 6, -2 };
		System.out.println(maxProductPairUsingSorting(array).toString());
		System.out.println(maxProductPair(array).toString());

	}

	/*
	 * A naive approach is to sort the array, using any custom sorting algorithm, or
	 * standard sorting algorithm, and calculate the product of first 2 elements and
	 * last 2 elements and return whichever pair's product is the highest.
	 * 
	 * Time complexity O(n log(n)) Space complexity O(n) (considering merge sort)
	 */

	private static Pair maxProductPairUsingSorting(int[] array) {
		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = array.length;

		if (length < 2) {
			throw new IndexOutOfBoundsException("Invalid length");
		}

		Arrays.sort(array);
		Pair pair = null;
		if (array[0] * array[1] > array[length - 1]) {
			pair = new Pair(array[1], array[0]);
		} else {
			pair = new Pair(array[length - 2], array[length - 1]);
		}

		return pair;
	}

	/*
	 * The below approach keeps track of the 2 smallest elements and the 2 largest
	 * elements.
	 * 
	 * Time complexity O(n)
	 * Space complexity O(1)
	 */

	private static Pair maxProductPair(int[] array) {
		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = array.length;

		if (length < 2) {
			throw new IndexOutOfBoundsException("Invalid length");
		}

		Pair pair = null;
		if (length == 2) {
			if (array[0] * array[1] > array[length - 1]) {
				pair = new Pair(array[0], array[1]);
			} else {
				pair = new Pair(array[length - 1], array[length - 2]);
			}
		}

		int smallest = array[0], secondSmallest = array[1];
		int largest = array[0], secondLargest = array[1];

		if (smallest > secondSmallest) {
			int temp = secondSmallest;
			secondSmallest = smallest;
			smallest = temp;
		}

		if (largest < secondLargest) {
			int temp = secondLargest;
			secondLargest = largest;
			largest = temp;
		}

		for (int i = 2; i < length; i++) {

			if (array[i] >= largest) {
				secondLargest = largest;
				largest = array[i];
			} else if (array[i] > secondLargest) {
				secondLargest = array[i];
			}

			if (array[i] <= smallest) {
				secondSmallest = smallest;
				smallest = array[i];
			} else if (array[i] < secondSmallest) {
				secondSmallest = array[i];
			}

		}

		if ((smallest * secondSmallest) >= (largest * secondLargest)) {
			pair = new Pair(secondSmallest, smallest);
		} else {
			pair = new Pair(secondLargest, largest);
		}

		return pair;
	}

}
