package array;

import java.util.Arrays;

/*
 * Given an array of integers, move all 0's to the end of it,
 *  while maintaining the relative order of the non-zero elements.
 *  
 *  Time complexity O(n)
 *  Space complexity O(1)
 */

public class MoveZeros {

	public static void main(String[] args) {
//		int[] array = { 0, 1, 0, 3, 12 };
//		int[] array = {1, 2, 0, 4, 3, 0, 5, 0};
		int[] array = {1, 2, 0, 0, 0, 3, 6};
//		int[] array = {1, 2, 5, 7, 9, 3, 6};
		System.out.println(Arrays.toString(moveZeros(array))); 
	}

	private static int[] moveZeros(int[] array) {
		if (array == null) {
			return null;
		}

		int index = 0;
		int length = array.length;
		for (int i = 0; i < length; i++) {
			if (array[i] != 0) {
				array[index++] = array[i];
			}
		}
		if (index < length - 1) {
			for (int i = index; i < length; i++) {
				array[i] = 0;
			}
		}
		return array;
	}
}
