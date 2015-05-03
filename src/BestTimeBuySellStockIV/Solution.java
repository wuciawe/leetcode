package BestTimeBuySellStockIV;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return sum(prices, len);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int sum(int[] prices, int len) {
        int result = 0;
        for (int i = 1; i < len; i++)
            if (prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
        return result;
    }
}
