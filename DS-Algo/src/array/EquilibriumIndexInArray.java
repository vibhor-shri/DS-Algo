package array;

/*
 * Given an array of numbers, both positive and negative, find the Equilibrium index.
 * 
 * An equilibrium index is such where the sum of elements at the left of it, and the sum of elements at the right of it
 * are equal, excluding the value at the index itself.
 */

public class EquilibriumIndexInArray {

	public static void main(String[] args) {
		int[] array = { 0, -3, 5, -4, -2, 3, 1, 0 };
		equlibriumIndex(array);

	}

	/*
	 * Simple approach is to take the sum of all the elements in the array, then
	 * traverse it from the end and check if the total - total at right sub array is
	 * equal.
	 * 
	 * Time complexity O(n)
	 * Space complexity O(1)
	 */

	private static void equlibriumIndex(int[] array) {

		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = array.length;
		if (length == 0) {
			return;
		}

		int total = 0;
		int totalRight = 0;
		for (int i : array) {
			total += i;
		}

		for (int i = length - 1; i >= 0; i--) {

			if (totalRight == total - (array[i] + totalRight)) {
				System.out.println("Equilibrium index found at = " + i);
			}

			totalRight += array[i];
		}
	}

}
