package array;

import java.util.Arrays;

/*
 * Given an array where all its elements are sorted, except for two.Sort the array in one swap.
 */

public class SortAnArrayUsingOnlyOneSwap {

	public static void main(String[] args) {
		 int[] array = { 3, 8, 6, 7, 5, 9 };
//		 int[] array = { 9, 5, 6, 7, 8, 3 };
//		int[] array = { 3, 5, 6, 9, 8, 7 };
//		 int[] array = { 3, 5, 7, 6, 8, 9 };
		System.out.println(Arrays.toString(sortInSingleSwap(array)));
	}
	
	/*
	 * Time complexity O(n)
	 * Space complexity O(1) 
	 */

	private static int[] sortInSingleSwap(int[] array) {

		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int x = -1, y = -1;
		int prev = array[0];

		for (int i = 1; i < array.length; i++) {
			if (prev > array[i]) {
				if (x == -1) {
					x = i - 1;
					y = i;
				} else {
					y = i;
				}
			}
			prev = array[i];
		}

		swap(array, x, y);

		return array;
	}

	private static void swap(int[] array, int index1, int index2) {

		if (index1 == -1 || index2 == -1)
			return;

		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;

	}

}
