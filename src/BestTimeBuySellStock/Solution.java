package BestTimeBuySellStock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int[] res = new int[1];
        List<Integer> l = new ArrayList<Integer>();
        l.add(prices[0]);
        for(int a = 1; a < prices.length - 1; ++a){
            if(prices[a] > prices[a - 1]){
                if(prices[a] >= prices[a + 1]){
                    l.add(prices[a]);
                }
            }else if(prices[a] < prices[a - 1]){
                if(prices[a] <= prices[a + 1]){
                    l.add(prices[a]);
                }
            }
        }
        l.add(prices[prices.length - 1]);
        prices = new int[l.size()];
        int i = 0;
        for (Integer e : l)
            prices[i++] = e;

        i = solver(res, prices, 0);
        while(i < prices.length){
            i = solver(res, prices, i + 1);
        }
        return res[0];
    }

    private int solver(int[] res, int[] prices, int beg){
        int high = beg + 1;
        for(int i = high + 1; i < prices.length; ++i){
            if(prices[i] >= prices[high]){
                high = i;
            }
        }
        if(high < prices.length){
            int low = beg;
            for(int i = beg + 1; i < high; ++i){
                if(prices[i] < prices[low]){
                    low = i;
                }
            }
            int profile = prices[high] - prices[low];
            if(profile >= res[0]){
                res[0] =  profile;
                return high;
            }else{
                return prices.length;
            }
        }else{
            return prices.length;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProfit(new int[]{5,5,4,9,3,8,5,5,1,6,8,3,4});
    }
}
