package BestTimeBuySellStockII;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int result = 0;
        int lastin = prices[0];
        int i = 1;
        int len = prices.length;
        while(true){
            if(i == prices.length){
                if(prices[i - 1] > lastin)
                    result += (prices[i - 1] - lastin);
                break;
            }
            if(prices[i] < prices[i - 1]){
                result += (prices[i - 1] - lastin);
                lastin = prices[i];
            }
            ++i;
        }
        return result;
    }
}
