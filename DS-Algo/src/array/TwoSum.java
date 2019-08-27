package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* Given an unsorted array of integers, and a number K, find pairs of numbers in the array that sum up to K.
 * 
 */

public class TwoSum {

	public static void main(String[] args) {
		int[] array = { 3, 5, 2, -4, 8, 11 };
		int sum = 7;
		findPair(array, sum);
		System.out.println(checkIfPairExists(array, 12));
		ArrayList<Pair> pairs = findAllPairs(array, sum);
		if (pairs != null && pairs.size() > 0) {
			for (Pair pair : pairs) {
				System.out.println(pair.pairItemOne + " , " + pair.pairItemTwo);
			}
		}
	}

	/*
	 * 1st variation of the problem, print all pairs that sum up to a given number
	 * Time complexity O(n) 
	 * Space complexity O(n)
	 */
	private static void findPair(int[] array, int k) {
		if (array == null || array.length == 0 || array.length == 1) {
			System.out.println("Cannot find pairs in given array");
		}

		Set<Integer> numberSet = new HashSet<>();

		for (Integer num : array) {
			if (numberSet.contains(k - num)) {
				System.out.println((k - num) + " , " + num);
			} else {
				numberSet.add(num);
			}
		}
	}

	/*
	 * 2st variation of the problem, return true if a pair exists 
	 * Time complexity O(n)
	 * Space complexity O(n)
	 */
	private static boolean checkIfPairExists(int[] array, int k) {
		if (array == null || array.length == 0 || array.length == 1) {
			return false;
		}

		Set<Integer> numberSet = new HashSet<>();
		for (Integer num : array) {
			if (numberSet.contains(k - num)) {
				return true;
			} else {
				numberSet.add(num);
			}
		}
		return false;
	}

	/*
	 * 3rd variation of the problem, return an array list of all pairs that sum up to k 
	 * Time complexity O(n) 
	 * Space complexity - 
	 */
	private static ArrayList<Pair> findAllPairs(int[] array, int sum) {
		if (array == null || array.length == 0 || array.length == 1) {
			return null;
		}
		ArrayList<Pair> pairsList = new ArrayList<>();
		Set<Integer> numbersSet = new HashSet<>();

		for (Integer num : array) {
			if (numbersSet.contains(sum - num)) {
				Pair pair = new Pair(sum - num, num);
				pairsList.add(pair);
			} else {
				numbersSet.add(num);
			}
		}

		return pairsList.size() > 0 ? pairsList : null;
	}
}
