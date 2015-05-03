package BestTimeBuySellStockIII;

/**
 * Created by haha on 2015/5/2.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;

        int[][] t = new int[3][len];
        for (int i = 1; i < 3; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[2][len - 1];
    }
}
