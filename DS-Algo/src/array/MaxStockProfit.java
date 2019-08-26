package array;

/* Given an array representing prices of the stock on different days,
* find the maximum profit that can be earned by buying and selling stocks.
* There are multiple variations of this problem, each of them given below.
*/

public class MaxStockProfit {

	public static void main(String[] args) {
		int price[] = { 10, 22, 5, 75, 65, 80 }; // 75, 97, 87
		// int price[] = { 12, 14, 17, 10, 14, 13, 12, 15 }; // 5, 12 , 10
		// int price[] = { 100, 80, 120, 130, 70, 60, 100, 125 }; // 65, 115, 115
		// int price[] = { 100, 80, 70, 65, 60, 55, 50 }; // 0, 0, 0
		System.out.println(maxProfit(price));
		System.out.println(maxProfitMultipleTransactions(price));
		System.out.println(maxProfitTwoTransactions(price));

	}

	/*
	 * Given an array representing prices of the stock on different days, find the
	 * maximum profit that can be earned by performing maximum of one transaction. A
	 * transaction consists of activity of buying and selling the stock on different
	 * or same days.
	 * 
	 * Note that you cannot sell a stock before you buy one.
	 * 
	 * Time complexity O(n) 
	 * Space complexity 0(1)
	 */

	private static int maxProfit(int[] prices) {

		if (prices == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = prices.length;
		if (length == 1) {
			return 0;
		}

		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}
		return maxProfit;
	}

	/*
	 * Given an array representing prices of the stock on different days, Design an
	 * algorithm to find the maximum profit. You may complete as many transactions
	 * as you like (i.e., buy one and sell one share of the stock multiple times).
	 * 
	 * Note: You may not engage in multiple transactions at the same time (i.e., you
	 * must sell the stock before you buy again).
	 * 
	 * Time complexity O(n) 
	 * Space complexity 0(1)
	 */

	private static int maxProfitMultipleTransactions(int[] prices) {

		if (prices == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = prices.length;
		if (length == 1) {
			return 0;
		}

		int maxProfit = 0;
		for (int i = 0; i < length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				maxProfit += prices[i + 1] - prices[i];
			}
		}
		return maxProfit;
	}

	/*
	 * Given an array representing prices of the stock on different days, Design an
	 * algorithm to find the maximum profit. You may complete at most two
	 * transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (i.e., you
	 * must sell the stock before you buy again).
	 * 
	 * Time complexity O(n) 
	 * Space complexity 0(1)
	 */

	private static int maxProfitTwoTransactions(int[] prices) {

		if (prices == null) {
			throw new NullPointerException("Initialize array");
		}

		int length = prices.length;
		if (length == 1) {
			return 0;
		}

		int buyOne = Integer.MAX_VALUE, buyTwo = Integer.MAX_VALUE;
		int sellOne = 0, sellTwo = 0;

		for (int i = 0; i < length; i++) {
			buyOne = Math.min(buyOne, prices[i]);
			sellOne = Math.max(sellOne, prices[i] - buyOne);
			buyTwo = Math.min(buyTwo, prices[i] - sellOne);
			sellTwo = Math.max(sellTwo, prices[i] - buyTwo);
		}
		return sellTwo;
	}
}
