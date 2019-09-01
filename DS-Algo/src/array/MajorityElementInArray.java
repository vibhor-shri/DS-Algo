package array;

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 */

public class MajorityElementInArray {

	public static void main(String[] args) {

		// int[] array = { 2, 2, 1, 1, 1, 2, 2 };
		int[] array = { 3, 2, 3 };
		System.out.println(majorityElement(array));

	}

	/*
	 * The below approach makes use of the boyer moore voting algorithm.
	 * 
	 * Time complexity O(n) 
	 * Space complexity O(1)
	 */

	private static int majorityElement(int[] array) {

		if (array == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = array.length;

		int index = 0;
		int majorityElement = -1;

		for (int i = 0; i < length; i++) {

			if (index == 0) {
				majorityElement = array[i];
				index = 1;
			} else if (majorityElement == array[i]) {
				index++;
			} else {
				index--;
			}
		}

		return majorityElement;
	}

}
