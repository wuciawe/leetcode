package FactorialTrailingZeros;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while(n != 0){
            n /= 5;
            cnt += n;
        }
        return cnt;
    }
}
