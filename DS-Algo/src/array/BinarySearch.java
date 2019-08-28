package array;

/*
 * A basic implementation of a binary search. Binary search only works for sorted arrays, 
 * and return the index at which the element is present, -1 otherwise.
 */

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int key = 6;
		System.out.println(binarySearchIterative(array, key));
		System.out.println(binarySearchRecursive(array, 0, array.length-1, key));

	}

	/*
	 * Iterative implementation
	 */

	private static int binarySearchIterative(int[] array, int key) {

		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = low + ((high - low) / 2);

			if (array[mid] == key) {
				return mid;
			} else if (key < array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	/*
	 * Recursive implementation
	 */

	private static int binarySearchRecursive(int[] array, int low, int high, int key) {

		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		if (low > high) {
			return -1;
		}

		int mid = low + ((high - low) / 2);

		if (array[mid] == key) {
			return mid;
		} else if (key > array[mid]) {
			return binarySearchRecursive(array, mid + 1, high, key);
		} else {
			return binarySearchRecursive(array, low, mid - 1, key);
		}
	}

}
