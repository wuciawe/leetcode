package DivideTwoIntegers;

/**
 * Created by haha on 2015/4/25.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1 )) return Integer.MAX_VALUE;
        boolean samsig = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        int res = solver(dividend > 0 ? -dividend : dividend, divisor > 0 ? -divisor : divisor);
        return samsig ? res : -res;
    }

    private int solver(int dividend, int divisor){
        if(dividend > divisor) return 0;
        if(dividend == divisor) return 1;

        int q = 1;
        int t = divisor;
        int td = dividend >> 1;
        while(td < t){
            t <<= 1;
            q <<= 1;
        }
        return q + solver(dividend - t, divisor);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.divide(6, 2));
    }
}
