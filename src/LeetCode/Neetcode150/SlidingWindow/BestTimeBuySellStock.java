package LeetCode.Neetcode150.SlidingWindow;
/**
 * PROBLEM: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * SOLUTION: https://www.youtube.com/watch?v=1pkOgXD63yU
 * BIG O: O(n)
 */
public class BestTimeBuySellStock {

    public static int maxProfit(int[] prices) {
        int left = 0, right = 1; // left = buy, right = sell
        int maxProfit = 0;

        while (right < prices.length) {
            // Check if it is a profitable transaction
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left += 1;
            }
            right += 1;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}
