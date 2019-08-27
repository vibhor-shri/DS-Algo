package array;

import java.util.Arrays;

/*
 * Given a binary array consisting of only 0's and 1's, sort it in linear time and constant space.
 */

public class SortBinaryArrayInLinearTime {

	public static void main(String[] args) {
		// int[] array = { 1, 0, 1, 0, 1, 0, 0, 1 };
		// int[] array = { 1, 1, 1, 1, 1, 1, 1, 1 };
		// int[] array = { 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] array = { 1, 1, 1, 1, 0, 0, 0, 0 };
		System.out.println(Arrays.toString(sort(array)));

	}

	/*
	 * Given below is the solution in linear time and constant space. There are are couple of more approaches, 
	 * but they are not provided as both the time & space complexity remain the same in them. 
	 * 
	 * Time complexity O(n)
	 * Space complexity O(1)
	 */
	
	
	private static int[] sort(int[] array) {
		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = array.length;
		int index = length - 1;

		for (int i = length - 1; i >= 0; i--) {
			if (array[i] != 0) {
				array[index--] = array[i];
			}
		}

		for (int i = index; i >= 0; i--) {
			array[i] = 0;
		}
		return array;
	}

}
