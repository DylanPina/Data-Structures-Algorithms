package LeetCode.Neetcode150.SlidingWindow;
/**
 * PROBLEM: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * SOLUTION: https://www.youtube.com/watch?v=1pkOgXD63yU
 * BIG O: O(n)
 */
public class BestTimeBuySellStock {

    public static int maxProfit(int[] prices) {
        int sell = 0;
        int buy = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < buy)
                buy = price;
            else
                sell = Math.max(sell, price - buy);
        }

        return sell;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}
